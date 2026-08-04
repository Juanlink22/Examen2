package ejercicio3;

public class Camion implements Vehiculo {
    private final String marca;
    private final int capacidadKg;

    public Camion(String marca, int capacidadKg) {
        this.marca = marca;
        this.capacidadKg = capacidadKg;
    }

    @Override
    public String descripcion() {
        return "Camion " + marca + " (" + capacidadKg + " kg)";
    }

    @Override
    public String toString() {
        return descripcion();
    }
}
