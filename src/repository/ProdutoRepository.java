package repository;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private List<Produto> produtos = new ArrayList<Produto>();

    public void cadastrar(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> listarTodos() {
        return produtos;
    }

    public Produto buscarPorIdentificador(int identificador){
        for (Produto produto : produtos){
            if (produto.getIndentificador() == identificador){
                return produto;
            }
        }
        return null;
    }
}
