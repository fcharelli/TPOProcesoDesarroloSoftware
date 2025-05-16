
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * 
 */
public enum Categoria {
    ENTRADA("Entradas"),
    PRINCIPAL("Platos Principales"),
    POSTRE("Postres"),
    BEBIDA("Bebidas");


    private String nombre;

    Categoria(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}