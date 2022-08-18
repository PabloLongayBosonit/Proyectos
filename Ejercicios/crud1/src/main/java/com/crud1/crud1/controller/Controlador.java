package com.crud1.crud1.controller;

import com.crud1.crud1.application.asignatura.AsignaturaServiceImp;
import com.crud1.crud1.application.persona.PersonaService;
import com.crud1.crud1.application.persona.PersonaServiceImp;
import com.crud1.crud1.application.profesor.ProfesorServiceImp;
import com.crud1.crud1.application.student.StudentServiceImp;
import com.crud1.crud1.domain.Asignatura;
import com.crud1.crud1.exceptions.IdNoEncontrada;
import com.crud1.crud1.exceptions.UnprocesableException;
import com.crud1.crud1.infraestructure.dto.input.AsignaturaInputDto;
import com.crud1.crud1.infraestructure.dto.input.PersonaInputDto;
import com.crud1.crud1.infraestructure.dto.input.ProfesorInputDto;
import com.crud1.crud1.infraestructure.dto.input.StudentInputDto;
import com.crud1.crud1.infraestructure.dto.output.AsignaturaOutputDto;
import com.crud1.crud1.infraestructure.dto.output.PersonaOutputDto;
import com.crud1.crud1.infraestructure.dto.output.ProfesorOutputDtoSimple;
import com.crud1.crud1.infraestructure.dto.output.StudentOutputDtoSimple;
import com.crud1.crud1.infraestructure.repository.ProfesorJpa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class Controlador{

    @Autowired
    PersonaService personaservice;

    @Autowired
    StudentServiceImp studentServiceImp;

    @Autowired
    ProfesorServiceImp profesorServiceImp;

    @Autowired
    AsignaturaServiceImp asignaturaServiceImp;

    @Autowired
    PersonaServiceImp  personaServiceImp;
    //POSTS
    @PostMapping("/persona")
    public PersonaOutputDto crearPersona(@RequestBody PersonaInputDto personaInputDto){
        try {
            return personaservice.addPersona(personaInputDto);
        }
        catch(UnprocesableException e) {
            throw new UnprocesableException(e.getMessage());
        }
    }

    @PostMapping("estudiante")
    public StudentOutputDtoSimple addStudent(@RequestBody StudentInputDto studentInputDto) {
        return studentServiceImp.addStudent(studentInputDto);
    }

    @PostMapping("profesor")
    public ProfesorOutputDtoSimple addProfesor(@RequestBody ProfesorInputDto profesorInputDto) {
        return profesorServiceImp.addProfesor(profesorInputDto);
    }

    @PostMapping("asignatura")
    public AsignaturaOutputDto addAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto) {
        return asignaturaServiceImp.addAsignatura(asignaturaInputDto);
    }
    //PUTS
    @PutMapping("modificar/{id}")
    public PersonaOutputDto modificarPorId(@PathVariable String id, @RequestBody PersonaInputDto personaInputDto) {
        try {
            return personaServiceImp.modificarPorId(id, personaInputDto);
        }
        catch(NoSuchElementException e) {
            throw new IdNoEncontrada("El id " + id + " no se ha encontrado");
        }
        catch(UnprocesableException e) {
            throw new UnprocesableException(e.getMessage());
        }
    }
    @PutMapping("estudiante/modificar/{id}")
    public StudentOutputDtoSimple modificarEstudiantePorId(@PathVariable String id, @RequestBody StudentInputDto studentInputDto) {
        try {
            return studentServiceImp.modificarEstudiantePorId(id, studentInputDto);
        }
        catch(NoSuchElementException e) {
            throw new IdNoEncontrada("El id " + id + " no se ha encontrado");
        }
        catch(UnprocesableException e) {
            throw new UnprocesableException(e.getMessage());
        }
    }
    @PutMapping("profesor/modificar/{id}")
    public ProfesorOutputDtoSimple modificarProfesorPorId(@PathVariable int id, @RequestBody ProfesorInputDto profesorInputDto) {
        try {
            return profesorServiceImp.modificarProfesorPorId(id, profesorInputDto);
        }
        catch(NoSuchElementException e) {
            throw new IdNoEncontrada("El id " + id + " no se ha encontrado");
        }
        catch(UnprocesableException e) {
            throw new UnprocesableException(e.getMessage());
        }
    }

    @PutMapping("asignatura/{idAsignatura}/estudiante/{idEstudiante}")
    Asignatura apuntarEstudianteAsignatura(@PathVariable int idAsignatura, @PathVariable String idEstudiante) {
        return asignaturaServiceImp.apuntarEstudianteAsignatura(idAsignatura, idEstudiante);
    }
    @PutMapping("asignatura/{idAsignatura}/profesor/{idProfesor}")
    Asignatura apuntarEstudianteAsignatura(@PathVariable int idAsignatura, @PathVariable int idProfesor) {
        return asignaturaServiceImp.apuntarProfesorAsignatura(idAsignatura, idProfesor);
    }
    @PutMapping("asignatura/estudiante/{idEstudiante}")
    List<AsignaturaOutputDto> apuntarEstudianteListaAsignaturas(@RequestBody List<Integer> listaIdAsignaturas, @PathVariable String idEstudiante) {
        return asignaturaServiceImp.apuntarEstudianteListaAsignaturas(listaIdAsignaturas, idEstudiante);
    }

    //GETS
    @GetMapping("id/{id}")
    public PersonaOutputDto buscarPorId(@PathVariable String id) {
        try {
            personaServiceImp.buscarPorId(String.valueOf(id));
        }
        catch(NoSuchElementException e) {

            throw new IdNoEncontrada("El id " + id + " no se ha encontrado");
        }
        return personaServiceImp.buscarPorId(String.valueOf(id));

    }


    @GetMapping("persona/{nombre}")
    public ResponseEntity<List<PersonaOutputDto>> buscarPorNombre(@PathVariable String nombre) {
        return personaServiceImp.buscarPorNombre(nombre);
    }


    @GetMapping("entradas")
    public ResponseEntity<List<PersonaOutputDto>> listaCompleta() {

        return personaServiceImp.buscarTodos();
    }


    @GetMapping("estudiante/{id}")
    public Object getStudent(@PathVariable String id, @RequestParam(required = false, defaultValue = "simple") String outputType) {
        try {
            if (outputType.equals("full")) {
                return studentServiceImp.getStudentFull(id);
            }
            else {
                return studentServiceImp.getStudent(id);
            }
        }
        catch(Exception e) {

            throw new IdNoEncontrada("No se encontro la ID");

        }
    }

    @GetMapping("estudiante/entradas")
    public List<StudentOutputDtoSimple> mostrarEstudiantes() {

        return studentServiceImp.mostrarEstudiantes();
    }

    @GetMapping("profesor/entradas")
    public List<ProfesorOutputDtoSimple> mostrarProfesores() {

        return profesorServiceImp.profesorList();
    }

    @GetMapping("profesor/{id}")
    public Object getProfesor(@PathVariable int id, @RequestParam(required = false, defaultValue = "simple") String outputType) {
        try {
            if (outputType.equals("full")) {
                return profesorServiceImp.getProfesorFull(id);
            } else {
                return profesorServiceImp.getProfesor(id);
            }
        }
        catch(Exception e) {

            throw new IdNoEncontrada("No se encontro la ID");

        }
    }
    @GetMapping("asignatura/nombre/{nombre}")
    public List<AsignaturaOutputDto> buscarAsignaturaPorNombre(@PathVariable String nombre) {
        return asignaturaServiceImp.buscarAsignaturaPorNombre(nombre);
    }
    @JsonIgnore
    @GetMapping("asignatura/estudiante/{idEstudiante}")
    public List<AsignaturaOutputDto> buscarAsignaturasEstudiante(@PathVariable String idEstudiante) {
        return studentServiceImp.asignaturasEstudiante(idEstudiante);
    }
    //DELETES
    @DeleteMapping("borrar/{id}")

    public void borrarPorId(@PathVariable String id){
        try {
            personaServiceImp.borrarPorId(id);
        }
        catch(NoSuchElementException e){
            throw new IdNoEncontrada("El id " + id + " no se ha encontrado");
        }

    }
    @DeleteMapping("borrar/estudiante/{id}")
    public void borrarEstudiantePorId(@PathVariable String id){
        try {
            studentServiceImp.borrarEstudiantePorId(id);
        }
        catch(NoSuchElementException e){
            throw new IdNoEncontrada("El id " + id + " no se ha encontrado");
        }

    }
    @DeleteMapping("borrar/profesor/{id}")
    public void borrarProfesorPorId(@PathVariable int id){
        try {
            profesorServiceImp.borrarProfesorePorId(id);
        }
        catch(NoSuchElementException e){
            throw new IdNoEncontrada("El id " + id + " no se ha encontrado");
        }

    }
}