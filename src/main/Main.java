package main;

import repository.ClienteRepository;
import repository.PedidoRepository;
import repository.ProdutoRepository;
import service.ClienteService;
import service.NotificacaoService;
import service.PedidoService;
import service.ProdutoService;

public class Main {
    public static void main(String[] args) {
        // Inicializa repositórios
        ClienteRepository clienteRepository = new ClienteRepository();
        ProdutoRepository produtoRepository = new ProdutoRepository();
        PedidoRepository pedidoRepository = new PedidoRepository();

        // Inicializa serviços
        ClienteService clienteService = new ClienteService(clienteRepository);
        ProdutoService produtoService = new ProdutoService(produtoRepository);
        NotificacaoService notificacaoService = new NotificacaoService(); // Instancia o NotificacaoService
        PedidoService pedidoService = new PedidoService(pedidoRepository, notificacaoService); // Passa o NotificacaoService

        // Inicializa o menu
        MenuService menuService = new MenuService(clienteService, produtoService, pedidoService);
        menuService.executar();
    }
}