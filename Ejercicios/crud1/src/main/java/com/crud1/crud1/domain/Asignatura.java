package com.crud1.crud1.domain;

import com.crud1.crud1.infraestructure.asignatura.AsignaturaInputDto;
import com.crud1.crud1.infraestructure.asignatura.AsignaturaOutputDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Asignatura {

    @Id
    @GeneratedValue
    int id_asignatura;

    @ManyToMany
    @JsonIgnore
    @JoinTable (
            joinColumns = @JoinColumn,
            //NECESARIO PARA EL MANYTOMANY
            inverseJoinColumns = @JoinColumn
    )
            //METODOLOGIA PARA MANYTOMANY
    Set<Student> estudiantesInscritos = new HashSet<>();

    public Set<Student> getEstudiantesInscritos(){
        return estudiantesInscritos;
    }

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(referencedColumnName = "id")
Profesor profesor;
    public String asignatura;
    public String comments;
    public Date fecha_ini;
    public Date fecha_fin;

    public Asignatura(String asignatura, String comments, Date fecha_ini, Date fecha_fin) {
        this.asignatura = asignatura;
        this.comments = comments;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
    }

    public AsignaturaOutputDto asignaturaToOutputDto(Asignatura asignatura){
        return new AsignaturaOutputDto(asignatura.getId_asignatura(),asignatura.getAsignatura(),asignatura.getComments(), asignatura.getFecha_ini(), asignatura.getFecha_fin());
    }

    public Asignatura(AsignaturaInputDto asignaturaInputDto){
        this.asignatura = asignaturaInputDto.getAsignatura();
        this.comments = asignaturaInputDto.getComments();
        this.fecha_ini = asignaturaInputDto.getFecha_ini();
        this.fecha_fin = asignaturaInputDto.getFecha_fin();
    }
    public void addStudentToAsignatura(Student student){
        this.estudiantesInscritos.add(student);
    }
}

