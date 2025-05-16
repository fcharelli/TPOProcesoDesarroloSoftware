
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Cupon {


    private static final List<String> CODIGOS_VALIDOS = Arrays.asList(
            "SANCHEZ12", "CHARO29", "TEGLI77", "BLACKFRIDAY", "HOTSALE10"
    );

    /**
     * Default constructor
     */
    public Cupon(double descuento, String codigo) {
        this.descuento = descuento;
        this.codigo = codigo.toUpperCase();

    }

    /**
     * 
     */
    private boolean usado = false;

    /**
     * 
     */
    private String codigo;

    /**
     * 
     */
    private double descuento;

    public boolean isUsado() {
        return usado;
    }

    public void fueUsado() {
        this.usado = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getDescuento() {
        return descuento;
    }

    public boolean esValido(){
        return CODIGOS_VALIDOS.contains(codigo.toUpperCase());
    }


    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
}