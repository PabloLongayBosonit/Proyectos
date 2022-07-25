package com.crudproject.Crud;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImp implements PersonaService {

    Persona persona = new Persona();
    List<Persona> listaPersonas = new ArrayList<>();

    @Override
    public String getNombre() {
        return persona.getNombre();
    }

    @Override
    public String getPoblacion() {
        return persona.getPoblacion();
    }

    @Override
    public int getEdad() {
        return persona.getEdad();
    }

    @Override
    public int getID() {
        return persona.getId();
    }

    @Override
    public void setNombre(String nombre) {
         persona.setNombre(nombre);
    }

    @Override
    public void setPoblacion(String poblacion) {
         persona.setPoblacion(poblacion);
    }

    @Override
    public void setEdad(int edad) {
        persona.setEdad(edad);
    }

    @Override
    public void setId(int id) {
        persona.setId(id);
    }

    public List<Persona> addPersona(Persona persona) {
        if(existeById(persona.getId())) {
            System.out.println("Este ID ya existe");
            return listaPersonas;
        }
        else {
            Persona nueva = new Persona(persona.getId(), persona.getNombre(), persona.getPoblacion(), persona.getEdad());
            listaPersonas.add(nueva);
            return listaPersonas;
        }
    }

    @Override
    public Persona modifyPersona(Persona persona, int id) {
        if(existeById(id)) {
            listaPersonas.stream().filter(n -> n.getId() == id).forEach(n -> {
                n.setEdad(persona.getEdad());
                n.setPoblacion(persona.getPoblacion());
                n.setNombre(persona.getNombre());
                System.out.println("entrada modificada");
            });
        }
        else System.out.println("no existe este id");
        return persona;
    }

    @Override
    public boolean existeById(int id) {
        List<Persona> existe = listaPersonas.stream()
                .filter(n-> n.getId() == id)
                .collect(Collectors.toList());
        if(existe.size() > 0) {
            return true;
        }
        else return false;
    }
    public List<Persona> listaPersonas() {
        return listaPersonas;
    }

    public Persona buscaPersona(int id) {
        Persona match = listaPersonas.stream()
                .filter(n-> n.getId() == id)
                .findAny()
                .orElse(null);
        return match;
    }

    public Persona borraPersona(int id) {
        Persona test = buscaPersona(id);
        listaPersonas.remove(test);
        return test;
    }

    @Override
    public List<Persona> buscarPorNombre(String nombre) {
        List<Persona> lista = listaPersonas.stream()
                .filter(n-> n.getNombre().equalsIgnoreCase(nombre))
                .toList();
        return lista;
    }
}



