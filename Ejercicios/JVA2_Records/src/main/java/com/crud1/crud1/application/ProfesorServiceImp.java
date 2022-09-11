package com.crud1.crud1.application;

import com.crud1.crud1.domain.Persona;
import com.crud1.crud1.domain.Profesor;
import com.crud1.crud1.domain.Student;
import com.crud1.crud1.infraestructure.profesor.ProfesorInputDto;
import com.crud1.crud1.infraestructure.profesor.ProfesorOutputDto;
import com.crud1.crud1.infraestructure.profesor.ProfesorOutputDtoFull;
import com.crud1.crud1.infraestructure.student.StudentInputDto;
import com.crud1.crud1.infraestructure.student.StudentOutputDto;
import com.crud1.crud1.repository.PersonaRepository;
import com.crud1.crud1.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImp implements ProfesorService {

    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    ProfesorRepository profesorRepository;

    public ProfesorOutputDto crearProfesor(ProfesorInputDto profesorInputDto){
        Profesor profesor = new Profesor(profesorInputDto);
        Persona persona = personaRepository.findById(profesorInputDto.getId_persona()).orElseThrow();
        profesor.setPersona(persona);

        ProfesorOutputDto profesorOutputDto = profesor.profesorToOutputDto(profesorRepository.save(profesor));
        profesorOutputDto.setId_persona(profesorInputDto.getId_persona());
        return profesorOutputDto;
    }

    public  ProfesorOutputDto buscarProfId(int id){
        Profesor profesor = profesorRepository.findById(id).orElseThrow();
        return new ProfesorOutputDto(profesor.getId_profesor(), profesor.getPersona().getId(), profesor.getComments(), profesor.getBranch());
    }

    public ProfesorOutputDtoFull buscarProfIdFull(int id){
        Profesor profesor = new Profesor();
        return profesor.profesorOutputDtoFull(profesorRepository.findById(id).orElseThrow());
    }

    public ProfesorOutputDto borrarProfId(int id){
        Profesor profesor = profesorRepository.findById(id).orElseThrow();
        profesorRepository.delete(profesor);
        return profesor.profesorToOutputDto(profesor);
    }

    public ProfesorOutputDto modifProf(ProfesorInputDto profesorInputDto, int id_profesor){
        Profesor profesor = new Profesor(profesorInputDto);
        profesor.setId_profesor(id_profesor);
        return profesor.profesorToOutputDto(profesorRepository.save(profesor));
    }

    public List<ProfesorOutputDto> listaProf(){
        return profesorRepository.findAll().stream().map(n -> n.profesorToOutputDto(n)).toList();
    }
}
