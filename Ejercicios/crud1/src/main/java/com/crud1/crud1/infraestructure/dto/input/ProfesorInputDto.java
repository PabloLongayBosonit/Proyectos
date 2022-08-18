package com.crud1.crud1.infraestructure.dto.input;

import com.crud1.crud1.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorInputDto {

    int id_profesor;
    String id_persona;
    String comments;
    String branch;
}
