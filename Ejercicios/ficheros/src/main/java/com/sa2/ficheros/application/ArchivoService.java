package com.sa2.ficheros.application;

import com.sa2.ficheros.domain.Archivo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ArchivoService {

    Archivo guardarDatos(MultipartFile file, String categoria);

    ResponseEntity<?> getByName(String nombre);

    ResponseEntity<?> findById(int id);

    ResponseEntity<?> subirArchivo(MultipartFile file, String tipo) throws Exception;

}
