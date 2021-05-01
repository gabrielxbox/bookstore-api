package com.gabriel.bookstore.resouce;

import com.gabriel.bookstore.domaim.Livro;
import com.gabriel.bookstore.dtos.LivroDTO;
import com.gabriel.bookstore.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update (@PathVariable Integer id, @RequestBody Livro obj) {
        Livro newObj = this.livroService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> updatePatch (@PathVariable Integer id, @RequestBody Livro obj) {
        Livro newObj = this.livroService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Livro> create (
                                @RequestParam(value = "categoria", defaultValue = "0") Integer id_categoria,
                                @RequestBody Livro obj) {
             Livro newObj =  this.livroService.create(id_categoria, obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/livros/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return  ResponseEntity.created(uri).build();
    }
}
