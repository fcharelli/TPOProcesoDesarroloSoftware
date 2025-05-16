
import java.util.*;

/**
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuDigital {
    private final Map<Categoria, List<Producto>> platosPorCategoria;

    // Constructor que inicializa todas las categorías
    public MenuDigital() {
        platosPorCategoria = new EnumMap<>(Categoria.class);
        for (Categoria cat : Categoria.values()) {
            platosPorCategoria.put(cat, new ArrayList<>());
        }
    }

    // Método seguro para agregar platos
    public void agregarPlato(Producto producto) {
        Objects.requireNonNull(producto, "El producto no puede ser nulo");
        Objects.requireNonNull(producto.getCategoria(), "La categoría del producto no puede ser nula");

        List<Producto> platos = platosPorCategoria.get(producto.getCategoria());
        if (platos == null) {
            throw new IllegalStateException("Categoría no inicializada: " + producto.getCategoria());
        }
        platos.add(producto);
    }

    public void mostrarMenu() {
        // Título principal centrado
        System.out.println("\n======================================================================================");
        System.out.println("                              MENÚ DEL RESTAURANTE                              ");
        System.out.println("======================================================================================\n");

        platosPorCategoria.forEach((categoria, productos) -> {
            // Solo mostrar categorías que tienen productos
            if(!productos.isEmpty()) {
                // Encabezado de categoría
                System.out.println("[" + categoria + "]");
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.printf("%-25s %12s %15s %30s\n", "PLATO", "PRECIO", "ALÉRGENOS", "DESCRIPCIÓN");
                System.out.println("--------------------------------------------------------------------------------------");

                // Productos
                productos.forEach(p -> {
                    System.out.printf("%-25s $%9.2f %15s %30s\n",
                            p.getNombre(),
                            p.getPrecio(),
                            p.getAlergenicos() ? "SI" : "NO",
                            p.getDescripcion());
                });
                System.out.println();
            }
        });

        System.out.println("======================================================================================");


    }

    public boolean contieneProducto(Producto p) {
        for (List<Producto> productos : platosPorCategoria.values()) {
            if (productos.contains(p)) {
                return true;
            }
        }
        return false;
    }
}