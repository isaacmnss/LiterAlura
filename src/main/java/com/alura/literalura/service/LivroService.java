package com.alura.literalura.service;

import com.alura.literalura.model.LivroRecord;
import com.alura.literalura.repository.LivroRepository;

import java.util.Scanner;

public class LivroService {
    private final Scanner scanner = new Scanner(System.in);
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final ConverteDados converteDados = new ConverteDados();
    private final LivroRepository livroRepository;
    private final String ENDERECO = "https://gutendex.com/books?search=";

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public LivroRecord buscarLivroWeb(){
        System.out.println("Digite o nome do livro que deseja buscar");
        String inputUser = scanner.nextLine().trim().toLowerCase().replace(" ", "%20");
        String busca = ENDERECO + inputUser;
        String json = consumoApi.obterDados(busca);
        return converteDados.obterDados(json, LivroRecord.class);
    }

}
