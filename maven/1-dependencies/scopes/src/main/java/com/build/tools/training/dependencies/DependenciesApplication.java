package com.build.tools.training.dependencies;

import java.time.Instant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DependenciesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DependenciesApplication.class, args);
	}

	@GetMapping
	public Footpring footpring() {
		return Footpring.builder()
				.timestamp(Instant.now())
				.serviceName("dependency scopes demo")
				.build();
	}
}
