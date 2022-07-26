package com.propiedades.bs4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
    @Autowired
    Valores valores;

    @Autowired
    Valores2 valores2;

    @GetMapping("/valores")
    public String devolverValores() {

        return "Valor de var1 es: " + valores2.getVar1() + " y el valor de var2 es: " + valores.getVAR2();
    }

    @GetMapping("/VAR3")
    public String devolverVar3() {
        return "Valor de var1 es: " + valores2.getPrioritySystemProperty();
    }
}
