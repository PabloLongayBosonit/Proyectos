package com.inject.inject;

import org.springframework.stereotype.Component;


public class Persona {
    String nombre;
    String poblacion;
    String edad;

    public Persona(String nombre, String poblacion, String edad) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.edad = edad;
    }
    public Persona(){


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}