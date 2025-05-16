
import java.io.*;
import java.util.*;

/**
 *
 */

public abstract class PagoDecorator implements IPago {
    protected IPago pagoDecorado;

    public PagoDecorator(IPago pago) {
        this.pagoDecorado = pago;
    }
    @Override
    public boolean realizarPago(Pedido p) {
        return pagoDecorado.realizarPago(p);
    }

    @Override
    public double obtenerMonto(Pedido p) {
        return pagoDecorado.obtenerMonto(p);
    }

    @Override
    public String obtenerMetodoPago() {
        return pagoDecorado.obtenerMetodoPago();
    }
}