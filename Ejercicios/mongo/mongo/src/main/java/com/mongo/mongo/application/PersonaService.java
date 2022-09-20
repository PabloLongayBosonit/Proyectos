package com.mongo.mongo.application;

import com.mongo.mongo.domain.Persona;
import com.mongo.mongo.infraestructure.dto.PersonaInputDto;
import com.mongo.mongo.infraestructure.dto.PersonaOutputDto;

import java.util.List;

public interface PersonaService {
    PersonaOutputDto savePersona(PersonaInputDto personaInputDto);
    List<PersonaOutputDto> listaPersona();
    PersonaOutputDto borrarPorId(String id) throws Exception;
    PersonaOutputDto modificarPorId(String id, PersonaInputDto personaInputDto) throws Exception;
    PersonaOutputDto buscarPorId(String id) throws Exception;
}
