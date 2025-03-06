// src/main/PedidoMenu.java
package main;

import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import service.ClienteService;
import service.PedidoService;
import service.ProdutoService;

import java.util.Scanner;

public class PedidoMenu {
    private Scanner scanner;
    private PedidoService pedidoService;
    private ClienteService clienteService;
    private ProdutoService produtoService;

    public PedidoMenu(Scanner scanner, PedidoService pedidoService, ClienteService clienteService, ProdutoService produtoService) {
        this.scanner = scanner;
        this.pedidoService = pedidoService;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    // Método para criar um novo pedido
    public void criarPedido() {
        System.out.println("Digite o ID do pedido:");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.println("Digite o ID do cliente:");
        String idCliente = scanner.nextLine();

        // Busca o cliente pelo ID
        Cliente cliente = clienteService.buscarClientePorId(idCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        // Cria o pedido usando o PedidoService
        pedidoService.criarPedido(idPedido, cliente);
        System.out.println("Pedido criado com sucesso!");
    }

    // Método para adicionar item ao pedido
    public void adicionarItemAoPedido() {
        System.out.println("Digite o ID do pedido:");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Pedido pedido = pedidoService.buscarPedidoPorId(idPedido);
        if (pedido == null) {
            System.out.println("Pedido não encontrado!");
            return;
        }

        System.out.println("Digite o identificador do produto:");
        int idProduto = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Produto produto = produtoService.buscarProdutoPorIdentificador(idProduto);
        if (produto == null) {
            System.out.println("Produto não encontrado!");
            return;
        }

        System.out.println("Digite a quantidade:");
        int quantidade = scanner.nextInt();

        System.out.println("Digite o valor de venda:");
        double valorVenda = scanner.nextDouble();

        pedidoService.adicionarItem(pedido, produto, quantidade, valorVenda);
        System.out.println("Item adicionado com sucesso!");
    }

    // Método para remover item do pedido
    public void removerItemDoPedido() {
        System.out.println("Digite o ID do pedido:");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Pedido pedido = pedidoService.buscarPedidoPorId(idPedido);
        if (pedido == null) {
            System.out.println("Pedido não encontrado!");
            return;
        }

        System.out.println("Digite o ID do produto:");
        int idProduto = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        ItemPedido item = pedido.getItens().stream()
                .filter(i -> i.getProduto().getIndentificador() == idProduto)
                .findFirst()
                .orElse(null);

        if (item == null) {
            System.out.println("Item não encontrado no pedido!");
            return;
        }

        pedidoService.removerItem(pedido, item);
        System.out.println("Item removido com sucesso!");
    }

    // Método para aguardar pagamento
    public void aguardarPagamento() {
        System.out.println("Digite o ID do pedido:");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Pedido pedido = pedidoService.buscarPedidoPorId(idPedido);
        if (pedido == null) {
            System.out.println("Pedido não encontrado!");
            return;
        }

        pedidoService.aguardarPagamento(pedido);
        System.out.println("Status do pedido alterado para 'Aguardando Pagamento'.");
    }

    // Método para pagar pedido
    public void pagarPedido() {
        System.out.println("Digite o ID do pedido:");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Pedido pedido = pedidoService.buscarPedidoPorId(idPedido);
        if (pedido == null) {
            System.out.println("Pedido não encontrado!");
            return;
        }

        pedidoService.pagarPedido(pedido);
        System.out.println("Pedido pago com sucesso!");
    }

    // Método para finalizar pedido
    public void finalizarPedido() {
        System.out.println("Digite o ID do pedido:");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Pedido pedido = pedidoService.buscarPedidoPorId(idPedido);
        if (pedido == null) {
            System.out.println("Pedido não encontrado!");
            return;
        }

        pedidoService.finalizarPedido(pedido);
        System.out.println("Pedido finalizado com sucesso!");
    }

    // Método para listar pedidos
    public void listarPedidos() {
        System.out.println("Lista de Pedidos:");
        pedidoService.listarPedidos().forEach(pedido ->
                System.out.println("ID: " + pedido.getId() + " | Cliente: " + pedido.getCliente().getNome() + " | Status: " + pedido.getStatus())
        );
    }

    // Método para ver status do pedido
    public void verStatusPedido() {
        System.out.println("Digite o ID do pedido:");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Pedido pedido = pedidoService.buscarPedidoPorId(idPedido);
        if (pedido == null) {
            System.out.println("Pedido não encontrado!");
            return;
        }

        System.out.println("Status do pedido: " + pedido.getStatus());
    }
}