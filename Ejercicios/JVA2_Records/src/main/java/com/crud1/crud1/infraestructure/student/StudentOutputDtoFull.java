package com.crud1.crud1.infraestructure.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDtoFull {
    int id_student;
    int num_horas_sem;
    String comments;
    String branch;

    int id_persona;
    String nombre;
    String apellido;
    String username;
}
