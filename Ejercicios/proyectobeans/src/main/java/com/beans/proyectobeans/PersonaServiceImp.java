package com.beans.proyectobeans;

public class PersonaServiceImp implements PersonaService{

    Persona person = new Persona();

    @Override
    public void setNombre(String nombre) {
        person.setNombre(nombre);
    }

    @Override
    public String getNombre() {
        return person.getNombre();
    }
}
