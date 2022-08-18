package com.crud1.crud1.infraestructure.repository;

import com.crud1.crud1.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorJpa extends JpaRepository<Profesor, Integer> {
}