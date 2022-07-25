package com.beans.proyectobeans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
    @Autowired
    @Qualifier("bean1")
    PersonaService personaServiceBean1;

    @Autowired
    @Qualifier("bean2")
    PersonaService personaServiceBean2;

    @Autowired
    @Qualifier("bean3")
    PersonaService personaServiceBean3;

    @GetMapping("/controlador/bean/{bean}")
    public PersonaService beanPerson(@PathVariable String bean) {
        if (bean.equals("bean1")) {
            System.out.println("bean1");
            return personaServiceBean1;
        }
        if (bean.equals("bean2")) {
            System.out.println("bean2");
            return personaServiceBean2;
        }
        if (bean.equals("bean3")) {
            System.out.println("bean3");
            return personaServiceBean3;
        } else {
            System.out.println("No existe este bean");
            return null;
        }
    }
}


