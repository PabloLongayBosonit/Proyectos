package com.crud1.crud1.infraestructure.profesor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorOutputDtoFull {
    int id_profesor;
    String comments;
    String branch;

    int id_persona;
    String nombre;
    String apellido;
    String username;
}
