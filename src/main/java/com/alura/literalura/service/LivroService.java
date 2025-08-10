package com.alura.literalura.service;

import com.alura.literalura.model.GutendexResponse;
import com.alura.literalura.model.Livro;
import com.alura.literalura.model.LivroRecord;
import com.alura.literalura.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class LivroService {
    private final Scanner scanner = new Scanner(System.in);
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final ConverteDados converteDados = new ConverteDados();
    private final LivroRepository livroRepository;
    private final String ENDERECO = "https://gutendex.com/books?search=";

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro buscarLivroWeb(){

        System.out.println("Digite o nome do livro que deseja buscar");
        String inputUser = scanner.nextLine().trim().toLowerCase().replace(" ", "%20");
        String busca = ENDERECO + inputUser;

        String json = consumoApi.obterDados(busca);

        GutendexResponse resposta =  converteDados.obterDados(json, GutendexResponse.class);
        if (resposta.results() == null || resposta.results().isEmpty()) {
            System.out.println("Nenhum livro encontrado para essa busca.");
            return null;
        }
        LivroRecord livroRecord = resposta.results().get(0);
        Livro livro = new Livro(livroRecord);
        return livro;
    }

    public void persistirLivro(Livro livro){
        livroRepository.save(livro);
        System.out.println(livro);
    }

    public void listarLivros(){
        List<Livro> livrosBuscados = livroRepository.findAll();
        livrosBuscados.forEach(System.out::println);

    }

    public void listarLivrosPorIdioma(Scanner scanner){
        System.out.println("Insira o idioma para realizar a busca:" +
                "\npt - português" +
                "\nen - inglês" +
                "\nfr - francês" +
                "\nes - espanhol");
        String inputIdioma = scanner.nextLine();
        List<Livro> livrosBuscados = livroRepository.findByIdioma(inputIdioma);
        if(!livrosBuscados.isEmpty()){
            System.out.println("Livros encontrados: ");
            livrosBuscados.forEach(System.out::println);

        }else{
            System.out.println("Nenhum livro encontrado com este idioma");
        }

    }


}
