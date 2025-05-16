import javax.crypto.CipherInputStream;
import java.awt.color.ProfileDataException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cupon cupon = new Cupon(0.2,"SANCHEZ12");
        Mesero Marcelo = new Mesero(1);
        Cliente Pedro = new Cliente("pedro@gmail.com",1, "Pedro86");

        Tarjeta TarjetaCredito = new TarjetaCredito("1230345143");
        Tarjeta TarjetaDebito = new TarjetaDebito(2000,"12357875");


        //CASO DE PEDIDO EXITOSO SIN USO DE CUPON
        //Restaurante crea menu
        MenuDigital menu = new MenuDigital();
        //se crean los productos y se agregan al menu
       Producto Milanesa = new Producto("Milanesa XL","Gran milanesa de carne XL", 19.99, false, Categoria.PRINCIPAL);
        Producto Sandwich = new Producto("Sandwich","De jamon y queso", 5.00, true, Categoria.ENTRADA);
        menu.agregarPlato(Milanesa);
        menu.agregarPlato(Sandwich);
        menu.mostrarMenu();

        // se inicializa el pedido
        Pedido pedido1 = new Pedido(Marcelo,Pedro,1, menu);
        pedido1.agregarItem(Milanesa, 7);
        pedido1.agregarItem(Sandwich, 2);
        pedido1.mostrarProductos();

        //se elige metodo de pago
        pedido1.metodoDePago(TarjetaCredito);
        //se decide pagar
        pedido1.pagar();

        //empleados actualizan el estado del pedido a listo para entregar
        pedido1.actualizarEstado();
        //empleados actualizan el estado del pedido a entregado
        pedido1.actualizarEstado();




        //CASO DE PEDIDO EXITOSO CON USO DE CUPON
        Cliente Juan = new Cliente("juan@gmail.com", 2,"Juan1999");
        MenuDigital menu2 = new MenuDigital();
        Producto Torta = new Producto("Chocotorta", "Torta con chocolate y dulce de leche",80.0,true,Categoria.POSTRE);
        menu2.agregarPlato(Sandwich);
        menu2.agregarPlato(Torta);
        menu2.mostrarMenu();

        Pedido pedido2 = new Pedido(Marcelo, Juan, 2, menu2);
        pedido2.agregarItem(Milanesa,3);
        pedido2.mostrarProductos();
        pedido2.agregarItem(Torta,1);
        pedido2.mostrarProductos();


        pedido2.metodoDePago(TarjetaDebito);
        pedido2.aplicarCupon(cupon);
        pedido2.pagar();

        //empleados actualizan el estado del pedido a listo para entregar
        pedido2.actualizarEstado();
        //empleados actualizan el estado del pedido a entregado
        pedido2.actualizarEstado();


        //Creacion del menu
        //TESTEO ELIMINACION DE PRODUCTOS DEL PEDIDO Y PEDIDOS VACIOS
        //EL PEDIDO VACIO SE GENERA COMENTANDO LAS LINEAS 75, 76 Y 77
        MenuDigital m3 = new MenuDigital();
        m3.agregarPlato(Milanesa);
        m3.agregarPlato(Torta);
        m3.agregarPlato(Sandwich);

        Producto Coca = new Producto("Coca Cola", "gaseosa sabor cola", 6, false, Categoria.BEBIDA);
        m3.agregarPlato(Coca);
        m3.mostrarMenu();

        Cliente charo = new Cliente("batman@gmail.com", 33, "SoyBatman");
        Mesero nemi = new Mesero(96);

        Pedido pedidoCharo = new Pedido(nemi, charo, 44, m3);
        pedidoCharo.agregarItem(Milanesa, 4);
        pedidoCharo.agregarItem(Coca, 8);
        pedidoCharo.eliminarProducto(Coca, 5);

        pedidoCharo.mostrarProductos();
        Tarjeta TJCharo = new TarjetaDebito(100, "19827428");
        pedidoCharo.metodoDePago(TJCharo);
        pedidoCharo.pagar();

        pedidoCharo.actualizarEstado();
        pedidoCharo.actualizarEstado();

        //SOLICITUD DE PRODUCTO SIN EXISTENCIA EN EL MENU

        MenuDigital m4 = new MenuDigital();
        m4.agregarPlato(Milanesa);
        m4.agregarPlato(Torta);
        m4.agregarPlato(Sandwich);

        Cliente Maria = new Cliente("mariasusana@gmail.com", 1122,"marilu");
        Tarjeta CreditoMaria = new TarjetaCredito("102913817");
        Mesero Valentin = new Mesero(2321);


        Pedido pedidoMaria = new Pedido(Valentin, Maria, 38273821, m4);
        pedidoMaria.agregarItem(Coca, 20);

        pedidoMaria.mostrarProductos();
        pedidoMaria.metodoDePago(CreditoMaria);
        pedidoMaria.pagar();

        //CASO CUPON NO VALIDO
        MenuDigital m5 = new MenuDigital();
        m5.agregarPlato(Milanesa);
        m5.agregarPlato(Torta);
        m5.agregarPlato(Sandwich);

        Cliente Anastasio = new Cliente("anassanchez@hotmail.com", 1122,"anakin");
        Tarjeta TarjetaDeAnastasio = new TarjetaCredito("918329821");
        Mesero German = new Mesero(122);


        Pedido pedido4 = new Pedido(Valentin, Maria, 983273812, m5);
        pedido4.agregarItem(Milanesa, 20);

        Cupon cupon2 = new Cupon(0.90, "FREEFOOD100");
        pedido4.mostrarProductos();
        pedido4.metodoDePago(CreditoMaria);
        pedido4.aplicarCupon(cupon2);
        pedido4.pagar();

        pedido4.actualizarEstado();
        pedido4.actualizarEstado();

        //CASO METODO DE PAGO NO SELECCIONADO

        MenuDigital Wendys = new MenuDigital();
        Producto hamburguesa = new Producto("Cheeseburger", "Doble carne y queso", 39.99, false, Categoria.PRINCIPAL);
        Producto papas = new Producto("Papas fritas", "Papas regilla", 18.99, false, Categoria.ENTRADA);

        Wendys.agregarPlato(hamburguesa);
        Wendys.agregarPlato(papas);
        Wendys.agregarPlato(Coca);

        Wendys.mostrarMenu();

        Cliente Franco = new Cliente("francoch@yahoo.com", 9122111, "March");
        Mesero Matias = new Mesero(822);

        Pedido cajitaFeliz = new Pedido(Matias, Franco, 123894392, Wendys);
        cajitaFeliz.agregarItem(hamburguesa,1);
        cajitaFeliz.agregarItem(papas,1);
        cajitaFeliz.agregarItem(Coca, 2);

        cajitaFeliz.mostrarProductos();

        cajitaFeliz.pagar();











    }
}