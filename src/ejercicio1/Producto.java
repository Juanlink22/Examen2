

package ejercicio1;

import java.math.BigDecimal;

public class Producto implements Comparable<Producto> {
    private final String nombre;
    private final BigDecimal precio;
    private final int stock;

    public Producto(String nombre, BigDecimal precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public int compareTo(Producto otro) {
        return this.precio.compareTo(otro.precio);
    }

    @Override
    public String toString() {
        return nombre + " | precio=" + precio + " | stock=" + stock;
    }
}
