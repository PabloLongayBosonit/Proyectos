package com.loggin.loggin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controlador {

    @GetMapping("/testerror")
    public void giveError() {
        log.error("Error en controlador");
    }

    @GetMapping("/testwarning")
    public void giveWarning() {
        log.warn("Warning en controlador");
    }

    @GetMapping("/testinfo")
    public void giveInfo() {
        log.info("Info en controlador");
    }
}
