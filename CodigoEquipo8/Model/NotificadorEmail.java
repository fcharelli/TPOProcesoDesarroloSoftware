
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 */
public class NotificadorEmail {
    public void enviarEmail(String email, Factura factura) {
        System.out.println("Enviando factura a " + email + ":" + " Numero de factura: " + factura.getNroFactura() +" por la compra de los siguientes productos: "+ factura.getProductos().stream()
                .map(ItemPedido::getNombre)
                .collect(Collectors.joining(", ")) + " por un monto de: " +factura.getMonto());

    }
}