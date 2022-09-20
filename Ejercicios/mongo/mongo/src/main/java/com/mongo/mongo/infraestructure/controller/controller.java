package com.mongo.mongo.infraestructure.controller;

import com.mongo.mongo.application.PersonaServiceImpl;
import com.mongo.mongo.infraestructure.dto.PersonaInputDto;
import com.mongo.mongo.infraestructure.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {
    @Autowired
    PersonaServiceImpl personaServiceImpl;

    @GetMapping("persona")
    public PersonaOutputDto savePersona(@RequestBody PersonaInputDto personaInputDto) {
        return personaServiceImpl.savePersona(personaInputDto);
    }

    @GetMapping("persona/lista")
    public List<PersonaOutputDto> listaPersona(){
        return personaServiceImpl.listaPersona();
    }

    @DeleteMapping("persona/{id}")
    public ResponseEntity<PersonaOutputDto> borrarPorId(@PathVariable String id){
        try {
            return new ResponseEntity<>(personaServiceImpl.borrarPorId(id), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("persona/{id}")
    public ResponseEntity<PersonaOutputDto> modificarPorId(@PathVariable String id, @RequestBody PersonaInputDto personaInputDto){
        try {
            return new ResponseEntity<>(personaServiceImpl.modificarPorId(id, personaInputDto), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("persona/{id}")
    public ResponseEntity<PersonaOutputDto> buscarPorId(@PathVariable String id) {
        try {
            return new ResponseEntity<>(personaServiceImpl.buscarPorId(id),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
