package interfaces;

import model.Cliente;

public interface Notificacao {
    void notificar(Cliente cliente, String mensagem);
}