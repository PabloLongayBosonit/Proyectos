package com.beans.proyectobeans;

import org.springframework.stereotype.Service;

@Service
public interface PersonaService {
    void setNombre(String nombre);

    public String getNombre();
}
