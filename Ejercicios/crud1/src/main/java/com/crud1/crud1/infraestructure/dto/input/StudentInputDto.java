package com.crud1.crud1.infraestructure.dto.input;


import com.crud1.crud1.domain.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInputDto {
    String id;
    int num_hours_week;
    String comments;
    String id_profesor;
    String branch;
    List<Asignatura> asignaturas;
}