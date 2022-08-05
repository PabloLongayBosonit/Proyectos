package com.crud1.crud1.application.persona;


import com.crud1.crud1.infraestructure.dto.input.PersonaInputDto;
import com.crud1.crud1.infraestructure.dto.output.PersonaOutputDto;

import java.util.List;

public interface PersonaService {
    PersonaOutputDto addPersona(PersonaInputDto personaInputDto) throws Exception;

    PersonaOutputDto findByID(int id) throws Exception;

    List<PersonaOutputDto> searchByName(String nombre);

    List<PersonaOutputDto> devolverEntradas();

    PersonaOutputDto updateByID(int id, PersonaInputDto personaInputDto) throws Exception;

    void borrarPorID(int id);
}


