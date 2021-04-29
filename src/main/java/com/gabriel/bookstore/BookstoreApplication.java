package com.gabriel.bookstore;

import com.gabriel.bookstore.domaim.Categoria;
import com.gabriel.bookstore.domaim.Livro;
import com.gabriel.bookstore.repository.CategoriaRepository;
import com.gabriel.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication {


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);

	}


}
