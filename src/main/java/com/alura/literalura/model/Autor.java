package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeAutor;

    private Integer anoNascimento;

    private Integer anoFalecimento;

    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros = new ArrayList<>();

    public Autor() {
    }

    public Autor(Long id, String nomeAutor, Integer anoNascimento, Integer anoFalecimento) {
        this.id = id;
        this.nomeAutor = nomeAutor;
        this.anoNascimento = anoNascimento;
        this.anoFalecimento = anoFalecimento;
    }

    public Autor(AutorRecord record) {
        this.nomeAutor = record.nomeAutor();
        this.anoNascimento = record.anoNascimento();
        this.anoFalecimento = record.anoFalecimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "\n\n----- AUTOR -----\n" +
                "Nome: "+ getNomeAutor()+
                "\nAno de Nascimento: "+anoNascimento+
                "\nAno de falecimento: "+anoFalecimento+
                "\n\n";
    }
}
