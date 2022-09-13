package com.crud1.crud1.domain;

import com.crud1.crud1.infraestructure.persona.PersonaInputDto;
import com.crud1.crud1.infraestructure.persona.PersonaOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue
    int id;
    String nombre;
    String apellido;
    String username;

    Date fechacreacion;




    public Persona(PersonaInputDto personaInputDto) {
        this.nombre = personaInputDto.getNombre();
        this.apellido= personaInputDto.getApellido();
        this.username= personaInputDto.getUsername();
    }

    public PersonaOutputDto PersonaToOutputDto() {
        return new PersonaOutputDto(this.id, this.nombre, this.apellido, this.username);
    }


}
