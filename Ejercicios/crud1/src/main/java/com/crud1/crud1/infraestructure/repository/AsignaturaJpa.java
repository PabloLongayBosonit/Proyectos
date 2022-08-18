package com.crud1.crud1.infraestructure.repository;

import com.crud1.crud1.domain.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignaturaJpa extends JpaRepository<Asignatura, Integer> {
    @Query("SELECT a FROM Asignatura a WHERE a.asignatura = ?1 ")
    List<Asignatura> buscarAsignaturaPorNombre(String nombre);
//    @Query("SELECT a FROM Asignaturas_Alumno a WHERE a.STUDENT_ID = ?1")
//    List<>
}