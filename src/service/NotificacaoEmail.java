package service;

import model.Cliente;

public class NotificacaoEmail implements interfaces.Notificacao {
    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.println("Enviando e-mail para " + cliente.getEmail() + ": " + mensagem);
    }
}