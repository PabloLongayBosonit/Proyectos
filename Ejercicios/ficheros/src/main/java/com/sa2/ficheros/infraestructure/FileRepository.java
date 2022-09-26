package com.sa2.ficheros.infraestructure;

import com.sa2.ficheros.domain.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<Archivo, Integer> {
    @Query("SELECT p FROM Archivo p where p.nombrearchivo =?1")
    List<Archivo> findByNombre(String nombre);
}
