package main;

import model.Produto;
import service.ProdutoService;

import java.util.Scanner;

public class ProdutoMenu {
    private Scanner scanner;
    private ProdutoService produtoService;

    public ProdutoMenu(Scanner scanner, ProdutoService produtoService) {
        this.scanner = scanner;
        this.produtoService = produtoService;
    }

    public void cadastrarProduto() {
        System.out.println("\n--- Cadastro de Produto ---");
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Identificador do produto: ");
        int identificador = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Categoria do produto: ");
        String categoria = scanner.nextLine();
        System.out.print("Valor de venda: ");
        double valorVenda = scanner.nextDouble();
        System.out.print("Valor do produto: ");
        double valorProduto = scanner.nextDouble();
        System.out.print("Valor do desconto: ");
        double valorDesconto = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        Produto produto = new Produto(nome, identificador, categoria, valorVenda, valorProduto, valorDesconto);
        try {
            produtoService.cadastrarProduto(produto);
            System.out.println("Produto cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    public void listarProdutos() {
        System.out.println("\n--- Lista de Produtos Cadastrados ---");
        produtoService.listarProdutos().forEach(System.out::println);
    }
}