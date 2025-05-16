import java.util.List;

public class Factura {

    private double monto;
    private Cliente destino;
    private int nroFactura;
    private List<ItemPedido> productos;


    public Factura(int nroFactura, double monto, Cliente destino, List<ItemPedido> productos) {
        this.nroFactura= nroFactura;
        this.monto = monto;
        this.destino = destino;
        this.productos = productos;
    }


    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Cliente getDestino() {
        return destino;
    }

    public void setDestino(Cliente destino) {
        this.destino = destino;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public List<ItemPedido> getProductos() {
        return productos;
    }
}