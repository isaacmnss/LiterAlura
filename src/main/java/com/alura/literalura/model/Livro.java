package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String idioma;
    private Integer numeroDownloads;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "livro_autores",
            joinColumns = @JoinColumn(name = "livros_id"),
            inverseJoinColumns = @JoinColumn(name = "autores_id")
    )
    private List<Autor> autores = new ArrayList<>();


    public Livro(String titulo, String idioma, Integer numeroDownloads) {

        this.titulo = titulo;
        this.idioma = idioma;
        this.numeroDownloads = numeroDownloads;
    }

    public Livro() {
    }

    public Livro(LivroRecord livroRecord) {
        this.titulo = livroRecord.titulo();
        this.idioma = livroRecord.idiomas().isEmpty() ? null : livroRecord.idiomas().get(0);
        this.numeroDownloads = livroRecord.numeroDownloads();

        this.autores = new ArrayList<>();
        if (livroRecord.autores() != null && !livroRecord.autores().isEmpty()) {
            for (AutorRecord autorRecord : livroRecord.autores()) {
                this.autores.add(new Autor(autorRecord));
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Integer numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "\n\n----- LIVRO -----\n" +
                "Título: "+ getTitulo()+
                "\nAutor(es): "+getAutores()+
                "\nIdioma: "+getIdioma()+
                "\nNúmero de downloads: "+getNumeroDownloads()+"\n\n";
    }
}
