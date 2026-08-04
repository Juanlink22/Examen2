import ejercicio1.CatalogoProductos;
import ejercicio1.Producto;
import ejercicio2.RepositorioEnMemoria;
import ejercicio2.RepositorioEnMemoriaAlternativo;
import ejercicio2.Servicio;
import ejercicio3.Auto;
import ejercicio3.Camion;
import ejercicio3.Canal;
import ejercicio3.CanalConsola;
import ejercicio3.CanalCorreo;
import ejercicio3.Flota;
import ejercicio3.Vehiculo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ejecutarEjercicio1();
        System.out.println();
        ejecutarEjercicio2();
        System.out.println();
        ejecutarEjercicio3();
    }

    private static void ejecutarEjercicio1() {
        System.out.println("=== Ejercicio 1: Catalogo ordenable ===");

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Teclado", new BigDecimal("49.99"), 10));
        productos.add(new Producto("Mouse", new BigDecimal("19.99"), 0));
        productos.add(new Producto("Monitor", new BigDecimal("199.99"), 4));
        productos.add(new Producto("Audifonos", new BigDecimal("34.99"), 2));

        CatalogoProductos catalogo = new CatalogoProductos(productos);

        System.out.println("Original:");
        catalogo.imprimir();

        catalogo.ordenar();
        System.out.println("Ordenado por precio ascendente:");
        catalogo.imprimir();

        Producto sinStock = catalogo.buscarSinStock();
        System.out.println("Primer producto sin stock: " + (sinStock != null ? sinStock : "no hay"));
    }

    private static void ejecutarEjercicio2() {
        System.out.println("=== Ejercicio 2: Repositorio generico + SOLID ===");

        Servicio<String> servicioMemoria = new Servicio<>(new RepositorioEnMemoria<>());
        servicioMemoria.guardar("Uno");
        servicioMemoria.guardar("Dos");
        servicioMemoria.guardar("Tres");

        System.out.println("RepositorioEnMemoria -> cantidad: " + servicioMemoria.cantidad());
        System.out.println("RepositorioEnMemoria -> elemento 1: " + servicioMemoria.obtener(1));

        Servicio<String> servicioAlternativo = new Servicio<>(new RepositorioEnMemoriaAlternativo<>());
        servicioAlternativo.guardar("A");
        servicioAlternativo.guardar("B");

        System.out.println("Repositorio alternativo -> cantidad: " + servicioAlternativo.cantidad());
        System.out.println("Repositorio alternativo -> elemento 0: " + servicioAlternativo.obtener(0));
        System.out.println("Servicio sigue intacto aunque cambiemos la implementacion del repositorio.");
    }

    private static void ejecutarEjercicio3() {
        System.out.println("=== Ejercicio 3: Mini-sistema completo ===");

        Canal canal = new CanalConsola();
        Flota<Vehiculo> flota = new Flota<>(canal);
        flota.agregar(new Auto("Toyota", "Corolla"));
        flota.agregar(new Camion("Volvo", 12000));
        flota.agregar(new Auto("Mazda", "3"));
        flota.alertar("Alerta de mantenimiento");

        System.out.println("Vehiculos en la flota:");
        for (Vehiculo v :flota.recorrer()){
            System.out.println(" " + v.descripcion());
        }

        System.out.println("Cambiando solo la linea del canal a CanalCorreo:");
        canal = new CanalCorreo();
        Flota<Vehiculo> flotaCorreo = new Flota<>(canal);
        flotaCorreo.agregar(new Auto("Toyota", "Corolla"));
        flotaCorreo.agregar(new Camion("Volvo", 12000));
        flotaCorreo.agregar(new Auto("Mazda", "3"));
        flotaCorreo.alertar("Alerta de mantenimiento");
    }
}
