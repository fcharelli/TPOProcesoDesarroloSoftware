
import java.io.*;
import java.util.*;

/**
 * 
 */
public class EnPreparacion extends Estado {

    /**
     * Default constructor
     */
    public EnPreparacion() {
    }


    /**
     * @return
     */
    @Override
    public void procesar(Pedido pedido) {

        pedido.setEstado(new ListoParaEntregar());

        // Notificación específica para este estado
        notificar(pedido, "¡Tu pedido ya esta listo para recoger!", "Pedido #" + pedido.getNumeroPedido() + " listo para recoger");
    }

}