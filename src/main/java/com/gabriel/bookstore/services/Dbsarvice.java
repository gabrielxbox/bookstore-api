package com.gabriel.bookstore.services;

import com.gabriel.bookstore.domaim.Categoria;
import com.gabriel.bookstore.domaim.Livro;
import com.gabriel.bookstore.repository.CategoriaRepository;
import com.gabriel.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Dbsarvice {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;


    public void instanciaBaseDeDados (){
        Categoria ca1 = new Categoria(null, "Informatica","Livro de TI");
        Categoria cat2 = new Categoria(null, "Quimica","Livro de Quimica");
        Categoria cat3 = new Categoria(null, "Matematica","Livro de Matematica");

        Livro l1 = new Livro(null, "Clen code ", "Robet Master", "Lorem Ipsum", ca1 );
        Livro l2 = new Livro(null, "Engenharia  ", "Engenharia Master", "Engenharia Ipsum", cat2 );
        Livro l3 = new Livro(null, "Matematica code ", "Matematica Master", "Matematica Ipsum", cat3 );
        Livro l4 = new Livro(null, "Quimica code ", "Quimica Master", "Quimica Ipsum", ca1 );
        Livro l5 = new Livro(null, "Clen code2 ", "Robet Master2", "Lorem Ipsum2", cat2 );

        //  cria como se fosse um for Arrays.asList(livro)
        ca1.getListaLivros().addAll(Arrays.asList(l1,l2));
        cat2.getListaLivros().addAll(Arrays.asList(l3,l2,l3));

        this.categoriaRepository.saveAll(Arrays.asList(ca1,cat2, cat3));

        this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));

        System.out.println("a qui");

    }


}
