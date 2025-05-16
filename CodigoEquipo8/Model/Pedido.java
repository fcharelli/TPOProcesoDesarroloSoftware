

import java.util.*;

/**
 * 
 */
public class Pedido {
    /**
     * Default constructor
     */

    /**
     *
     */
    private ArrayList<ItemPedido> productos = new ArrayList<>();
    private List<IPersona> personas = new ArrayList<>();
    /**
     *
     */
    private IPago pago;

    private MenuDigital menu;

    /**
     *
     */
    private Estado estado;

    /**
     *
     */
    private int numeroPedido;


    /**
     *
     */
    private Cliente cliente;
    private boolean pagorealizado = false;
    /**
     *
     */
    private Mesero mesero;

    private int f;


    public Pedido(Mesero mesero, Cliente cliente, int numeroPedido, MenuDigital menu) {
        this.mesero = mesero;
        this.cliente = cliente;
        personas.add(mesero);
        personas.add(cliente);
        this.numeroPedido = numeroPedido;
        this.estado = new EnEspera();
        this.menu = menu;

    }


    public void agregarItem(Producto plato, int cantidad) {
        if (menu.contieneProducto(plato)) {
            productos.add(new ItemPedido(plato, cantidad));
            calcularTotal();
        } else {
            System.out.println("Ese producto no se encuentra dentro del menu");
        }
    }


    public void eliminarProducto(Producto producto, int cantidad) {
        for (int i = 0; i < productos.size(); i++) {
            ItemPedido item = productos.get(i);
            if (item.getProducto().equals(producto)) {
                if (item.getCantidad() > cantidad) {
                    item.setCantidad(item.getCantidad() - cantidad);
                } else {
                    productos.remove(i); // Elimina si la cantidad es igual o menor
                }
                break;
            }
        }
    }

    private double total;

    public void calcularTotal() {
        setTotal(productos.stream()
                .mapToDouble(ItemPedido::calcularSubtotal)
                .sum());
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }


    public void pagar() {
        try {
            // Validar que el pedido tenga productos
            if (productos.isEmpty()) {
                System.out.println("PEDIDO SIN PRODUCTOS - No se puede realizar el pago");
                return;
            }

            // Validar que se haya establecido un método de pago
            if (this.pago == null) {
                System.out.println("ERROR: No se ha seleccionado un método de pago");
                return;
            }

            // Intentar realizar el pago
            if (this.pago.realizarPago(this)) {
                estado.procesar(this);
                pagorealizado = true;
                System.out.println("Pago realizado con éxito - Pedido #" + numeroPedido);
            } else {
                System.out.println("Pedido cancelado debido a falta de pago");
                pagorealizado = false;
            }
        } catch (Exception e) {
            System.out.println("Error durante el proceso de pago: " + e.getMessage());
            pagorealizado = false;
        }
    }


//    public void pagarConTarjetaCredito(Tarjeta tarjeta) {
//        pago = new PagoCredito(this.calcularTotal(), tarjeta.getUltimos4Digitos());
//        if (pago.realizarPago(this)) {
//            estado.procesar(this);
//            f=1;
//        }
//    }


    public void aplicarCupon(Cupon c) {
        // TODO implement here
        if (productos.isEmpty()) {
            if (!pagorealizado) {
                if (c.esValido()) {
                    IPago pagoconCupon = new PagoCuponDecorator(this.getPago(), c);
                    pagoconCupon.realizarPago(this);
                } else {
                    System.out.println("El cupon no es valido");
                }
            } else {
                System.out.println("El pago ya fue realizado");
            }
        }else {
            System.out.println("PEDIDO VACIO, CUPON NO APLICABLE");
        }
    }


    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void actualizarEstado() {
        if (pagorealizado) {
            if (!(estado instanceof Entregado)) {
                estado.procesar(this);
            } else {
                System.out.println("El pedido ya ha sido entregado");
            }
        } else {
            System.out.println("PEDIDO DADO DE BAJA, NO ACTUALIZACION");
        }

    }

    public IPago getPago() {
        return pago;
    }

    public void metodoDePago(IPago pago) {
        this.pago = pago;
    }

    public ArrayList<ItemPedido> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<ItemPedido> productos) {
        this.productos = productos;
    }

    public List<IPersona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<IPersona> personas) {
        this.personas = personas;
    }


    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("\n El pedido #" + numeroPedido + " no tiene productos.");
            return;
        }

        // Calcular Total
        calcularTotal();

        // Encabezado
        System.out.println("\n==========================================================================================");
        System.out.println("  PRODUCTOS DEL PEDIDO #" + numeroPedido);
        System.out.println("==========================================================================================");
        System.out.printf("%-6s %-25s %-10s %-10s %-15s %s%n",
                "CANT.", "PRODUCTO", "PRECIO", "SUBTOTAL", "CATEGORÍA", "ALERGENOS");
        System.out.println("------------------------------------------------------------------------------------------");

        // Productos
        for (ItemPedido item : productos) {
            double subtotal = item.calcularSubtotal();
            String alergenos = item.getAlergenos() ? "SI" : "NO";

            System.out.printf("%-6d %-25s $%-9.2f $%-9.2f %-15s %s%n",
                    item.getCantidad(),
                    item.getProducto().getNombre(),
                    item.getProducto().getPrecio(),
                    subtotal,
                    item.getProducto().getCategoria(),
                    alergenos);
        }

        // Totales
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf("%52s $%-9.2f%n", "TOTAL:", getTotal());
        System.out.println("==========================================================================================");
        System.out.println("Estado actual: " + estado.getClass().getSimpleName());
    }
}
