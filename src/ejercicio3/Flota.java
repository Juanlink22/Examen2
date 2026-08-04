package ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Flota<T extends Vehiculo> {
    private final List<T> vehiculos = new ArrayList<>();
    private final Canal canal;

    public Flota(Canal canal) {
        this.canal = canal;
    }

    public void agregar(T vehiculo) {
        vehiculos.add(vehiculo);
    }

    public List<T> recorrer() {
        return new ArrayList<>(vehiculos);
    }

    public void alertar(String mensajeBase) {
        StringBuilder mensaje = new StringBuilder(mensajeBase);
        mensaje.append(" | vehiculos: ");

        if (vehiculos.isEmpty()) {
            mensaje.append("sin vehiculos");
        } else {
            for (int i = 0; i < vehiculos.size(); i++) {
                if (i > 0) {
                    mensaje.append(" ; ");
                }
                mensaje.append(vehiculos.get(i).descripcion());
            }
        }

        canal.enviar(mensaje.toString());
    }
}
