package com.alura.literalura.view;


import com.alura.literalura.service.AutorService;
import com.alura.literalura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class Menu {
    private final LivroService livroService;
    private final AutorService autorService;

    @Autowired
    public Menu(LivroService livroService, AutorService autorService) {
        this.livroService = livroService;
        this.autorService = autorService;
    }


    public void executarMenu(){

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        String menu ="""
                
                1 - Buscar livro pelo título
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - listas autores vivos em um determinado período
                5 - listar livros em um determinado idioma
                
                0 - Sair
                """;
        System.out.println("Seja bem vindo ao Literalura\n");
        while (opcao != 0) {
            System.out.println(menu);
            boolean inputValido = false;

            while (!inputValido) {
                try {
                    opcao = scanner.nextInt();
                    scanner.nextLine();
                    inputValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Opção inválida, tente novamente");
                    scanner.nextLine();
                }
            }

            switch (opcao) {
                case 1:
                    livroService.persistirLivro(livroService.buscarLivroWeb());
                    break;
                case 2:
                    livroService.listarLivros();
                    break;
                case 3:
                    autorService.listarAutores();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
