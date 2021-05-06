package com.gabriel.bookstore.dtos;

import com.gabriel.bookstore.domaim.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

public class CategoriaDTO implements Serializable {

    private Integer id;
    @NotEmpty(message = "Campo nome é requerido") // a coluna nome nao pode ficar vazio
    @Length(min = 3, max = 100, message = "o campo nome deve ter de 3 a 100 caracteres")
    @Column(name = "nome")
    private String nome;

    @NotEmpty(message = "Campo descrição é requerido") // a coluna nome nao pode ficar vazio
    @Length(min = 3, max = 200, message = "o campo nome deve ter de 3 a 100 descrição")
    @Column(name = "descricao")
    private String descricao;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoriaDTO)) return false;
        CategoriaDTO that = (CategoriaDTO) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
