package service;

import model.Produto;
import repository.ProdutoRepository;

import java.util.List;

public class ProdutoService {
    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    // Cadastrar um novo produto
    public void cadastrarProduto(Produto produto){

        // Validações básicas
        if (produto.getNome() == null || produto.getNome().isEmpty()){
            throw new IllegalArgumentException("Nome do produto é obrigatório.");
        }
        if (produto.getValorVenda() <= 0){
            throw new IllegalArgumentException("Valor da venda deve ser maior que zero.");
        }
        if (produto.getValorProduto() <= 0){
            throw new IllegalArgumentException("Valor do produto deve ser maior que zero.");
        }
        repository.cadastrar(produto);
    }

    // Listar todos os produtos
    public List<Produto> listarProdutos(){
        return repository.listarTodos();
    }

    // Buscar produto por identificador
    public Produto buscarProdutoPorIdentificador(int identificador){
        return repository.buscarPorIdentificador(identificador);
    }
}
