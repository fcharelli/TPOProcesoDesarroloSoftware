
import java.io.*;
import java.util.*;


public class Cliente implements IPersona {

    private String mail;
    private int nroCliente;
    private String nombreApp;


    public Cliente(String mail, int nrocliente, String nombreapp) {
        this.mail = mail;
        nroCliente = nrocliente;
        nombreApp = nombreapp;

    }
    public String getMail() {
        return mail;
    }

    @Override
    public void notificar(String mensaje, Pedido pedido) {
        // Solo recibe mensajes para clientes
        System.out.println("[Cliente " + this.nombreApp + "] Notificación: " + mensaje);
        // Lógica de email/app...
    }
}