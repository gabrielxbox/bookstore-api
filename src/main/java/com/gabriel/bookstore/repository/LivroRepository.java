package com.gabriel.bookstore.repository;

import com.gabriel.bookstore.domaim.Livro;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaAttributeConverter<Livro, Integer> {
}
