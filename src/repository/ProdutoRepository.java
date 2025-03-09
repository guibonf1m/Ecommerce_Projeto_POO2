package repository;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private List<Produto> produtos = new ArrayList<>();

    // Cadastrar um novo produto
    public void cadastrar(Produto produto) {
        produtos.add(produto);
    }

    // Listar todos os produtos
    public List<Produto> listarTodos() {
        return produtos;
    }

    // Buscar produto por ID
    public Produto buscarPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) { // Usa == para comparar int
                return produto;
            }
        }
        return null; // Retorna null se o produto não for encontrado
    }
}