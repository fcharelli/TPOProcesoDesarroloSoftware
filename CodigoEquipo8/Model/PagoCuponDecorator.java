
import java.io.*;
import java.util.*;

/**
 *
 */
public class PagoCuponDecorator extends PagoDecorator {
    private final Cupon cupon;

    public PagoCuponDecorator(IPago pago, Cupon cupon) {
        super(pago);
        this.cupon = cupon;
    }

    @Override
    public boolean realizarPago(Pedido p) {
        if (!cupon.esValido() || cupon.isUsado()) {
            System.out.println("Error: " + cupon.getCodigo() + " no es Cupón valido o ya ha sido usado");
            return false;
        }

        // Aplicar descuento al pedido
        double montoOriginal = p.getTotal();
        double montoConDescuento = this.obtenerMonto(p);
        p.setTotal(montoConDescuento);

        mostrarDetalleDescuento(montoOriginal, montoConDescuento);
        cupon.fueUsado();

        return super.realizarPago(p);
    }

    @Override
    public double obtenerMonto(Pedido p) {
        return super.obtenerMonto(p) * (1 - cupon.getDescuento());
    }

    private void mostrarDetalleDescuento(double original, double conDescuento) {
        double descuentoAplicado = original - conDescuento;
        System.out.printf("Descuento aplicado: $%.2f (%.0f%%)%n",
                descuentoAplicado,
                cupon.getDescuento()*100);
        System.out.printf("Monto original: $%.2f | Nuevo monto: $%.2f%n",
                original, conDescuento);
    }
}