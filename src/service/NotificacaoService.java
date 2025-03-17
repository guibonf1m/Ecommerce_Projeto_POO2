package service;

import model.Cliente;

public class NotificacaoService {
    private NotificacaoEmail notificacaoEmail = new NotificacaoEmail();
    private NotificacaoWhats notificacaoWhats = new NotificacaoWhats();

    // Notificar o cliente por e-mail e WhatsApp
    public void notificarCliente(Cliente cliente, String mensagem) {
        notificacaoEmail.notificar(cliente, mensagem);
        notificacaoWhats.notificar(cliente, mensagem);
    }
}