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
    public Persona buscarID(@PathVariable int id) throws Exception{
        try {
            return personaRepositorio.findById(id).get();
        }
        catch(Exception e) {
            System.out.println("No se encuentra el ID");
            return null;
        }
    }

    @GetMapping("persona/{nombre}")
    public List<Persona> buscarNombre(@PathVariable String nombre){
        List<Persona> listaPersonas = new ArrayList<Persona>();
        List<Persona> listaMatch = new ArrayList<Persona>();
        listaMatch = personaRepositorio.findAll().stream().filter(n->n.getName().equalsIgnoreCase(nombre)).toList();
        return listaMatch;
    }

    @GetMapping("entradas")
    public List<Persona> listaCompleta() {
       List<Persona> lista = new ArrayList<Persona>();
       lista = personaRepositorio.findAll().stream().toList();
       return lista;

    }

    @PutMapping("persona/modificar")
    public Persona personaModificada(@RequestBody Persona persona) throws Exception{
        try {
            Persona personaMod = personaRepositorio.findById(persona.getId()).get();
            personaRepositorio.save(persona);
            return persona;
        }
        catch(Exception e) {
            System.out.println("No se encuentra el ID");
            return null;
        }
    }
}
