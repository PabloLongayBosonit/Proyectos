package com.crud1.crud1.application.persona;

import com.crud1.crud1.domain.Persona;
import com.crud1.crud1.infraestructure.dto.input.PersonaInputDto;
import com.crud1.crud1.infraestructure.dto.output.PersonaOutputDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonaService {
    PersonaOutputDto addPersona(PersonaInputDto personaInputDto);
    PersonaOutputDto buscarPorId(String id);
    ResponseEntity<List<PersonaOutputDto>> buscarPorNombre(String nombre);
    ResponseEntity<List<PersonaOutputDto>> buscarTodos();
    PersonaOutputDto modificarPorId(String id, PersonaInputDto personaInputDto);
    void borrarPorId(String id);



}

