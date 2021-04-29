package com.gabriel.bookstore.services;

import com.gabriel.bookstore.domaim.Categoria;
import com.gabriel.bookstore.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// clase de serviço
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findByid(Integer id) {
        // caso ele nao enconte ele vai retorna um Optional
        Optional<Categoria> obj = this.categoriaRepository.findById(id);
        return obj.orElse(null);

    }
}
