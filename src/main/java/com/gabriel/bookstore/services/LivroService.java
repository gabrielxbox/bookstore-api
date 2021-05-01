package com.gabriel.bookstore.services;

import com.gabriel.bookstore.domaim.Categoria;
import com.gabriel.bookstore.domaim.Livro;
import com.gabriel.bookstore.exception.ObjectNotFoundException;
import com.gabriel.bookstore.repository.LivroRepository;
import com.gabriel.bookstore.resouce.LivroResouce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService  {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById ( Integer id) {
        Optional<Livro> obj = this.livroRepository.findById(id);
        return obj.orElseThrow(() ->
                new ObjectNotFoundException(
                        "Objeto Não encontrado Id:  "
                        + id +
                        " tipo "
                        + Livro.class.getName()));

    }

    public List<Livro> findAll(Integer id_categoria) {
        this.categoriaService.findByid(id_categoria);
        return this.livroRepository.findAllByCategoria(id_categoria);
    }

    public Livro update(Integer id, Livro obj) {
        Livro newObj = this.findById(id);
        this.updateData(newObj, obj);
        return this.livroRepository.save(newObj);
    }

    private void updateData(Livro newObj, Livro obj) {
        newObj.setTitulo(obj.getTitulo());
        newObj.setNome_autor(obj.getTexto());
        newObj.setTexto(obj.getTexto());
    }

    public Livro create(Integer id_categoria, Livro obj) {
        obj.setId(null);
        Categoria cat = this.categoriaService.findByid(id_categoria);
        obj.setCategoria(cat);
      return this.livroRepository.save(obj);
    }
}
