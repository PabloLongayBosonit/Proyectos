package com.crud1.crud1.application;

import com.crud1.crud1.domain.Persona;
import com.crud1.crud1.infraestructure.persona.PersonaInputDto;
import com.crud1.crud1.infraestructure.persona.PersonaOutputDto;
import com.crud1.crud1.repository.PersonaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.crud1.crud1.controller.PersonaController.*;


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
