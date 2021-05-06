package com.gabriel.bookstore.repository;

import com.gabriel.bookstore.domaim.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    // é uma boa pratica tilizar @Param(value = "id_categoria")
    @Query(value = "SELECT livro FROM livro  WHERE categoria.id = :id_categoria  ORDER BY titulo", nativeQuery = true)
    List<Livro> findAllByCategoria(@Param(value = "id_categoria") Integer id_categoria);
}
