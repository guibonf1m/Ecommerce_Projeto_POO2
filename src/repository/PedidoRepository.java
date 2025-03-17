package repository;

import model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private List<Pedido> pedidos = new ArrayList<>();

    // Cadastrar um novo pedido
    public void cadastrar(Pedido pedido) {
        pedidos.add(pedido);
    }

    // Listar todos os pedidos
    public List<Pedido> listarTodos() {
        return pedidos;
    }

    // Buscar pedido por ID
    public Pedido buscarPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }
}