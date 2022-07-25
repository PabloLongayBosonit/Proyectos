package com.ciclobeans.beans;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
@Service
public class PrimeraClase {
    @PostConstruct
    public void saludo() {
     System.out.println( "Hola desde clase inicial");
    }
}
