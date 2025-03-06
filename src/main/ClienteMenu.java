package main;

import model.Cliente;
import service.ClienteService;
import java.util.Scanner;

public class ClienteMenu {
    private Scanner scanner;
    private ClienteService clienteService;

    // Construtor
    public ClienteMenu(Scanner scanner, ClienteService clienteService) {
        this.scanner = scanner;
        this.clienteService = clienteService;
    }

    // Cadastrar cliente
    public void cadastrarCliente() {
        System.out.println("Digite o ID do cliente:");
        String id = scanner.nextLine();

        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Digite o email do cliente:");
        String email = scanner.nextLine();

        System.out.println("Digite o telefone do cliente:");
        String telefone = scanner.nextLine();

        clienteService.cadastrarCliente(id, nome, email, telefone);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    // Listar clientes
    public void listarClientes() {
        System.out.println("Lista de Clientes:");
        clienteService.listarClientes().forEach(cliente ->
                System.out.println("ID: " + cliente.getId() + " | Nome: " + cliente.getNome())
        );
    }

    // Buscar cliente por ID
    public void buscarClientePorId() {
        System.out.println("Digite o ID do cliente:");
        String id = scanner.nextLine();

        Cliente cliente = clienteService.buscarClientePorId(id);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente.getNome());
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }
}