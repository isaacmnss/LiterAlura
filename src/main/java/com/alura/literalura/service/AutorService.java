package com.alura.literalura.service;

import com.alura.literalura.model.Autor;
import com.alura.literalura.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class AutorService {
    private final AutorRepository autorRepository;


    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public void listarAutores() {
        List<Autor> autoresEncontrados = autorRepository.findAll();
        autoresEncontrados.forEach(System.out::println);
    }

    public void listarAutoresVivosEmAno(Scanner scanner){
        System.out.println("Digite o ano que deseja pesquisar");
        int ano = scanner.nextInt();
        List<Autor> autoresEncontrados = autorRepository.findByAnoFalecimentoGreaterThan(ano);
        if (!autoresEncontrados.isEmpty()){
            System.out.println("autores vivos em "+ano+": ");
            autoresEncontrados.forEach(System.out::println);
        }else {
            System.out.println("Nenhum autor vivo neste ano encontrado na base de dados.");
        }

    }

}
