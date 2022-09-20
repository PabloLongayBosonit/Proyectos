package com.mongo.mongo.application;

import com.mongo.mongo.domain.Persona;
import com.mongo.mongo.infraestructure.dto.PersonaInputDto;
import com.mongo.mongo.infraestructure.dto.PersonaOutputDto;
import com.mongo.mongo.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDto savePersona(PersonaInputDto personaInputDto) {
        Persona persona = new Persona(personaInputDto);
        personaRepository.save(persona);
        return persona.personaToPersonaOutputDto(persona);
    }

    @Override
    public List<PersonaOutputDto> listaPersona() {
        List<Persona> lista = personaRepository.findAll();
        return lista.stream().map(n->n.personaToPersonaOutputDto(n)).toList();
    }

    @Override
    public PersonaOutputDto borrarPorId(String id)  throws Exception{
        Persona persona = personaRepository.findById(id).orElseThrow(()->new Exception("no existe el id"));
        personaRepository.deleteById(id);
        return persona.personaToPersonaOutputDto(persona);
    }

    @Override
    public PersonaOutputDto modificarPorId(String id, PersonaInputDto personaInputDto) throws Exception {
        personaRepository.findById(id).orElseThrow(()->new Exception("no existe el id"));
        Persona persona = new Persona(personaInputDto);
        persona.setId(id);
        return persona.personaToPersonaOutputDto(personaRepository.save(persona));
    }

    @Override
    public PersonaOutputDto buscarPorId(String id) throws Exception {
        Persona persona = personaRepository.findById(id).orElseThrow(()->new Exception("no existe el id"));
        return persona.personaToPersonaOutputDto(persona);
    }

}
