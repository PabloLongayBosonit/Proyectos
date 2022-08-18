package com.crud1.crud1.infraestructure.repository;

import com.crud1.crud1.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJpa extends JpaRepository<Student, String> {
}
