/**
// *
// */
public interface IPago {
    //boolean realizarPago();
    boolean realizarPago(Pedido p) ;
    double obtenerMonto(Pedido p);
    String obtenerMetodoPago();
}