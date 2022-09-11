package com.crud1.crud1.infraestructure.asignatura;

import com.crud1.crud1.domain.Asignatura;
import lombok.Data;

import java.util.Date;
@Data
public class AsignaturaOutputDto {
    int id_asignatura;
    String asignatura;
    String comments;
    Date fecha_ini;
    Date fecha_fin;

    public AsignaturaOutputDto(int id_asignatura, String asignatura, String comments, Date fecha_ini, Date fecha_fin){
        this.id_asignatura = id_asignatura;
        this.asignatura = asignatura;
        this.comments = comments;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
    }
}
