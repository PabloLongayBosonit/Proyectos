package com.ciclobeans.beans;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class TerceraClase implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Soy la tercera clase" + " soy " + args[0] + " y vivo en "+ args[1]);
    }
}