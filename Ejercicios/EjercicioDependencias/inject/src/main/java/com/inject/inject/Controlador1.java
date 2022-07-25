package com.inject.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.lang.Integer.parseInt;

@RestController
public class Controlador1 {

    @Autowired
    PersonaService personaService;
    @Autowired
    CityService cityService;

    @GetMapping("/controlador1/addPersona")
    public PersonaService personAdd(@RequestHeader Map<String,String> headers)
    {
        personaService.setNombre(headers.get("nombre"));
        personaService.setPoblacion(headers.get("poblacion"));
        personaService.setEdad(headers.get("edad"));
            return personaService;
    }

    @PostMapping("/controlador1/addCiudad")
    public void addCiudad(@RequestHeader Map<String, String> headers){
        cityService.setNombre(headers.get("nombre-ciudad"));
        cityService.setNumeroHabitantes(parseInt(headers.get("num-habitantes")));
        cityService.addCiudad(cityService.getCiudad());

    }
}



