package com.crud1.crud1.infraestructure.asignatura;

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
    Date fecha_ini;
    Date fecha_fin;

}
