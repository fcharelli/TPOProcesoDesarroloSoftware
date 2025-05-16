
import java.io.*;
import java.util.*;

/**
 * 
 */
public class EnEspera extends Estado {

    /**
     * Default constructor
     */
    public EnEspera() {
    }


    /**
     * @return
     */
    @Override
    public void procesar(Pedido pedido) {

        pedido.setEstado(new EnPreparacion());

        // Notificación específica para este estado
        notificar(pedido, "¡Tu pedido se encuentra en preparacion!", "Pedido #" + pedido.getNumeroPedido() + " en preparacion");
    }

}