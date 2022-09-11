package com.crud1.crud1.infraestructure.persona;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaOutputDto {

    int id;
    String nombre;
    String apellido;
    String username;
}
