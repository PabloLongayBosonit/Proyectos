package com.crud1.crud1.repository;

import com.crud1.crud1.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
//    @Query("SELECT P FROM PERSONA P WHERE P.nombre = ?1")
    List<Persona> findByNombre(String nombre);
    public List<Persona> getData(HashMap<String, Object> condiciones);
}
