package com.crud1.crud1.controller;

import com.crud1.crud1.application.AsignaturaService;
import com.crud1.crud1.application.AsignaturaServiceImp;
import com.crud1.crud1.domain.Asignatura;
import com.crud1.crud1.domain.Student;
import com.crud1.crud1.infraestructure.asignatura.AsignaturaInputDto;
import com.crud1.crud1.infraestructure.asignatura.AsignaturaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AsignaturaController {

    @Autowired
    AsignaturaServiceImp asignaturaServiceImp;

    @PostMapping("asignatura")
    public AsignaturaOutputDto addAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto){
        return asignaturaServiceImp.addAsignatura(asignaturaInputDto);
    }

    @PutMapping("modifasignatura/{id}")
    public AsignaturaOutputDto modifAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto, @PathVariable int id){
        return asignaturaServiceImp.modifAsignatura(asignaturaInputDto, id);
    }

    @GetMapping("asignatura/{id}")
    public AsignaturaOutputDto getAsignaturaId(@PathVariable int id){
        return asignaturaServiceImp.buscarAsignaturaId(id);
    }

    @DeleteMapping("borrar/asignatura/{id}")
    public AsignaturaOutputDto borrarAsignatura(@PathVariable int id){
        return asignaturaServiceImp.borrarAsignatura(id);
    }
    @GetMapping("asignatura/lista")
    public List<AsignaturaOutputDto> asignaturaList(){
        return asignaturaServiceImp.listAsignatura();
    }

    @PostMapping("asignatura/{id_asignatura}/estudiante/{id_estudiante}")
    public Student addAsignaturaStudent(@PathVariable int id_asignatura, @PathVariable int id_estudiante){
        return asignaturaServiceImp.nuevoStudentAsignatura(id_asignatura, id_estudiante);
    }

    @PostMapping("asignatura/estudiante/{id_estudiante}")
    public List<Asignatura> agregarEstudianteAsignatura(@RequestBody List<Integer> listaAsignaturas, @PathVariable int id_estudiante ){
        return asignaturaServiceImp.agregarEstudianteAsignatura(listaAsignaturas, id_estudiante);
    }

}
