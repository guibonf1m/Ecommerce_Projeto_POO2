package service;

import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import model.StatusPedido;
import repository.PedidoRepository;

import java.util.List;

public class PedidoService {
    private PedidoRepository repository;
    private NotificacaoService notificacaoService;

    public PedidoService(PedidoRepository repository, NotificacaoService notificacaoService) {
        this.repository = repository;
        this.notificacaoService = notificacaoService;
    }

    // Criar um novo pedido
    public Pedido criarPedido(int id, Cliente cliente) {
        Pedido pedido = new Pedido(id, cliente);
        repository.cadastrar(pedido);
        return pedido;
    }

    // Adicionar item ao pedido
    public void adicionarItem(Pedido pedido, Produto produto, int quantidade, double valorVenda) {
        if (pedido.getStatus() == StatusPedido.ABERTO) {
            ItemPedido item = new ItemPedido(produto, quantidade, valorVenda);
            pedido.adicionarItem(item);
        } else {
            throw new IllegalStateException("Não é possível adicionar itens a um pedido " + pedido.getStatus());
        }
    }

    // Remover item do pedido
    public void removerItem(Pedido pedido, ItemPedido item) {
        if (pedido.getStatus() == StatusPedido.ABERTO) {
            pedido.removerItem(item);
        } else {
            throw new IllegalStateException("Não é possível remover itens de um pedido " + pedido.getStatus());
        }
    }

    // Alterar status do pedido para "Aguardando Pagamento" e notificar o cliente
    public void aguardarPagamento(Pedido pedido) {
        if (pedido.getStatus() == StatusPedido.ABERTO && !pedido.getItens().isEmpty()) {
            pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
            notificacaoService.notificarCliente(pedido.getCliente(), "Seu pedido #" + pedido.getId() + " está aguardando pagamento.");
        } else {
            throw new IllegalStateException("Não é possível alterar o status para AGUARDANDO_PAGAMENTO.");
        }
    }

    // Alterar status do pedido para "Pago" e notificar o cliente
    public void pagarPedido(Pedido pedido) {
        if (pedido.getStatus() == StatusPedido.AGUARDANDO_PAGAMENTO) {
            pedido.setStatus(StatusPedido.PAGO);
            notificacaoService.notificarCliente(pedido.getCliente(), "Seu pedido #" + pedido.getId() + " foi pago com sucesso!");
        } else {
            throw new IllegalStateException("Não é possível alterar o status para PAGO.");
        }
    }

    // Alterar status do pedido para "Finalizado" e notificar o cliente
    public void finalizarPedido(Pedido pedido) {
        if (pedido.getStatus() == StatusPedido.PAGO) {
            pedido.setStatus(StatusPedido.FINALIZADO);
            notificacaoService.notificarCliente(pedido.getCliente(), "Seu pedido #" + pedido.getId() + " foi finalizado e está pronto para entrega.");
        } else {
            throw new IllegalStateException("Não é possível finalizar um pedido " + pedido.getStatus());
        }
    }

    // Listar todos os pedidos
    public List<Pedido> listarPedidos() {
        return repository.listarTodos();
    }

    // Buscar pedido por ID
    public Pedido buscarPedidoPorId(int id) {
        return repository.buscarPorId(id);
    }

    // Método para ver o status de um pedido específico
    public void verStatusPedido(int idPedido) {
        Pedido pedido = repository.buscarPorId(idPedido); // Busca o pedido no repositório
        if (pedido != null) {
            System.out.println("Status do Pedido #" + pedido.getId() + ": " + pedido.getStatus());
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }
}