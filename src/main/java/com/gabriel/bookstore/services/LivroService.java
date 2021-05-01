package com.gabriel.bookstore.services;

import com.gabriel.bookstore.domaim.Livro;
import com.gabriel.bookstore.exception.ObjectNotFoundException;
import com.gabriel.bookstore.repository.LivroRepository;
import com.gabriel.bookstore.resouce.LivroResouce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService  {

    @Autowired
    private LivroRepository livroRepository;

    public Livro findById ( Integer id) {
        Optional<Livro> obj = this.livroRepository.findById(id);
        return obj.orElseThrow(() ->
                new ObjectNotFoundException(
                        "Objeto Não encontrado Id:  "
                        + id +
                        " tipo "
                        + Livro.class.getName()));

    }
}
