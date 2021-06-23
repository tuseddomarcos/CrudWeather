package com.practica.crud.weahter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.practica")
public class WeahterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeahterApplication.class, args);
	}

}
