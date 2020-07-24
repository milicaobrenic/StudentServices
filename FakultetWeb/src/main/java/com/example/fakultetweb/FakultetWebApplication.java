package com.example.fakultetweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("model")
public class FakultetWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakultetWebApplication.class, args);
	}

}
