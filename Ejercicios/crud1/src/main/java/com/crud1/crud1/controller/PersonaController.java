package com.crud1.crud1.controller;

import com.crud1.crud1.application.PersonaServiceImp;
import com.crud1.crud1.application.ProfesorServiceImp;
import com.crud1.crud1.application.StudentServiceImp;
import com.crud1.crud1.infraestructure.persona.PersonaInputDto;
import com.crud1.crud1.infraestructure.persona.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    PersonaServiceImp personaServiceImp;
    @Autowired
    StudentServiceImp studentServiceImp;
    @Autowired
    ProfesorServiceImp profesorServiceImp;

    @PostMapping("persona")
    public PersonaOutputDto addPersona(@RequestBody PersonaInputDto personaInputDto) {
        return personaServiceImp.guardarPersona(personaInputDto);
    }

    @PutMapping("modificar/{id}")
    public PersonaOutputDto modifPersona(@RequestBody PersonaInputDto personaInputDto, @PathVariable int id) {
        return personaServiceImp.modificarPersona(personaInputDto, id);
    }

    @DeleteMapping("borrar/{id}")

    public PersonaOutputDto deletePersona(@PathVariable int id) {

        return personaServiceImp.borrarPersona(id);
    }

    @GetMapping("lista")

    public List<PersonaOutputDto> listaCompleta() {
        return personaServiceImp.listaPersona();
    }

    @GetMapping("buscarid/{id}")

    public PersonaOutputDto searchID(@PathVariable int id) {
        return personaServiceImp.buscarPorId(id);
    }

    @GetMapping("buscarnombre/{nombre}")

    public List<PersonaOutputDto> searchNombre(@PathVariable String nombre) {
        return personaServiceImp.buscarPorNombre(nombre);
    }
}

