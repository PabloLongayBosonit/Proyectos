package com.crud1.crud1.application.persona;


import com.crud1.crud1.infraestructure.dto.input.PersonaInputDto;
import com.crud1.crud1.infraestructure.dto.output.PersonaOutputDto;

public interface PersonaService {
    PersonaOutputDto addPersona(PersonaInputDto personaInputDto) throws Exception;
}
