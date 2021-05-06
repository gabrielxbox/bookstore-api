package com.gabriel.bookstore.domaim;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categoria")

@Getter
@Setter
@EqualsAndHashCode()

public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty(message = "Campo nome é requerido") // a coluna nome nao pode ficar vazio
    @Length(min = 3, max = 100, message = "o campo nome deve ter de 3 a 100 caracteres")
    @Column(name = "nome")
    private String nome;

    @NotEmpty(message = "Campo descrição é requerido") // a coluna nome nao pode ficar vazio
    @Length(min = 3, max = 200, message = "o campo nome deve ter de 3 a 100 descrição")
    @Column(name = "descricao")
    private String descricao;

   // @OneToMany(fetch = FetchType.EAGER
   // @Fetch(FetchMode.SUBSELECT)
   @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    private List<Livro> listaLivros = new ArrayList<Livro>();

    public Categoria() {
        super();
    }

    public Categoria(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
  }


}
