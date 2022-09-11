package com.crud1.crud1.infraestructure.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDto {
    int id;
    int id_persona;
    int num_horas_sem;
    String comments;
    String branch;

    public StudentOutputDto(int id, int num_horas_sem, String comments, String branch){
        this.id = id;
        this.num_horas_sem = num_horas_sem;
        this.comments = comments;
        this.branch = branch;
    }


}
