/**
 * 
 */
public class TarjetaCredito extends Tarjeta {

    /**
     * Default constructor
     */
    public TarjetaCredito(String numeroTarjeta) {
        super(numeroTarjeta);
    }

    /**
     * @return
     */
    public boolean realizarPago(Pedido p) {
        System.out.println("Procesando pago de " + p.getTotal() + " pesos con tarjeta terminada en " + ultimos4Digitos);
        System.out.println("Pago exitoso!");
        return true;

    }

    @Override
    public double obtenerMonto(Pedido p) {
        return p.getTotal();
    }

}