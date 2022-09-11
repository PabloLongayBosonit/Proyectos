package com.crud1.crud1.infraestructure.profesor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorInputDto {
    int id_persona;
    String comments;
    String branch;
}
