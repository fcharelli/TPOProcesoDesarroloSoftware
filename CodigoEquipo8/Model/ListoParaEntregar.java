
import java.io.*;
import java.util.*;

/**
 * 
 */
public class ListoParaEntregar extends Estado {



    NotificadorEmail notificadorFactura = new NotificadorEmail();

    public ListoParaEntregar() {}


    @Override
    public void procesar(Pedido pedido) {

        pedido.setEstado(new Entregado());

        // Notificación específica para este estado
        notificar(pedido, "Tu pedido ya fue entregado. Disfrutalo!", "Pedido #" + pedido.getNumeroPedido() + " ya ha sido entregado");
        Random rand = new Random();
        int min = 1;
        int max = 100;
        int nroFactura = rand.nextInt((max - min) + 1) + min;
        Factura factura = new Factura(nroFactura, pedido.getTotal(), pedido.getCliente(), pedido.getProductos());
        notificadorFactura.enviarEmail(factura.getDestino().getMail(),factura);
    }

}