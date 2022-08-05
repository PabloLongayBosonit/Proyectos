package com.crud1.crud1.controller;

import com.crud1.crud1.application.persona.PersonaServiceImp;
import com.crud1.crud1.domain.Persona;
import com.crud1.crud1.infraestructure.PersonaRepositorio;
import com.crud1.crud1.infraestructure.dto.input.PersonaInputDto;
import com.crud1.crud1.infraestructure.dto.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controlador {
    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    PersonaServiceImp personaServiceImp;
    @PostMapping("/persona")
    public PersonaOutputDto addPersona(@RequestBody PersonaInputDto personaInputDto){
        try{
          return personaServiceImp.addPersona(personaInputDto);
        } catch (Exception e) {
            System.out.println("Controlador");
            System.out.println(e.getMessage());
            throw new RuntimeException();

        }
    }

    @GetMapping("id/{id}")
    public PersonaOutputDto buscarID(@PathVariable int id) {
        try {
           return personaServiceImp.findByID(id);
        } catch (Exception e) {
            return null;
        }

    }

    @GetMapping("persona/{nombre}")
    public List<PersonaOutputDto> buscarNombre(@PathVariable String nombre){
        return personaServiceImp.searchByName(nombre);
    }

    @GetMapping("entradas")
    public List<PersonaOutputDto> listaCompleta() {
   return personaServiceImp.devolverEntradas();

    }

    @PutMapping("persona/modificar/{id}")
    public PersonaOutputDto updateUserbyID(@PathVariable(value = "id")int id, @RequestBody PersonaInputDto personaInputDto) {
        return personaServiceImp.updateByID(id, personaInputDto);
    }

    @DeleteMapping("borrar/{id}")
    public void borrarPorId(@PathVariable int id) {
        personaServiceImp.borrarPorID(id);
    }
}
