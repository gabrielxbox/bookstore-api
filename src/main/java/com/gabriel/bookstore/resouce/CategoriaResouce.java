package com.gabriel.bookstore.resouce;


import com.gabriel.bookstore.domaim.Categoria;
import com.gabriel.bookstore.dtos.CategoriaDTO;
import com.gabriel.bookstore.services.CategoriaService;
import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResouce {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
            Categoria  obj = this.categoriaService.findByid(id);
            return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll () {
        List<Categoria> list  = this.categoriaService.findAll();
        // trasformando uma lista de categoria em uma lista de categoriaDTO
        // lanbida
        List<CategoriaDTO> listaDTO =
                list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return  ResponseEntity.ok(listaDTO);
   }

   @PostMapping
   public ResponseEntity<Categoria> create(@RequestBody Categoria obj) {
          obj = this.categoriaService.create(obj);
          // pegando id com uri
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(obj.getId())
               .toUri();
       // pode ser a sim ResponseEntity.created(uri).body(obj);
       return ResponseEntity.created(uri).build();
   }
}
