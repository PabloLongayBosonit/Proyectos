package com.sa2.ficheros.application;

import com.sa2.ficheros.domain.Archivo;
import com.sa2.ficheros.infraestructure.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.management.loading.MLet;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class ArchivoServiceImpl implements ArchivoService{


    @Autowired
    FileRepository fileRepository;

    private final Path rootLocation;

    @Autowired
    public ArchivoServiceImpl(StorageProperties properties){
        this.rootLocation = Paths.get(properties.getLocation());
    }
// G U A R D A D O  D E  D A T O S
    @Override
    public Archivo guardarDatos(MultipartFile file, String categoria) {
        Archivo archivo = new Archivo();
        archivo.setCategoria(categoria);
        archivo.setNombrearchivo(file.getOriginalFilename());
        archivo.setFechaSubida(new Date());

        Path test = this.rootLocation.resolve(file.getOriginalFilename());
        try{
            Resource resource = new UrlResource(test.toUri());
            archivo.setUrl(resource.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        archivo.setId(fileRepository.save(archivo).getId());
        return archivo;
    }

// B U S Q U E D A   P O R   N O M B R E
    @Override
    public ResponseEntity<?> getByName(String nombre) {
        try{
            return new ResponseEntity<>(fileRepository.findByNombre(nombre), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> findById(int id) {
        try {
            return new ResponseEntity<>(fileRepository.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<?> subirArchivo(MultipartFile file, String tipo) throws Exception{
        String nombre = file.getOriginalFilename();
        String[] partes = nombre.split("\\.");
        try {
            if (partes[1].equals(tipo)){
                return new ResponseEntity<>(this.guardarDatos(file,""),HttpStatus.OK);
            }
            else {
                throw new Exception("file extension not matching");
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}

