package com.gabriel.bookstore.resouce;

import com.gabriel.bookstore.domaim.Livro;
import com.gabriel.bookstore.dtos.LivroDTO;
import com.gabriel.bookstore.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivroResouce {

    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        Livro obj = livroService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(
            @RequestParam(value = "categoria", defaultValue = "0") Integer id_categoria) {
        List<Livro> list = this.livroService.findAll(id_categoria);
        List<LivroDTO> listaDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());

    return ResponseEntity.ok().body(listaDTO);
    }


}
