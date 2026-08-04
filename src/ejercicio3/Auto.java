package ejercicio3;

public class Auto implements Vehiculo {
    private final String marca;
    private final String modelo;

    public Auto(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String descripcion() {
        return "Auto " + marca + " " + modelo;
    }
}
