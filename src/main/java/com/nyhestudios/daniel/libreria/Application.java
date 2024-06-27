package com.nyhestudios.daniel.libreria;

import com.nyhestudios.daniel.libreria.model.repository.SerieRepository;
import com.nyhestudios.daniel.libreria.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private SerieRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal main = new Principal(repository);
		main.menu();
	}
}
