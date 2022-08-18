package com.crud1.crud1.application.asignatura;

import com.crud1.crud1.domain.Asignatura;
import com.crud1.crud1.infraestructure.dto.input.AsignaturaInputDto;
import com.crud1.crud1.infraestructure.dto.output.AsignaturaOutputDto;

import java.util.List;

public interface AsignaturaService {
    AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto);

    void deleteAsignaturaPorId(int id);

    AsignaturaOutputDto modificarAsignaturaPorId(int id);

    List<Asignatura> listarAsignaturas();

    AsignaturaOutputDto buscarAsignaturaPorId(int id);

    List<AsignaturaOutputDto> buscarAsignaturaPorNombre(String nombre);

    List<AsignaturaOutputDto> apuntarEstudianteListaAsignaturas(List<Integer> listaIdAsignaturas, String idEstudiante);
}
