package model;

public class Produto {
    private String nome;
    private int id; // Renomeado para id
    private String categoria;
    private double valorVenda;
    private double valorProduto;
    private double valorDesconto;

    public Produto(String nome, int id, String categoria, double valorVenda, double valorProduto, double valorDesconto) {
        this.nome = nome;
        this.id = id; // Renomeado para id
        this.categoria = categoria;
        this.valorVenda = valorVenda;
        this.valorProduto = valorProduto;
        this.valorDesconto = valorDesconto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() { // Renomeado para getId
        return id;
    }

    public void setId(int id) { // Renomeado para setId
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", id=" + id + // Renomeado para id
                ", categoria='" + categoria + '\'' +
                ", valorVenda=" + valorVenda +
                ", valorProduto=" + valorProduto +
                ", valorDesconto=" + valorDesconto +
                '}';
    }
}
