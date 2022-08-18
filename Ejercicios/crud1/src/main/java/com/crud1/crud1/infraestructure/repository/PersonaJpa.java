package com.crud1.crud1.infraestructure.repository;

import com.crud1.crud1.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaJpa extends JpaRepository<Persona, Integer> {
    @Query("SELECT p FROM Persona p WHERE p.name = ?1")
    List<Persona> buscarPersonasPorNombre(String nombre);

   // Persona findById(int id, PersonaInputDto personaInputDto);
}
