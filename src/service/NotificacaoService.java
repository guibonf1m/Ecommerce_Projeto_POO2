package service;

import model.Cliente;

public class NotificacaoService {
    private NotificacaoEmail notificacaoEmail = new NotificacaoEmail();
    private NotificacaoWhats notificacaoWhats = new NotificacaoWhats();

    // Notificar o cliente por e-mail e WhatsApp
    public void notificarCliente(Cliente cliente, String mensagem) {
        notificacaoEmail.notificar(cliente, mensagem); // Notificação por e-mail
        notificacaoWhats.notificar(cliente, mensagem); // Notificação por WhatsApp
    }
}