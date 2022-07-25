package com.crudproject.Crud;

import java.util.List;

public interface PersonaService {
    String getNombre();
    String getPoblacion();
    int getEdad();
    int getID();

    void setNombre(String nombre);
    void setPoblacion(String poblacion);
    void setEdad(int edad);
    void setId(int id);

    List<Persona> addPersona(Persona persona);

    Persona modifyPersona(Persona persona, int id);

    boolean existeById(int id);

    List<Persona> listaPersonas();

    Persona borraPersona(int id);

    List<Persona> buscarPorNombre(String nombre);

    Persona buscaPersona(int id);
}
