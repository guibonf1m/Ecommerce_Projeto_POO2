package service;

import model.Cliente;

public class NotificacaoWhats implements interfaces.Notificacao {
    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.println("Enviando mensagem via WhatsApp para " + cliente.getNome() + ": " + mensagem);
    }
}
