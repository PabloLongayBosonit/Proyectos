package com.crud1.crud1.infraestructure.dto.output;

import com.crud1.crud1.domain.Asignatura;
import com.crud1.crud1.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AsignaturaOutputDto {
    int id_asignatura;
    String asignatura;
    String comments;
    Date initial_date;
    Date finish_date;

}