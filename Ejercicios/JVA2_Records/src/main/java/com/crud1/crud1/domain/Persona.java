package com.crud1.crud1.domain;

import com.crud1.crud1.infraestructure.persona.PersonaInputDto;
import com.crud1.crud1.infraestructure.persona.PersonaOutputDto;
import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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




    public Persona(String nombre, String apellido, String username) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
    }

    public PersonaOutputDto PersonaToOutputDto() {
        return new PersonaOutputDto(this.id, this.nombre, this.apellido, this.username);
    }


}
