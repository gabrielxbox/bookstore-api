package com.gabriel.bookstore.dtos;

import com.gabriel.bookstore.domaim.Livro;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class LivroDTO implements Serializable {

    private Integer id;

    @NotEmpty(message = "Campo titulo é requerido") // a coluna nome nao pode ficar vazio
    @Length(min = 3, max = 50, message = "o campo titulo deve ter de 3 a 50 caracteres")
    private String titulo;


    public LivroDTO() {

    }

    public LivroDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LivroDTO)) return false;
        LivroDTO livroDTO = (LivroDTO) o;
        return id.equals(livroDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
