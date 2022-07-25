package com.inject.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImp implements PersonaService {
    Persona persona = new Persona();

    public String getNombre(){
        return persona.getNombre();
    }

    public void setNombre(String nombre){
        persona.setNombre(nombre);
    }

    @Override
    public String getPoblacion() {
        return persona.getPoblacion();
    }

    @Override
    public void setPoblacion(String poblacion) {
        persona.setPoblacion(poblacion);
    }

    @Override
    public String getEdad() {
        return persona.getEdad();
    }

    @Override
    public void setEdad(String edad) {
        persona.setEdad(edad);
    }
}
