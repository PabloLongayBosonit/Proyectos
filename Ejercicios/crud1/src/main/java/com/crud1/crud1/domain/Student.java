package com.crud1.crud1.domain;

import com.crud1.crud1.autoincrementales.StudentSequenceIdGenerator;
import com.crud1.crud1.infraestructure.dto.input.StudentInputDto;
import com.crud1.crud1.infraestructure.dto.output.StudentOutputDto;
import com.crud1.crud1.infraestructure.dto.output.StudentOutputDtoSimple;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.parseInt;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ausencias")
    @GenericGenerator(

            name = "ausencias",

            strategy = "com.crud1.crud1.autoincrementales.StudentSequenceIdGenerator",

            parameters = {

                    @org.hibernate.annotations.Parameter(name = StudentSequenceIdGenerator.INCREMENT_PARAM, value = "1"),

                    @org.hibernate.annotations.Parameter(name = StudentSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Std"),

                    @org.hibernate.annotations.Parameter(name = StudentSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")

            })
    @Column(name = "id_student")
    private String id_student;

    @OneToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id")
    Persona persona;

    int num_hours_week;

    String comments;

    String branch;


    @JsonIgnore
    @ManyToMany(mappedBy="estudiantesApuntados")
    private Set<Asignatura> asignaturasApuntadas = new HashSet<>();
    public Set<Asignatura> getAsignaturasApuntadas() {
        return asignaturasApuntadas;
    }

    public void StudentInputDto(StudentInputDto studentInputDto) {



        this.setComments(studentInputDto.getComments());
        this.setNum_hours_week(studentInputDto.getNum_hours_week());
        this.setBranch(studentInputDto.getBranch());

    }

    public StudentOutputDtoSimple StudentToOutputDtoSimple(Student student) {

        StudentOutputDtoSimple studentOutputDtoSimple = new StudentOutputDtoSimple();
        studentOutputDtoSimple.setId(this.getId_student());
        studentOutputDtoSimple.setBranch(this.getBranch());
        studentOutputDtoSimple.setComments(this.getComments());
        studentOutputDtoSimple.setNum_hours_week(this.getNum_hours_week());
        studentOutputDtoSimple.setId_persona(String.valueOf(this.persona.getId()));
        studentOutputDtoSimple.setAsignaturas(this.asignaturasApuntadas);
        System.out.println("Hola desde student DTO simple");

        return studentOutputDtoSimple;
    }
    public StudentOutputDto StudentToOutputDto(Student student) {

        StudentOutputDto studentOutputDto = new StudentOutputDto();
        studentOutputDto.setId(this.getId_student());
        studentOutputDto.setBranch(this.getBranch());
        studentOutputDto.setComments(this.getComments());
        studentOutputDto.setNum_hours_week(this.getNum_hours_week());
        studentOutputDto.setId_persona(String.valueOf(this.persona.getId()));
        System.out.println("Hola desde student DTO FULL");

        studentOutputDto.setUsuario(this.persona.getUsuario());
        studentOutputDto.setPassword(this.persona.getPassword());
        studentOutputDto.setName(this.persona.getName());
        studentOutputDto.setSurname(this.persona.getSurname());
        studentOutputDto.setCompany_email(this.persona.getCompany_email());
        studentOutputDto.setPersonal_email(this.persona.getPersonal_email());
        studentOutputDto.setCity(this.persona.getCity());
        studentOutputDto.setActive(this.persona.isActive());
        studentOutputDto.setCreated_date(this.persona.getCreated_date());
        studentOutputDto.setImagen_url(this.persona.getImagen_url());
        studentOutputDto.setTermination_date(this.persona.getTermination_date());
        return studentOutputDto;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id_student='" + id_student + '\'' +
                ", num_hours_week=" + num_hours_week +
                ", comments='" + comments + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
