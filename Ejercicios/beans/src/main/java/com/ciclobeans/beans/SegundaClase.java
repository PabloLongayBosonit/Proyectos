package com.ciclobeans.beans;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class SegundaClase implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println( "Hola desde segunda clase");
    }
}
