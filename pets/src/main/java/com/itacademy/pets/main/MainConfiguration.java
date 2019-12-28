package com.itacademy.pets.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

	@PersistenceUnit
	EntityManagerFactory emf;
}