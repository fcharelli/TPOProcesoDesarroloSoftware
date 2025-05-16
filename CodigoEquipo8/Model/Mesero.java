
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Mesero implements IPersona {

    /**
     * Default constructor
     */
    public Mesero(int nroEmpleado) {
        this.nroEmpleado = nroEmpleado;
    }

    /**
     * 
     */
    private int nroEmpleado;


    @Override
    public void notificar(String mensaje, Pedido pedido) {
        // Solo recibe mensajes para staff
        System.out.println("[Mesero " + this.nroEmpleado + "] Alerta: " + mensaje);
        // Lógica de notificación interna...
    }
}