package com.RS1App.RS1App;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hola,%s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Mundo") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }

    @PostMapping("/greeting")
    public Object greetingPost(@RequestBody Object greeting) {
        return greeting;
    }

    @GetMapping("/user/{id}")
    public String greetingParams(@PathVariable String id) {
        return "El parametro es" + id;
    }

    @PutMapping("/post")
    public String greetingPost(@RequestParam(value ="var1") String var1, @RequestParam (value = "var2") String var2) {
        return "Los parametros son " + var1 + " y " + var2;
    }
}
