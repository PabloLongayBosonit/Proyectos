package com.crud1.crud1.application.asignatura;

import com.crud1.crud1.domain.Asignatura;
import com.crud1.crud1.domain.Profesor;
import com.crud1.crud1.domain.Student;
import com.crud1.crud1.infraestructure.dto.input.AsignaturaInputDto;
import com.crud1.crud1.infraestructure.dto.output.AsignaturaOutputDto;
import com.crud1.crud1.infraestructure.repository.AsignaturaJpa;
import com.crud1.crud1.infraestructure.repository.ProfesorJpa;
import com.crud1.crud1.infraestructure.repository.StudentJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImp implements AsignaturaService{

    @Autowired
    AsignaturaJpa asignaturaJpa;

    @Autowired
    StudentJpa studentJpa;

    @Autowired
    ProfesorJpa profesorJpa;

    @Override
    public AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto) {
        Asignatura asignatura = new Asignatura();
        asignatura.AsignaturaInputDtoToAsignatura(asignaturaInputDto);
        asignaturaJpa.save(asignatura);
        return asignatura.AsignaturaToAsignaturaOutputDto(asignatura);

    }

    @Override
    public void deleteAsignaturaPorId(int id) {

    }

    @Override
    public AsignaturaOutputDto modificarAsignaturaPorId(int id) {
        return null;
    }

    @Override
    public List<Asignatura> listarAsignaturas() {
        return null;
    }

    @Override
    public AsignaturaOutputDto buscarAsignaturaPorId(int id) {
        return null;
    }

    @Override
    public List<AsignaturaOutputDto> buscarAsignaturaPorNombre(String nombre) {
        return asignaturaJpa.buscarAsignaturaPorNombre(nombre).stream().map(n->n.AsignaturaToAsignaturaOutputDto(n)).toList();
    }

    public Asignatura apuntarEstudianteAsignatura(int idAsignatura, String idEstudiante) {
        Asignatura asignatura = asignaturaJpa.findById(idAsignatura).get();
        Student student = studentJpa.findById(idEstudiante).get();
        asignatura.apuntarEstudiante(student);
        return asignaturaJpa.save(asignatura);
    }

    public Asignatura apuntarProfesorAsignatura(int idAsignatura, int idProfesor) {
        Asignatura asignatura = asignaturaJpa.findById(idAsignatura).get();
        Profesor profesor = profesorJpa.findById(idProfesor).get();
        asignatura.apuntarProfesor(profesor);
        return asignaturaJpa.save(asignatura);
    }

    @Override
    public List<AsignaturaOutputDto> apuntarEstudianteListaAsignaturas(List<Integer> listaIdAsignaturas, String idEstudiante) {
        List<Asignatura> lista = listaIdAsignaturas.stream().map(n-> asignaturaJpa.findById(n).get()).toList();
        Student student = studentJpa.findById(idEstudiante).get();
        lista.stream().forEach(n-> {
            n.apuntarEstudiante(student);
            asignaturaJpa.save(n);
        });


        return lista.stream().map(n->n.AsignaturaToAsignaturaOutputDto(n)).toList();
    }


}