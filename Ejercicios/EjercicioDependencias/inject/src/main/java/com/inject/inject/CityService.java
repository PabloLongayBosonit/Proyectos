package com.inject.inject;

import java.util.ArrayList;
import java.util.List;


public interface CityService {
    String getNombre();
    int getNumeroHabitantes();

    void setNombre(String nombre);

    void setNumeroHabitantes(int habitantes);

    void addCiudad(Ciudad ciudad);

    List listaCiudades();

    Ciudad getCiudad();

}
