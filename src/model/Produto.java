package model;

public class Produto {
    private String nome;
    private int indentificador;
    private String categoria;
    private double valorVenda;
    private double valorProduto;
    private double valorDesconto;

    public Produto(String nome, int indentificador, String categoria, double valorVenda, double valorProduto, double valorDesconto) {
        this.nome = nome;
        this.indentificador = indentificador;
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

    public int getIndentificador() {
        return indentificador;
    }

    public void setIndentificador(int indentificador) {
        this.indentificador = indentificador;
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
                ", indentificador=" + indentificador +
                ", categoria='" + categoria + '\'' +
                ", valorVenda=" + valorVenda +
                ", valorProduto=" + valorProduto +
                ", valorDesconto=" + valorDesconto +
                '}';
    }
}
