package com.crud1.crud1.controller;

import com.crud1.crud1.application.StudentServiceImp;
import com.crud1.crud1.infraestructure.student.StudentInputDto;
import com.crud1.crud1.infraestructure.student.StudentOutputDto;
import com.crud1.crud1.infraestructure.student.StudentOutputDtoFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentServiceImp studentServiceImp;

    @PostMapping("estudiante")
    public StudentOutputDto addStudent(@RequestBody StudentInputDto studentInputDto){
        return studentServiceImp.crearStudent(studentInputDto);
    }

    @GetMapping("estudiante/{id}")
    public Object buscarPorIdFull (@PathVariable int id, @RequestParam(value = "outputType", defaultValue = "simple", required = false) String outputType){
        if (outputType.equals("full")){
            return studentServiceImp.buscarPorIdFull(id) ;
        }
        else {
            return studentServiceImp.buscarPorId(id);
        }
    }


    @PutMapping("modifStudent/{id}")
    public StudentOutputDto modifStudent(@RequestBody StudentInputDto studentInputDto, @PathVariable int id){
        return studentServiceImp.modifStudent(studentInputDto, id);

    }

    @GetMapping("estudiante/lista")
    public List<StudentOutputDto> studentLista(){
        return studentServiceImp.listaStudent();
    }

    @DeleteMapping("borrar/estudiante/{id}")
    public StudentOutputDto borrarStudent(@PathVariable int id){
        return studentServiceImp.borrarStudentPorId(id);
    }
}
