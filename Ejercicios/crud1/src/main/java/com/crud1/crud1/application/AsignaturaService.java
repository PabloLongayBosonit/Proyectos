package com.crud1.crud1.application;

import com.crud1.crud1.infraestructure.asignatura.AsignaturaInputDto;
import com.crud1.crud1.infraestructure.asignatura.AsignaturaOutputDto;

import java.util.List;

public interface AsignaturaService {

    AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto);
    AsignaturaOutputDto modifAsignatura(AsignaturaInputDto asignaturaInputDto, int id_asignatura);
    AsignaturaOutputDto borrarAsignatura(int id);
    AsignaturaOutputDto buscarAsignaturaId(int id);
    List<AsignaturaOutputDto> listAsignatura();
}
