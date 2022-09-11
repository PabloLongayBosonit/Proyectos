package com.crud1.crud1.application;

import com.crud1.crud1.infraestructure.profesor.ProfesorInputDto;
import com.crud1.crud1.infraestructure.profesor.ProfesorOutputDto;
import com.crud1.crud1.infraestructure.profesor.ProfesorOutputDtoFull;

import java.util.List;

public interface ProfesorService{

    ProfesorOutputDto crearProfesor(ProfesorInputDto profesorInputDto);
    ProfesorOutputDto buscarProfId(int id);
    ProfesorOutputDto borrarProfId(int id);
    ProfesorOutputDto modifProf(ProfesorInputDto profesorInputDto, int id_profesor);
    List<ProfesorOutputDto> listaProf();

    ProfesorOutputDtoFull buscarProfIdFull(int id);




}
