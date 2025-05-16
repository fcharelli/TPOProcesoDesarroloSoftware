
/**
 * 
 */
public abstract class Tarjeta implements IPago {

    protected String ultimos4Digitos;

    public Tarjeta(String numeroTarjeta) {
        this.ultimos4Digitos = numeroTarjeta.substring(numeroTarjeta.length() - 4);
    }


    @Override public abstract boolean realizarPago(Pedido p) ;

    @Override public String obtenerMetodoPago() { return "Tarjeta"; }

    public String getUltimos4Digitos() {
        return ultimos4Digitos;
    }
}
