package com.bs41.perfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("perfil2")
public class Perfil2 implements Perfiles {
    @Override
    public void myFunction() {
        System.out.println("Este es el perfil 2");
    }
}
