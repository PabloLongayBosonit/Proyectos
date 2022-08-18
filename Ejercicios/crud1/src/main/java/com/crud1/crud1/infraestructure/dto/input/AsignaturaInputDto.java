package com.crud1.crud1.infraestructure.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AsignaturaInputDto {
    String asignatura;
    String comments;
    Date initial_date;
    Date finish_date;
}
