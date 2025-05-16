
import javax.sound.sampled.Port;
import java.io.*;
import java.util.*;

/**
 * 
 */
public class ItemPedido {


    private int cantidad;

    /**
     *
     */
    private Producto producto;
    /**
     *
     * Default constructor
     */
    public ItemPedido(Producto p , int c ) {
        this.cantidad = c;
        this.producto = p;
    }

    /**
     * 
     */


    public String getNombre(){
        return producto.getNombre();
    }
    public boolean getAlergenos(){
        return producto.getAlergenicos();
    }
    public double getPrecio(){
        return producto.getPrecio();
    }
    public Categoria getCategoria(){
        return producto.getCategoria();
    }

    public double calcularSubtotal() {
        return (producto.getPrecio() * cantidad);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}