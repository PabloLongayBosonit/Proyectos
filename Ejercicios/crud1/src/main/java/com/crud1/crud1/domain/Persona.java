package com.crud1.crud1.domain;

import com.crud1.crud1.infraestructure.dto.input.PersonaInputDto;
import com.crud1.crud1.infraestructure.dto.output.PersonaOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public void Validador() throws Exception{
        if(usuario == null || usuario.length()<6 || usuario.length() > 10)
        {
            throw new RuntimeException("El usuario no puede ser nulo, debe tener entre 6 y 10 caracteres");
        }
        if(password == null)
        {
            throw new RuntimeException("Password no puede ser nulo");
        }
        if(name == null)
        {
            throw new RuntimeException("El nombre no puede ser nulo");
        }
        if(personal_email == null)
        {
            throw new RuntimeException("El personal_email no puede ser nulo");
        }
        if(city == null)
        {
            throw new RuntimeException("La ciudad no puede ser nulo");
        }
        if(created_date ==null)
        {
            throw new RuntimeException("La fecha creada no puede ser nula");
        }
    }
    public Persona InputDtoToPersona(PersonaInputDto personaInputDto) throws Exception {
        try {
            Persona persona = new Persona();

            persona.setUsuario(personaInputDto.getUsuario());
            persona.setPassword(personaInputDto.getPassword());
            persona.setName(personaInputDto.getName());
            persona.setSurname(personaInputDto.getSurname());
            persona.setCompany_email(personaInputDto.getCompany_email());
            persona.setPersonal_email(personaInputDto.getPersonal_email());
            persona.setCity(personaInputDto.getCity());
            persona.setActive(personaInputDto.isActive());
            persona.setCreated_date(personaInputDto.getCreated_date());
            persona.setTermination_date(personaInputDto.getTermination_date());
            persona.setImagen_url(personaInputDto.getImagen_url());
            persona.Validador();
            return persona;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PersonaOutputDto personaToOutputDto(Persona persona){
        PersonaOutputDto personaOutputDto  = new PersonaOutputDto();
        personaOutputDto.setUsuario(persona.getUsuario());
        personaOutputDto.setPassword(persona.getPassword());
        personaOutputDto.setName(persona.getName());
        personaOutputDto.setSurname(persona.getSurname());
        personaOutputDto.setCompany_email(persona.getCompany_email());
        personaOutputDto.setPersonal_email(persona.getPersonal_email());
        personaOutputDto.setCity(persona.getCity());
        personaOutputDto.setActive(persona.isActive());
        personaOutputDto.setCreated_date(persona.getCreated_date());
        personaOutputDto.setTermination_date(persona.getTermination_date());
        personaOutputDto.setImagen_url(persona.getImagen_url());
        return personaOutputDto;
    }
}
