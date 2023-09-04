package com.imt.delirium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void init() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("python", "/sciptBdd/FillAdresse.py");

		try {
			Process process = processBuilder.start();
			// Gérer le processus (attendre la fin, récupérer les erreurs, etc.)
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
