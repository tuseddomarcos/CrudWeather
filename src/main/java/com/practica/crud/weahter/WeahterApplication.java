package com.practica.crud.weahter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.practica")
@EnableJpaRepositories("com.practica.crud.weahter.repository")
public class WeahterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeahterApplication.class, args);
	}

}
