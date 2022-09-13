package com.crud1.crud1.application;

import com.crud1.crud1.domain.Persona;
import com.crud1.crud1.infraestructure.persona.PersonaInputDto;
import com.crud1.crud1.infraestructure.persona.PersonaOutputDto;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public interface PersonaService {

    PersonaOutputDto guardarPersona(PersonaInputDto personaInputDto);
    PersonaOutputDto modificarPersona(PersonaInputDto personaInputDto, int id);
    PersonaOutputDto borrarPersona(int id);
    List<PersonaOutputDto> listaPersona();
    PersonaOutputDto buscarPorId(int id);
    List<PersonaOutputDto> buscarPorNombre(String nombre);


    //List<Persona> getData(HashMap<String, Object> data);


}
