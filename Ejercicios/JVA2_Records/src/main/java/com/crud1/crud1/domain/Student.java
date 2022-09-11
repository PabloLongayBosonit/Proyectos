package com.crud1.crud1.domain;


import com.crud1.crud1.infraestructure.student.StudentInputDto;
import com.crud1.crud1.infraestructure.student.StudentOutputDto;
import com.crud1.crud1.infraestructure.student.StudentOutputDtoFull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "id_student")
    public int id_student;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id")
    Persona persona;
    int num_horas_sem;
    String comments;
    String branch;
    @JsonIgnore
    @ManyToMany(mappedBy = "estudiantesInscritos")
        public Set<Asignatura> asignaturasInscritas = new HashSet<>();
        public Set<Asignatura> getAsignaturasInscritas() {
            return asignaturasInscritas;
        }

        public void addAsignaturaToStudent(Asignatura asignatura){
            this.asignaturasInscritas.add(asignatura);
        }



    public StudentOutputDto studentToOutputDto(Student student){

        StudentOutputDto studentOutputDto = new StudentOutputDto(student.getId_student(), student.getNum_horas_sem(), student.getComments(), student.getBranch());
         studentOutputDto.setId_persona(student.persona.getId());
         return studentOutputDto;
    }

    public Student(StudentInputDto studentInputDto){
        this.num_horas_sem = studentInputDto.getNum_horas_sem();
        this.comments = studentInputDto.getComments();
        this.branch = studentInputDto.getBranch();
    }

    public StudentOutputDtoFull studentToOutputDtoFull(Student student) {
        StudentOutputDtoFull studentOutputDtoFull = new StudentOutputDtoFull();
        studentOutputDtoFull.setId_student(student.getId_student());
        studentOutputDtoFull.setNum_horas_sem(student.getNum_horas_sem());
        studentOutputDtoFull.setBranch(student.getBranch());
        studentOutputDtoFull.setComments(student.getComments());
        studentOutputDtoFull.setId_persona(student.persona.getId());
        studentOutputDtoFull.setNombre(student.persona.getNombre());
        studentOutputDtoFull.setApellido(student.persona.getApellido());
        studentOutputDtoFull.setUsername(student.persona.getUsername());

        return studentOutputDtoFull;
    }
}


