package com.crud1.crud1.application.student;

import com.crud1.crud1.infraestructure.dto.input.StudentInputDto;
import com.crud1.crud1.infraestructure.dto.output.AsignaturaOutputDto;
import com.crud1.crud1.infraestructure.dto.output.StudentOutputDto;
import com.crud1.crud1.infraestructure.dto.output.StudentOutputDtoSimple;

import java.util.List;

public interface StudentService {

    StudentOutputDtoSimple addStudent(StudentInputDto studentInputDto);
    StudentOutputDtoSimple getStudent(String id);
    StudentOutputDto getStudentFull(String id);
    StudentOutputDtoSimple modificarEstudiantePorId(String id, StudentInputDto studentInputDto);
    void borrarEstudiantePorId(String id);
    List<StudentOutputDtoSimple> mostrarEstudiantes();


    List<AsignaturaOutputDto> asignaturasEstudiante(String idEstudiante);
}
