package com.crudproject.Crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador {
    @Autowired
    PersonaService personaService;


    @PostMapping("/persona")
    public Persona addPersona(@RequestBody Persona person) {
        personaService.addPersona(person);
        System.out.println("Añadida persona " + person);
        return person;
    }

    @GetMapping("/persona/list")
    public List<Persona> listaPersonas(){
        return personaService.listaPersonas();
    }

    @PutMapping("/persona/{id}")
    public Persona modificarPersona(@RequestBody Persona person, @PathVariable int id){
        personaService.modifyPersona(person, id);
        return person;
    }

    @DeleteMapping("/persona/{id}")
    public Persona borrarPersona(@PathVariable int id) {
        return personaService.borraPersona(id);

    }
    @GetMapping("/persona/{id}")
    public Persona buscarPorId(@PathVariable int id) {
        return personaService.buscaPersona(id);
    }

    @GetMapping("/persona/nombre/{nombre}")
    public List<Persona> listaNombre(@PathVariable String nombre) {
        return personaService.buscarPorNombre(nombre);
    }

}