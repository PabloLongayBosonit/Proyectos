package com.crud1.crud1.repository;

import com.crud1.crud1.domain.Persona;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PersonaRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Persona> getData(HashMap<String,Object> condiciones){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
        Root<Persona> root = query.from(Persona.class);

        List<Predicate> predicates = new ArrayList<>();
        condiciones.forEach((field,value) -> {
            switch (field)
            {
                case "nombre":
                    predicates.add(cb.equal(root.get(field), value));
                    break;
                case "apellido":
                    predicates.add(cb.equal(root.get(field),value));
                    break;
                case "username":
                    predicates.add(cb.equal(root.get(field),value));
                    break;
                case "fechacreacion":
                    String dateCondition=(String) condiciones.get("datecondition");
                    switch (dateCondition)
                    {
                        case "mayor":
                            predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value));
                            break;
                        case "menor":
                            predicates.add(cb.lessThan(root.<Date>get(field),(Date)value));
                            break;
                        case "igual":
                            predicates.add(cb.equal(root.<Date>get(field),(Date)value));
                            break;
                    }
                    break;
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
        }


    }

