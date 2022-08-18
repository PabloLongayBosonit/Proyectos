package com.crud1.crud1.application.profesor;

import com.crud1.crud1.infraestructure.dto.input.ProfesorInputDto;
import com.crud1.crud1.infraestructure.dto.output.ProfesorOutputDto;
import com.crud1.crud1.infraestructure.dto.output.ProfesorOutputDtoSimple;

import java.util.List;

public interface ProfesorService {
    ProfesorOutputDtoSimple addProfesor(ProfesorInputDto profesorInputDto);

    List<ProfesorOutputDtoSimple> profesorList();
    ProfesorOutputDtoSimple getProfesor(int id);
    ProfesorOutputDto getProfesorFull(int id);
    ProfesorOutputDtoSimple modificarProfesorPorId(int id, ProfesorInputDto profesorInputDto);
    void borrarProfesorePorId(int id);


}