package model;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double valorVenda;

    public ItemPedido(Produto produto, int quantidade, double valorVenda) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
    }

    // Getters e Setters
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    // Método para calcular o valor total do item
    public double getValorTotal() {
        return quantidade * valorVenda;
    }



    @Override
    public String toString() {
        return "ItemPedido{" +
                "produto=" + produto.getNome() +
                ", quantidade=" + quantidade +
                ", valorVenda=" + valorVenda +
                ", valorTotal=" + getValorTotal() +
                '}';
    }
}