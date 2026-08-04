package ejercicio1;

import java.util.List;

public class CatalogoProductos {
    private final List<Producto> productos;

    public CatalogoProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Producto buscarSinStock() {
        if (productos == null) {
            return null;
        }

        for (Producto producto : productos) {
            if (producto != null && producto.getStock() == 0) {
                return producto;
            }
        }

        return null;
    }

    public void imprimir() {
        if (productos == null || productos.isEmpty()) {
            System.out.println("  sin productos");
            return;
        }

        for (Producto producto : productos) {
            System.out.println("  " + producto);
        }
    }
}
