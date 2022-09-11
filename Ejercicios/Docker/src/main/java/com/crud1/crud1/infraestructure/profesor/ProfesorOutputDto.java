package com.crud1.crud1.infraestructure.profesor;

import com.crud1.crud1.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorOutputDto {
    int id;
    int id_persona;
    String comments;
    String branch;

    public ProfesorOutputDto(int id, String comments, String branch){
        this.id = id;
        this.comments = comments;
        this.branch = branch;
    }
}

