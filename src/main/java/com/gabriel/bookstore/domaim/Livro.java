package com.gabriel.bookstore.domaim;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;


@Entity
@Table(name = "livro")

@Getter
@Setter
@EqualsAndHashCode()
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty(message = "Campo titulo é requerido") // a coluna nome nao pode ficar vazio
    @Length(min = 3, max = 50, message = "o campo titulo deve ter de 3 a 50 caracteres")
    @Column(name = "titulo")
    private String titulo;

    @NotEmpty(message = "Campo nome do autor é requerido") // a coluna nome nao pode ficar vazio
    @Length(min = 3, max = 50, message = "o campo nome do autor deve ter de 3 a 50 caracteres")
    @Column(name = "nome_autor")
    private String nome_autor;

    @NotEmpty(message = "Campo texto é requerido") // a coluna nome nao pode ficar vazio
    @Length(min = 10, max = 200000, message = "o campo texto deve ter de 3 a 2.000.00 caracteres")
    @Column(name = "texto")
    private String texto;

    @JsonIgnore // inginora a serialização
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Livro() {
        super();
    }

    public Livro(Integer id, String titulo, String nome_autor, String texto, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nome_autor = nome_autor;
        this.texto = texto;
        this.categoria = categoria;
    }

}
