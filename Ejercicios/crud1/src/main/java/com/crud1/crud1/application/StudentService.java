package com.crud1.crud1.application;

import com.crud1.crud1.infraestructure.student.StudentInputDto;
import com.crud1.crud1.infraestructure.student.StudentOutputDto;
import com.crud1.crud1.infraestructure.student.StudentOutputDtoFull;

import java.util.List;

public interface StudentService {
    StudentOutputDto crearStudent(StudentInputDto studentInputDto);
    StudentOutputDto buscarPorId(int id);
    StudentOutputDto borrarStudentPorId(int id);
    List<StudentOutputDto> listaStudent();
    StudentOutputDto modifStudent(StudentInputDto studentInputDto, int id_student);
    StudentOutputDtoFull  buscarPorIdFull(int id);



}
