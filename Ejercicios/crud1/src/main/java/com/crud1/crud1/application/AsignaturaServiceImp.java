package com.crud1.crud1.application;

import com.crud1.crud1.domain.Asignatura;
import com.crud1.crud1.domain.Student;
import com.crud1.crud1.infraestructure.asignatura.AsignaturaInputDto;
import com.crud1.crud1.infraestructure.asignatura.AsignaturaOutputDto;
import com.crud1.crud1.repository.AsignaturaRepository;
import com.crud1.crud1.repository.PersonaRepository;
import com.crud1.crud1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImp implements AsignaturaService {


    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto){
       Asignatura asignatura = asignaturaRepository.save(new Asignatura(asignaturaInputDto));
       return asignatura.asignaturaToOutputDto(asignatura);
    }

    @Override
    public AsignaturaOutputDto modifAsignatura(AsignaturaInputDto asignaturaInputDto, int id) {
        Asignatura asignatura = new Asignatura(asignaturaInputDto);
        asignatura.setId_asignatura(id);
        return asignatura.asignaturaToOutputDto(asignaturaRepository.save(asignatura));
    }

    @Override
    public AsignaturaOutputDto borrarAsignatura(int id) {
        Asignatura asignatura = asignaturaRepository.findById(id).orElseThrow();
        asignaturaRepository.delete(asignatura);
        return asignatura.asignaturaToOutputDto(asignatura);
    }

    @Override
    public AsignaturaOutputDto buscarAsignaturaId(int id) {
        Asignatura asignatura = new Asignatura();
        return asignatura.asignaturaToOutputDto(asignaturaRepository.findById(id).orElseThrow());
    }

    @Override
    public List<AsignaturaOutputDto> listAsignatura() {
        return asignaturaRepository.findAll().stream().map(n ->n.asignaturaToOutputDto(n)).toList();
    }

    public Student nuevoStudentAsignatura(int id_asignatura, int id_estudiante){
        Asignatura asignatura = asignaturaRepository.findById(id_asignatura).orElseThrow();
        Student student = studentRepository.findById(id_estudiante).orElseThrow();
        student.addAsignaturaToStudent(asignatura);
        asignatura.addStudentToAsignatura(student);
        asignaturaRepository.save(asignatura);
        return studentRepository.save(student);

    }

    public List<AsignaturaOutputDto> agregarEstudianteAsignatura(List<Integer> listaAsignaturas, int id_estudiante){
        List<Asignatura> listaAsignatura = listaAsignaturas.stream().map(n -> asignaturaRepository.findById(n).get()).toList();
        Student student = studentRepository.findById(id_estudiante).get();
        return

    }

}
