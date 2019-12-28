package com.itacademy.pets.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
@ComponentScan("com.itacademy.pets")
@EntityScan("com.itacademy.pets.entities")
@EnableJpaRepositories
@Import(value = {MainConfiguration.class})
public class PetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetsApplication.class, args);
	}
}