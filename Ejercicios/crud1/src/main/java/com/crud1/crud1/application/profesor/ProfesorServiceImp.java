package com.crud1.crud1.application.profesor;

import com.crud1.crud1.domain.Persona;
import com.crud1.crud1.domain.Profesor;
import com.crud1.crud1.domain.Student;
import com.crud1.crud1.infraestructure.dto.input.ProfesorInputDto;
import com.crud1.crud1.infraestructure.dto.output.ProfesorOutputDto;
import com.crud1.crud1.infraestructure.dto.output.ProfesorOutputDtoSimple;
import com.crud1.crud1.infraestructure.dto.output.StudentOutputDto;
import com.crud1.crud1.infraestructure.dto.output.StudentOutputDtoSimple;
import com.crud1.crud1.infraestructure.repository.PersonaJpa;
import com.crud1.crud1.infraestructure.repository.ProfesorJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImp implements ProfesorService{

    @Autowired
    PersonaJpa personaJpa;

    @Autowired
    ProfesorJpa profesorJpa;

    @Override
    public ProfesorOutputDtoSimple addProfesor(ProfesorInputDto profesorInputDto) {
        Profesor profesor = new Profesor();
        profesor.ProfesorInputDtoToProfesor(profesorInputDto);
        Persona persona = personaJpa.findById(Integer.valueOf(profesorInputDto.getId_persona())).get();
        profesor.setPersona(persona);
        persona.setProfesor(profesor);
        profesorJpa.save(profesor);
        return profesor.ProfesorToProfesorOutputDtoSimple(profesor);
    }

    @Override
    public List<ProfesorOutputDtoSimple> profesorList() {

        List<Profesor> listaCompleta;
        listaCompleta = profesorJpa.findAll().stream().toList();
        return  listaCompleta.stream().map(n->n.ProfesorToProfesorOutputDtoSimple(n)).toList();


    }

    @Override
    public ProfesorOutputDtoSimple getProfesor(int id) {

        Profesor profesor = profesorJpa.findById(id).get();
        ProfesorOutputDtoSimple profesorOutputDtoSimple = profesor.ProfesorToProfesorOutputDtoSimple(profesor);
        return profesorOutputDtoSimple;
    }

    @Override
    public ProfesorOutputDto getProfesorFull(int id) {

        Profesor profesor = profesorJpa.findById(id).get();
        ProfesorOutputDto profesorOutputDto;
        profesorOutputDto = profesor.ProfesorToProfesorOutputDto(profesor);
        return profesorOutputDto;
    }

    @Override
    public ProfesorOutputDtoSimple modificarProfesorPorId(int id, ProfesorInputDto profesorInputDto) {
        Profesor profesorMod = profesorJpa.findById(id).get();
        profesorMod.ProfesorInputDtoToProfesor(profesorInputDto);
        profesorJpa.save(profesorMod);
        return profesorMod.ProfesorToProfesorOutputDtoSimple(profesorMod);
    }

    @Override
    public void borrarProfesorePorId(int id) {
        profesorJpa.delete(profesorJpa.findById(id).get());
    }

}