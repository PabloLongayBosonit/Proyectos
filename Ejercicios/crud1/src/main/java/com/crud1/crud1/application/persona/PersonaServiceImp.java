package com.crud1.crud1.application.persona;


import com.crud1.crud1.domain.Persona;
import com.crud1.crud1.infraestructure.PersonaRepositorio;
import com.crud1.crud1.infraestructure.dto.input.PersonaInputDto;
import com.crud1.crud1.infraestructure.dto.output.PersonaOutputDto;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonaServiceImp implements PersonaService{

    @Autowired
    PersonaRepositorio personaRepositorio;
    //@Autowired Persona persona;
    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto) throws Exception{
        try {
            Persona persona = new Persona();
            persona = persona.InputDtoToPersona(personaInputDto);
            personaRepositorio.save(persona);
            System.out.println("estamos antes de return addpersona");
            return persona.personaToOutputDto(persona);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public PersonaOutputDto findByID(int id) throws Exception{
        Persona persona;
       persona = personaRepositorio.findById(id).orElseThrow(()-> new Exception("No se encuentra el ID"));

       return persona.personaToOutputDto(persona);
    }

    @Override
    public List<PersonaOutputDto> searchByName(String nombre) {
        return personaRepositorio.buscarPersonasPorNombre(nombre).stream().map(n-> n.personaToOutputDto(n)).toList();
    }

    @Override
    public List<PersonaOutputDto> devolverEntradas() {
        return personaRepositorio.findAll().stream().map(n-> n.personaToOutputDto(n)).toList();
    }

    @Override
    public PersonaOutputDto updateByID(int id, PersonaInputDto personaInputDto) {
        try {
            Persona persona = new Persona();
            Persona personaModif = persona.InputDtoToPersona(personaInputDto);
            personaModif.setId(id);
            return persona.personaToOutputDto(persona);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public PersonaOutputDto borrarPorID(int id) {
        try {
            Persona persona = personaRepositorio.findById(id).get();
            personaRepositorio.delete(persona);
            return new PersonaOutputDto();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
