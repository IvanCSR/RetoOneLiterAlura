package com.desafioLibros.Literalura;

import com.desafioLibros.Literalura.principal.Principal;
import com.desafioLibros.Literalura.repositorios.AutorRepositorio;
import com.desafioLibros.Literalura.repositorios.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private AutorRepositorio autorRepository;
	@Autowired
	private LibroRepositorio libroRepository;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(autorRepository, libroRepository);
		principal.mostrarMenu();
	}

}
