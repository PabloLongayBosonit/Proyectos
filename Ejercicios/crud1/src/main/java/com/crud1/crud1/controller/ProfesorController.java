package com.crud1.crud1.controller;

import com.crud1.crud1.application.ProfesorServiceImp;
import com.crud1.crud1.infraestructure.profesor.ProfesorInputDto;
import com.crud1.crud1.infraestructure.profesor.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfesorController {

    @Autowired
    ProfesorServiceImp profesorServiceImp;

    @PostMapping("profesor")
    public ProfesorOutputDto addProfesor(@RequestBody ProfesorInputDto profesorInputDto){
        return profesorServiceImp.crearProfesor(profesorInputDto);
    }

    @GetMapping("profesor/{id}")
    public Object buscarProfIdFull(@PathVariable int id, @RequestParam(value = "outputType", defaultValue = "simple", required = false)String outputType){
        if (outputType.equals("full")){
            return profesorServiceImp.buscarProfIdFull(id);
        }
        else{
            return profesorServiceImp.buscarProfId(id);
        }
    }

    @PutMapping("modifProf/{id}")
    public ProfesorOutputDto modifProf(@RequestBody ProfesorInputDto profesorInputDto, @PathVariable int id){
        return profesorServiceImp.modifProf(profesorInputDto, id);
    }

    @GetMapping("profesor/lista")
    public List<ProfesorOutputDto> listaProf(){
        return profesorServiceImp.listaProf();
    }

    @DeleteMapping("borrar/profesor/{id}")
    public ProfesorOutputDto borrarProf(@PathVariable int id){
        return profesorServiceImp.borrarProfId(id);
    }
}
