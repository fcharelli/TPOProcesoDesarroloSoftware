
import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class Estado {

    /**
     * Default constructor
     */
    public Estado() {
    }



    public abstract void procesar(Pedido pedido);

    public void notificar(Pedido pedido, String mensajeCliente, String mensajeStaff) {
        pedido.getPersonas().forEach(per -> {
            if (per instanceof Cliente) {
                per.notificar(mensajeCliente, pedido);
            } else if (per instanceof Mesero) {
                per.notificar(mensajeStaff, pedido);
            }
        });
    }



}