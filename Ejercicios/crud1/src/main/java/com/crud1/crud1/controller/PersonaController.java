package com.crud1.crud1.controller;

import com.crud1.crud1.repository.PersonaRepositoryImpl;
import com.crud1.crud1.application.PersonaServiceImp;
import com.crud1.crud1.application.ProfesorServiceImp;
import com.crud1.crud1.application.StudentServiceImp;
import com.crud1.crud1.domain.Persona;
import com.crud1.crud1.infraestructure.persona.PersonaInputDto;
import com.crud1.crud1.infraestructure.persona.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    PersonaServiceImp personaServiceImp;
    @Autowired
    StudentServiceImp studentServiceImp;
    @Autowired
    ProfesorServiceImp profesorServiceImp;
    @Autowired
    PersonaRepositoryImpl personaRepositoryImp;

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

    @GetMapping("customquery")
    public List<Persona> listaQuery(@RequestParam(required = false) String nombre,
                                    @RequestParam(required = false) String apellido,
                                    @RequestParam(required = false) String username,
                                    @RequestParam(required = false) Date fechacreacion,
                                    @RequestParam(required = false) String datecondition) {

        HashMap<String, Object> datos = new HashMap<>();
        datos.put("nombre",nombre);
        datos.put("apellido", apellido);
        datos.put("username", username);
        datos.put("fechacreacion", fechacreacion);
        datos.put("datecondition", datecondition);

        return personaRepositoryImp.getData(datos);
    }
}

