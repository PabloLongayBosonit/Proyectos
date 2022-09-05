package com.crud1.crud1.application;

import com.crud1.crud1.domain.Asignatura;
import com.crud1.crud1.domain.Student;
import com.crud1.crud1.infraestructure.asignatura.AsignaturaInputDto;
import com.crud1.crud1.infraestructure.asignatura.AsignaturaOutputDto;

import java.util.List;

public interface AsignaturaService {

    AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto);
    AsignaturaOutputDto modifAsignatura(AsignaturaInputDto asignaturaInputDto, int id_asignatura);
    AsignaturaOutputDto borrarAsignatura(int id);
    AsignaturaOutputDto buscarAsignaturaId(int id);
    List<AsignaturaOutputDto> listAsignatura();
    Student nuevoStudentAsignatura(int id_asignatura, int id_estudiante);

    List<Asignatura> agregarEstudianteAsignatura (List<Integer> listaAsignaturas, int id_estudiante);
}
