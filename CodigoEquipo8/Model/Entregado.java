
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Entregado extends Estado {

    /**
     * Default constructor
     */
    public Entregado() {
    }


    @Override
    public void procesar(Pedido pedido) {
        // Notificación específica para este estado

        notificar(pedido, "¡Tu pedido se encuentra entregado!", "Pedido #" + pedido.getNumeroPedido() + " entregado");
    }

}