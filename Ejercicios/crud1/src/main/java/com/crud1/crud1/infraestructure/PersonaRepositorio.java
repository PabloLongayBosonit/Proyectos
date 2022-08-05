package com.crud1.crud1.infraestructure;

import com.crud1.crud1.domain.Persona;
import com.crud1.crud1.infraestructure.dto.input.PersonaInputDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {
    @Query("SELECT p FROM Persona p WHERE p.name = ?1")
    List<Persona> buscarPersonasPorNombre(String nombre);

   // Persona findById(int id, PersonaInputDto personaInputDto);
}
