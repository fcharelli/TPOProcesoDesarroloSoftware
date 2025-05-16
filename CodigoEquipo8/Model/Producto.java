import java.util.Objects;

/**
 * 
 */
public class Producto {

    protected String nombre;


    protected String Descripcion;


    protected double precio;


    protected boolean alergenicos;


    protected Categoria categoria;


    public Producto(String nombre, String descripcion, double precio, boolean alergenicos, Categoria categoria) {
        this.nombre = nombre;
        Descripcion = descripcion;
        this.precio = precio;
        this.alergenicos = alergenicos;
        this.categoria = Objects.requireNonNull(categoria, "La categoría no puede ser nula");
    }




    public String getNombre(){
        return nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean getAlergenicos() {
        return alergenicos;
    }

    public void setAlergenicos(boolean alergenicos) {
        this.alergenicos = alergenicos;
    }

    public double getPrecio(){
        return precio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

}