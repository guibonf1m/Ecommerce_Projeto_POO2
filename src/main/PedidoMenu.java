package main;

import model.Produto;
import service.PedidoService;
import service.ClienteService;
import service.ProdutoService;
import model.Cliente;
import model.Pedido;
import model.ItemPedido;
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

        // Busca o pedido pelo ID
        Pedido pedido = pedidoService.buscarPedidoPorId(idPedido);
        if (pedido == null) {
            System.out.println("Pedido não encontrado!");
            return;
        }

        System.out.println("Digite o ID do produto:");
        int idProduto = scanner.nextInt(); // Lê o ID do produto como int
        scanner.nextLine(); // Consumir a nova linha

        // Busca o produto pelo ID
        Produto produto = produtoService.buscarProdutoPorId(idProduto);
        if (produto == null) {
            System.out.println("Produto não encontrado!");
            return;
        }

        System.out.println("Digite a quantidade:");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.println("Digite o preço:");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        // Adiciona o item ao pedido
        pedidoService.adicionarItem(pedido, produto, quantidade, preco);
        System.out.println("Item adicionado com sucesso!");
    }

    // Método para remover item do pedido
    public void removerItemDoPedido() {
        System.out.println("Digite o ID do pedido:");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        // Busca o pedido pelo ID
        Pedido pedido = pedidoService.buscarPedidoPorId(idPedido);
        if (pedido == null) {
            System.out.println("Pedido não encontrado!");
            return;
        }

        // Lista os itens do pedido
        System.out.println("Itens do Pedido #" + pedido.getId() + ":");
        for (ItemPedido item : pedido.getItens()) {
            System.out.println("Produto: " + item.getProduto().getNome() + " | Quantidade: " + item.getQuantidade());
        }

        System.out.println("Digite o nome do produto que deseja remover:");
        String nomeProduto = scanner.nextLine();

        // Encontra o item a ser removido
        ItemPedido itemParaRemover = null;
        for (ItemPedido item : pedido.getItens()) {
            if (item.getProduto().getNome().equalsIgnoreCase(nomeProduto)) {
                itemParaRemover = item;
                break;
            }
        }

        if (itemParaRemover != null) {
            pedidoService.removerItem(pedido, itemParaRemover);
            System.out.println("Item removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado no pedido!");
        }
    }

    // Método para aguardar pagamento
    public void aguardarPagamento() {
        System.out.println("Digite o ID do pedido:");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Pedido pedido = pedidoService.buscarPedidoPorId(idPedido);
        if (pedido != null) {
            pedidoService.aguardarPagamento(pedido);
            System.out.println("Aguardando pagamento do pedido!");
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }

    // Método para pagar pedido
    public void pagarPedido() {
        System.out.println("Digite o ID do pedido:");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Pedido pedido = pedidoService.buscarPedidoPorId(idPedido);
        if (pedido != null) {
            pedidoService.pagarPedido(pedido);
            System.out.println("Pedido pago com sucesso!");
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }

    // Método para finalizar pedido
    public void finalizarPedido() {
        System.out.println("Digite o ID do pedido:");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Pedido pedido = pedidoService.buscarPedidoPorId(idPedido);
        if (pedido != null) {
            pedidoService.finalizarPedido(pedido);
            System.out.println("Pedido finalizado com sucesso!");
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }

    // Método para listar todos os pedidos
    public void listarPedidos() {
        for (Pedido pedido : pedidoService.listarPedidos()) {
            System.out.println(pedido);
        }
    }

    // Método para ver status do pedido
    public void verStatusPedido() {
        System.out.println("Digite o ID do pedido:");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Pedido pedido = pedidoService.buscarPedidoPorId(idPedido);
        if (pedido != null) {
            System.out.println("Status do pedido: " + pedido.getStatus());
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }
}