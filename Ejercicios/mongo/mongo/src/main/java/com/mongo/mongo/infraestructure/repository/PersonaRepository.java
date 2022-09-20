package com.mongo.mongo.infraestructure.repository;

import com.mongo.mongo.domain.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, String> {
}
