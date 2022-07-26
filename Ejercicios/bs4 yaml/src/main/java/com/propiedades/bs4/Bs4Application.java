package com.propiedades.bs4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Bs4Application {

	@Autowired
	private Valores valores;

	@Autowired
	private Valores2 valores2;

	public static void main(String[] args) {
		SpringApplication.run(Bs4Application.class, args);
	}

	@PostConstruct
	private void postInit() {
		System.out.println(valores);
		System.out.println(valores2);
	}
}

