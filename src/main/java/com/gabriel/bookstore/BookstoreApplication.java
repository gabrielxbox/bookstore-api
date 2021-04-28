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
public class BookstoreApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria = new Categoria(null, "Informatica","Livro de TI");

		Livro livro = new Livro(null, "Clen code ", "Robet Master", "Lorem Ipsum", categoria );
		//  cria como se fosse um for Arrays.asList(livro)
		categoria.getListaLivros().addAll(Arrays.asList(livro));

		this.categoriaRepository.saveAll(Arrays.asList(categoria));

		this.livroRepository.saveAll(Arrays.asList(livro));

		System.out.println("a qui");

	}
}
