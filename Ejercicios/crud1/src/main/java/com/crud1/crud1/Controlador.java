package com.crud1.crud1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controlador {
    @Autowired
    PersonaRepositorio personaRepositorio;

    @PostMapping("/persona")
    public Persona addPersona(@RequestBody Persona persona){
        try{
            persona.Validador();
            personaRepositorio.save(persona);
            return persona;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return persona;
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
}
