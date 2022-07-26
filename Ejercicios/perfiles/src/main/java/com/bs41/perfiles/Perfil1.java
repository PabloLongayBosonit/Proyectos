package com.bs41.perfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@Profile("perfil1")
public class Perfil1 implements Perfiles{
    @Override
    public void myFunction() {
        System.out.println("Este es el perfil 1");
    }
}
