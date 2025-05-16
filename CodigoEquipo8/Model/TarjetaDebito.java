/**
 * 
 */
public class TarjetaDebito extends Tarjeta {



    private double fondos;
    /**
     * Default constructor
     */
    public TarjetaDebito(double fondos, String numeroTarjeta) {
        super( numeroTarjeta);
        this.fondos = fondos;
    }

    /**
     * @return
     */
    public boolean realizarPago(Pedido p) {
        System.out.println("Procesando pago de " + p.getTotal() + " pesos con tarjeta terminada en " + ultimos4Digitos);
        if (fondos>p.getTotal()) {
            System.out.println("Pago exitoso!");
            return true;
        }else{
            System.out.println("SALDOS INSUFICIENTES EN LA TARJETA");
            return false;
        }

    }

    @Override
    public double obtenerMonto(Pedido p) {
        return p.getTotal();
    }

}