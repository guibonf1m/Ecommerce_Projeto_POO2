package repository;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();

    // Cadastrar um novo cliente
    public void cadastrar(Cliente cliente) {
        clientes.add(cliente);
    }

    // Listar todos os clientes
    public List<Cliente> listarTodos() {
        return clientes;
    }

    // Buscar cliente por ID (String)
    public Cliente buscarPorId(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) { // Usa equals para comparar strings
                return cliente;
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }
}