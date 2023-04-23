package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.demo.entity")
@EnableJpaRepositories("com.example.demo.repository")
public class Sc4SpringBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sc4SpringBoot2Application.class, args);
	}

}