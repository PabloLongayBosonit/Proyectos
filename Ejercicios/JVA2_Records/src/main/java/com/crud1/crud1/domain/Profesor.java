package com.crud1.crud1.domain;

import com.crud1.crud1.infraestructure.profesor.ProfesorInputDto;
import com.crud1.crud1.infraestructure.profesor.ProfesorOutputDto;
import com.crud1.crud1.infraestructure.profesor.ProfesorOutputDtoFull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    @Id
    @GeneratedValue
    int id_profesor;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id")
    Persona persona;
    String comments;
    String branch;

    public ProfesorOutputDto profesorToOutputDto(Profesor profesor){
        return new ProfesorOutputDto(profesor.getId_profesor(),profesor.getComments(),profesor.getBranch());
    }

    public Profesor(ProfesorInputDto profesorInputDto){
        this.comments = profesorInputDto.getComments();
        this.branch = profesorInputDto.getBranch();
    }

    public ProfesorOutputDtoFull profesorOutputDtoFull(Profesor profesor){
        ProfesorOutputDtoFull profesorOutputDtoFull = new ProfesorOutputDtoFull();
        profesorOutputDtoFull.setId_profesor(profesor.getId_profesor());
        profesorOutputDtoFull.setComments(profesor.getComments());
        profesorOutputDtoFull.setBranch(profesor.getBranch());
        profesorOutputDtoFull.setId_persona(profesor.persona.getId());
        profesorOutputDtoFull.setNombre(profesor.persona.getNombre());
        profesorOutputDtoFull.setApellido(profesor.persona.getApellido());
        profesorOutputDtoFull.setUsername(profesor.persona.getUsername());
        return profesorOutputDtoFull;
    }
}
