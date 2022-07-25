package com.beans.proyectobeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProyectobeansApplication {


	public static void main(String[] args) {
		SpringApplication.run(ProyectobeansApplication.class, args);
	}

	@Bean
	@Qualifier("bean1")
	public PersonaService getPersonaServiceBean1() {
		PersonaService personaservice = new PersonaServiceImp();
		personaservice.setNombre("bean1");
		return personaservice;
	}

	@Bean
	@Qualifier("bean2")
	public PersonaService getPersonaServiceBean2() {
		PersonaService personaservice = new PersonaServiceImp();
		personaservice.setNombre("bean2");
		return personaservice;
	}

	@Bean
	@Qualifier("bean3")
	public PersonaService getPersonaServiceBean3() {
		PersonaService personaservice = new PersonaServiceImp();
		personaservice.setNombre("bean3");
		return personaservice;
	}



}