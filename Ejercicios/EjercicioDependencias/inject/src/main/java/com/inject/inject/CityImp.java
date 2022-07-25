package com.inject.inject;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityImp implements CityService{
    Ciudad ciudad = new Ciudad();
    List<Ciudad> listaCiudades = new ArrayList<Ciudad>();

    @Override
    public String getNombre() {
        return ciudad.getNombre();
    }

    @Override
    public int getNumeroHabitantes() {
        return ciudad.getNumeroHabitantes();
    }

    @Override
    public void setNombre(String nombre) {
        ciudad.setNombre(nombre);
    }

    @Override
    public void setNumeroHabitantes(int habitantes) {
        ciudad.setNumeroHabitantes(habitantes);
    }

    @Override
    public void addCiudad(Ciudad ciudad) {
        Ciudad ciudadtest = new Ciudad(ciudad.getNombre(),ciudad.getNumeroHabitantes());
        listaCiudades.add(ciudadtest);
    }

    @Override
    public List<Ciudad> listaCiudades() {
        return listaCiudades;
    }

    @Override
    public Ciudad getCiudad() {
        return ciudad;
    }
}