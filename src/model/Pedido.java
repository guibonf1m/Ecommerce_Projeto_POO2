package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private Date dataCriacao;
    private StatusPedido status;
    private List<ItemPedido> itens;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.dataCriacao = new Date();
        this.status = StatusPedido.ABERTO;
        this.itens = new ArrayList<>();
    }

    // Métodos para adicionar e remover itens
    public void adicionarItem(ItemPedido item) {
        if (status == StatusPedido.ABERTO) {
            itens.add(item);
        } else {
            throw new IllegalStateException("Não é possível adicionar itens a um pedido " + status);
        }
    }

    public void removerItem(ItemPedido item) {
        if (status == StatusPedido.ABERTO) {
            itens.remove(item);
        } else {
            throw new IllegalStateException("Não é possível remover itens de um pedido " + status);
        }
    }

    // Calcular o valor total do pedido
    public double calcularValorTotal() {
        return itens.stream()
                .mapToDouble(ItemPedido::getValorTotal)
                .sum();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente.getNome() +
                ", dataCriacao=" + dataCriacao +
                ", status=" + status +
                ", itens=" + itens +
                ", valorTotal=" + calcularValorTotal() +
                '}';
    }
}