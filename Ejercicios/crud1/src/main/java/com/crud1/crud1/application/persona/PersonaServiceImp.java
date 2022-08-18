package com.crud1.crud1.application.persona;

import com.crud1.crud1.domain.Persona;
import com.crud1.crud1.exceptions.UnprocesableException;
import com.crud1.crud1.infraestructure.dto.input.PersonaInputDto;
import com.crud1.crud1.infraestructure.dto.output.PersonaOutputDto;
import com.crud1.crud1.infraestructure.repository.PersonaJpa;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonaServiceImp implements PersonaService{

    @Autowired
    PersonaJpa personaJpa;


    @Override
    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto){

        Persona persona = new Persona();
        try {
            personaJpa.save(persona.DtoToPersona(personaInputDto));
            return persona.PersonaToDto(persona.DtoToPersona(personaInputDto));
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw new UnprocesableException(e.getMessage());
        }


    }

    @Override
    public PersonaOutputDto buscarPorId(String id) {

        Persona persona = new Persona();
        return persona.PersonaToDto(personaJpa.findById(Integer.valueOf(id)).get());

    }

    @Override
    public ResponseEntity<List<PersonaOutputDto>> buscarPorNombre(String nombre) {

        return new ResponseEntity<>( personaJpa.buscarPersonasPorNombre(nombre).stream().map(n->n.PersonaToDto(n)).toList(),HttpStatus.OK);


    }

    @Override
    public ResponseEntity<List<PersonaOutputDto>> buscarTodos() {

        return new ResponseEntity<>(personaJpa.findAll().stream().map(n->n.PersonaToDto(n)).toList(),HttpStatus.OK);
    }

    @Override
    public PersonaOutputDto modificarPorId(String id, PersonaInputDto personaInputDto) {

        personaJpa.findById(Integer.valueOf(id)).get();
        try {
            Persona persona = new Persona();
            Persona personaMod = persona.DtoToPersona(personaInputDto);
            personaMod.setId(id);
            personaJpa.save(personaMod);
            return persona.PersonaToDto(personaMod);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new UnprocesableException(e.getMessage());
        }


    }

    @Override
    public void borrarPorId(String id) {

        personaJpa.delete(personaJpa.findById(Integer.valueOf(id)).get());
    }


}
