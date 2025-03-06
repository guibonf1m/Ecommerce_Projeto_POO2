package service;

import model.Cliente;
import repository.ClienteRepository;

import java.util.List;

public class ClienteService {
    private ClienteRepository repository;

    // Construtor
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    // Buscar cliente por ID (String)
    public Cliente buscarClientePorId(String id) {
        return repository.buscarPorId(id);
    }

    // Cadastrar cliente
    public void cadastrarCliente(String id, String nome, String email, String telefone) {
        Cliente cliente = new Cliente(id, nome, email, telefone);
        repository.cadastrar(cliente);
    }

    // Listar todos os clientes
    public List<Cliente> listarClientes() {
        return repository.listarTodos();
    }
}