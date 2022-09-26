package com.sa2.ficheros;

import com.sa2.ficheros.application.StorageProperties;
import com.sa2.ficheros.application.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class FicherosApplication {

	public static String ruta = "";

	public static void main(String[] args) {
		if(args.length>0) {
			ruta = args[0];
		}
		SpringApplication.run(FicherosApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
