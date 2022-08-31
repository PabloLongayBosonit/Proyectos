package com.crud1.crud1.application;

import com.crud1.crud1.domain.Persona;
import com.crud1.crud1.domain.Student;
import com.crud1.crud1.infraestructure.profesor.ProfesorOutputDto;
import com.crud1.crud1.infraestructure.student.StudentInputDto;
import com.crud1.crud1.infraestructure.student.StudentOutputDto;
import com.crud1.crud1.infraestructure.student.StudentOutputDtoFull;
import com.crud1.crud1.repository.PersonaRepository;
import com.crud1.crud1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PersonaRepository personaRepository;

    public StudentOutputDto buscarPorId(int id){
        Student student = studentRepository.findById(id).orElseThrow();
        return new StudentOutputDto(student.getId_student(),student.getPersona().getId(),student.getNum_horas_sem(), student.getComments(),student.getBranch());

    }

    public StudentOutputDtoFull buscarPorIdFull(int id){
        Student student = new Student();
        return student.studentToOutputDtoFull(studentRepository.findById(id).orElseThrow());
    }

    public StudentOutputDto crearStudent(StudentInputDto studentInputDto){
        Student student = new Student(studentInputDto);
        Persona persona = personaRepository.findById(studentInputDto.getId_persona()).orElseThrow();
        student.setPersona(persona);

        StudentOutputDto studentOutputDto = student.studentToOutputDto(studentRepository.save(student));
        studentOutputDto.setId_persona(studentInputDto.getId_persona());
        return studentOutputDto;

    }

    public StudentOutputDto borrarStudentPorId(int id){
        Student student = studentRepository.findById(id).orElseThrow();
        studentRepository.delete(student);
        return student.studentToOutputDto(student);
    }

    public List<StudentOutputDto> listaStudent(){
        return studentRepository.findAll().stream().map(n ->n.studentToOutputDto(n)).toList();
    }

    public StudentOutputDto modifStudent(StudentInputDto studentInputDto, int id){
        Student student = new Student(studentInputDto);
        student.setId_student(id);
        return student.studentToOutputDto(studentRepository.save(student));
    }


}

