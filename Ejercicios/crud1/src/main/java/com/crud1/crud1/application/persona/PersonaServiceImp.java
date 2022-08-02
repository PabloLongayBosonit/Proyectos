package com.crud1.crud1.application.persona;


import com.crud1.crud1.domain.Persona;
import com.crud1.crud1.infraestructure.PersonaRepositorio;
import com.crud1.crud1.infraestructure.dto.input.PersonaInputDto;
import com.crud1.crud1.infraestructure.dto.output.PersonaOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonaServiceImp implements PersonaService{

    @Autowired
    PersonaRepositorio personaRepositorio;
    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto) throws Exception{
        Persona persona = new Persona();
        try {
            persona = persona.InputDtoToPersona(personaInputDto);
            personaRepositorio.save(persona);
            System.out.println("estamos antes de return addpersona");
            return persona.personaToOutputDto(persona);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
