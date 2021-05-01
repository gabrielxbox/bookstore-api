package com.gabriel.bookstore.services;

import com.gabriel.bookstore.domaim.Categoria;
import com.gabriel.bookstore.dtos.CategoriaDTO;
import com.gabriel.bookstore.exception.ObjectNotFoundException;
import com.gabriel.bookstore.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// clase de serviço
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findByid(Integer id) {
        // caso ele nao enconte ele vai retorna um Optional
        Optional<Categoria> obj = this.categoriaRepository.findById(id);
        // criando uma new function e passando o parametro ObjectNotFoundException para manda uma mensagem
        return obj.orElseThrow(() ->
                new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: "
                        + Categoria.class.getName()));

    }

    public List<Categoria> findAll(){
       return this.categoriaRepository.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return this.categoriaRepository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO objDto) {
        Categoria obj = findByid(id);
        obj.setNome(objDto.getNome());
        obj.setDescricao(objDto.getDescricao());
        return this.categoriaRepository.save(obj);
    }
}
