package com.crud1.crud1.application.student;

import com.crud1.crud1.domain.Asignatura;
import com.crud1.crud1.domain.Persona;
import com.crud1.crud1.domain.Student;
import com.crud1.crud1.exceptions.UnprocesableException;
import com.crud1.crud1.infraestructure.dto.input.PersonaInputDto;
import com.crud1.crud1.infraestructure.dto.input.StudentInputDto;
import com.crud1.crud1.infraestructure.dto.output.AsignaturaOutputDto;
import com.crud1.crud1.infraestructure.dto.output.PersonaOutputDto;
import com.crud1.crud1.infraestructure.dto.output.StudentOutputDto;
import com.crud1.crud1.infraestructure.dto.output.StudentOutputDtoSimple;
import com.crud1.crud1.infraestructure.repository.AsignaturaJpa;
import com.crud1.crud1.infraestructure.repository.PersonaJpa;
import com.crud1.crud1.infraestructure.repository.StudentJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.parseInt;


@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    StudentJpa studentJpa;

    @Autowired
    PersonaJpa personaJpa;

    @Autowired
    AsignaturaJpa asignaturaJpa;

    @Override
    public StudentOutputDtoSimple addStudent(StudentInputDto studentInputDto) {
        try {
            Student student = new Student();

            Persona persona;
            persona = personaJpa.findById(Integer.valueOf((studentInputDto.getId()))).get();

            student.StudentInputDto(studentInputDto);

            student.setPersona(persona);
            persona.setStudent(student);

            studentJpa.save(student);
            System.out.println("El estudiante: " + studentJpa.findById(student.getId_student()) + " es la persona: " + personaJpa.findById(Integer.valueOf(persona.getId())));
            System.out.println("La persona : " + personaJpa.findById(Integer.valueOf(persona.getId())) + " es el estudiante: " + studentJpa.findById(student.getId_student()));
            return student.StudentToOutputDtoSimple(student);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw new UnprocesableException("La ID suministrada está asociada a otro estudiante");
        }
    }



    @Override
    public StudentOutputDtoSimple getStudent(String id) {
        Student student;
        student = studentJpa.findById(id).get();
        StudentOutputDtoSimple studentOutputDtoSimple;
        studentOutputDtoSimple = student.StudentToOutputDtoSimple(student);
        return studentOutputDtoSimple;
    }
    @Override
    public StudentOutputDto getStudentFull(String id) {
        Student student;
        student = studentJpa.findById(id).get();
        StudentOutputDto studentOutputDto;
        studentOutputDto = student.StudentToOutputDto(student);
        return studentOutputDto;
    }

    @Override
    public StudentOutputDtoSimple modificarEstudiantePorId(String id, StudentInputDto studentInputDto) {

        Student studentMod = studentJpa.findById(id).get();
        studentMod.StudentInputDto(studentInputDto);
        studentJpa.save(studentMod);
        return studentMod.StudentToOutputDtoSimple(studentMod);

    }
    @Override
    public void borrarEstudiantePorId(String id) {

        studentJpa.delete(studentJpa.findById(id).get());
    }

    @Override
    public List<StudentOutputDtoSimple> mostrarEstudiantes() {

        List<Student> listaCompleta;
        listaCompleta = studentJpa.findAll().stream().toList();
        return  listaCompleta.stream().map(n->n.StudentToOutputDtoSimple(n)).toList();

    }

    @Override
    public List<AsignaturaOutputDto> asignaturasEstudiante(String idEstudiante) {
        return studentJpa.findById(idEstudiante).get().getAsignaturasApuntadas().stream().map(n->n.AsignaturaToAsignaturaOutputDto(n)).toList();
    }


}
