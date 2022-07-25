package com.inject.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class Controlador2 {
    @Autowired
    PersonaService personaService;

    @GetMapping("/controlador2/getPersona")
    PersonaService getControlador2()
    {
        personaService.setEdad(String.valueOf((parseInt(personaService.getEdad())*2)));
            return personaService;
    }
    @Autowired
    CityService cityService;

    @GetMapping("controlador2/getCiudad")

    public List listaCiudades(){
        return cityService.listaCiudades();


    }
}

