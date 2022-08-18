package com.crud1.crud1.domain;

import com.crud1.crud1.infraestructure.dto.input.ProfesorInputDto;
import com.crud1.crud1.infraestructure.dto.output.ProfesorOutputDto;
import com.crud1.crud1.infraestructure.dto.output.ProfesorOutputDtoSimple;
import lombok.*;

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

    @OneToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id")
    Persona persona;

    String comments;
    String branch;

    public void ProfesorInputDtoToProfesor(ProfesorInputDto profesorInputDto) {

        this.comments = profesorInputDto.getComments();
        this.branch = profesorInputDto.getBranch();
    }

    public ProfesorOutputDtoSimple ProfesorToProfesorOutputDtoSimple(Profesor profesor) {
        ProfesorOutputDtoSimple profesorOutputDtoSimple = new ProfesorOutputDtoSimple();
        profesorOutputDtoSimple.setId_profesor(profesor.getId_profesor());
        profesorOutputDtoSimple.setBranch(profesor.getBranch());
        profesorOutputDtoSimple.setComments(profesor.getComments());
        profesorOutputDtoSimple.setId_persona(String.valueOf(profesor.getPersona().getId()));
        return profesorOutputDtoSimple;
    }

    public ProfesorOutputDto ProfesorToProfesorOutputDto(Profesor profesor) {
        ProfesorOutputDto profesorOutputDto = new ProfesorOutputDto();
        profesorOutputDto.setId_profesor(profesor.getId_profesor());
        profesorOutputDto.setBranch(profesor.getBranch());
        profesorOutputDto.setComments(profesor.getComments());
        profesorOutputDto.setId_persona(String.valueOf(profesor.getPersona().getId()));

        profesorOutputDto.setUsuario(this.persona.getUsuario());
        profesorOutputDto.setPassword(this.persona.getPassword());
        profesorOutputDto.setName(this.persona.getName());
        profesorOutputDto.setSurname(this.persona.getSurname());
        profesorOutputDto.setCompany_email(this.persona.getCompany_email());
        profesorOutputDto.setPersonal_email(this.persona.getPersonal_email());
        profesorOutputDto.setCity(this.persona.getCity());
        profesorOutputDto.setActive(this.persona.isActive());
        profesorOutputDto.setCreated_date(this.persona.getCreated_date());
        profesorOutputDto.setImagen_url(this.persona.getImagen_url());
        profesorOutputDto.setTermination_date(this.persona.getTermination_date());
        return profesorOutputDto;
    }
}