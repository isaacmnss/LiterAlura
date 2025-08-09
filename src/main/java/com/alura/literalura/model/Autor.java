package com.alura.literalura.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idAutor;

    private String nomeAutor;

    private Integer anoNascimento;

    private Integer anoFalecimento;

    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros;

    public Autor() {
    }

    public Autor(Long idAutor, String nomeAutor, Integer anoNascimento, Integer anoFalecimento) {
        this.idAutor = idAutor;
        this.nomeAutor = nomeAutor;
        this.anoNascimento = anoNascimento;
        this.anoFalecimento = anoFalecimento;

    }
}
