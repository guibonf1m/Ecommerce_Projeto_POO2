package main;

import main.ClienteMenu;
import main.ProdutoMenu;
import service.ClienteService;
import service.PedidoService;
import service.ProdutoService;
import java.util.Scanner;

public class MenuService {
    private Scanner scanner;
    private ClienteMenu clienteMenu;
    private ProdutoMenu produtoMenu;
    private PedidoMenu pedidoMenu;

    public MenuService(ClienteService clienteService, ProdutoService produtoService, PedidoService pedidoService) {
        this.scanner = new Scanner(System.in);
        this.clienteMenu = new ClienteMenu(scanner, clienteService);
        this.produtoMenu = new ProdutoMenu(scanner, produtoService);
        this.pedidoMenu = new PedidoMenu(scanner, pedidoService, clienteService, produtoService);
    }

    public void executar() {
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Cadastrar Produto");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Criar Pedido");
            System.out.println("6. Adicionar Item ao Pedido");
            System.out.println("7. Remover Item do Pedido"); // Nova opção
            System.out.println("8. Aguardar Pagamento");
            System.out.println("9. Pagar Pedido");
            System.out.println("10. Finalizar Pedido");
            System.out.println("11. Listar Pedidos");
            System.out.println("12. Ver Status do Pedido");
            System.out.println("13. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    clienteMenu.cadastrarCliente();
                    break;
                case 2:
                    clienteMenu.listarClientes();
                    break;
                case 3:
                    produtoMenu.cadastrarProduto();
                    break;
                case 4:
                    produtoMenu.listarProdutos();
                    break;
                case 5:
                    pedidoMenu.criarPedido();
                    break;
                case 6:
                    pedidoMenu.adicionarItemAoPedido();
                    break;
                case 7:
                    pedidoMenu.removerItemDoPedido(); // Nova opção
                    break;
                case 8:
                    pedidoMenu.aguardarPagamento();
                    break;
                case 9:
                    pedidoMenu.pagarPedido();
                    break;
                case 10:
                    pedidoMenu.finalizarPedido();
                    break;
                case 11:
                    pedidoMenu.listarPedidos();
                    break;
                case 12:
                    pedidoMenu.verStatusPedido();
                    break;
                case 13:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}