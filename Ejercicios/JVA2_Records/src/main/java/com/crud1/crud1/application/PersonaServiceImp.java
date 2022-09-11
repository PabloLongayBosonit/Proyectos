package com.crud1.crud1.application;

import com.crud1.crud1.domain.Persona;
import com.crud1.crud1.infraestructure.persona.PersonaInputDto;
import com.crud1.crud1.infraestructure.persona.PersonaOutputDto;
import com.crud1.crud1.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;
    @Override
    public PersonaOutputDto guardarPersona(PersonaInputDto personaInputDto) {
        Persona persona = personaRepository.save(new Persona(personaInputDto));
        return persona.PersonaToOutputDto();

    }

    @Override
    public PersonaOutputDto modificarPersona(PersonaInputDto personaInputDto, int id) {

        Persona persona = new Persona(personaInputDto);
        persona.setId(id);
        return personaRepository.save(persona).PersonaToOutputDto();


    }

    @Override
    public PersonaOutputDto borrarPersona(int id) {
        Persona persona = personaRepository.findById(id).orElseThrow();
        personaRepository.delete(persona);
        return persona.PersonaToOutputDto();
    }

    @Override
    public List<PersonaOutputDto> listaPersona() {
        return personaRepository.findAll().stream().map(n->n.PersonaToOutputDto()).toList();
    }

    @Override
    public PersonaOutputDto buscarPorId(int id) {
        return personaRepository.findById(id).orElseThrow().PersonaToOutputDto();
    }

    @Override
    public List<PersonaOutputDto> buscarPorNombre(String nombre) {
        return personaRepository.findByNombre(nombre).stream().map(n->n.PersonaToOutputDto()).toList();
    }


}
