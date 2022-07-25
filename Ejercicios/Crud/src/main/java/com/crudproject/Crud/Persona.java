package com.crudproject.Crud;

import java.util.Optional;

public class Persona {
    private int id;
    private String nombre;
    private String poblacion;
    private int edad;

    public Persona(int id, String nombre, String poblacion, int edad) {
        this.id = id;
        this.nombre = nombre;
        Optional<String> poblacionTest = Optional.ofNullable(poblacion);
        this.poblacion = poblacionTest.orElse("Desconocida");
        Optional<Integer> edadTest = Optional.ofNullable(edad);
        this.edad = edadTest.orElse(0);
    }

    public Persona() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
