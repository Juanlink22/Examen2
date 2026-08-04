package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class RepositorioEnMemoria<T> implements Repositorio<T> {
    private final List<T> elementos = new ArrayList<>();

    @Override
    public void guardar(T elemento) {
        elementos.add(elemento);
    }

    @Override
    public T obtener(int indice) {
        if (indice < 0 || indice >= elementos.size()){
            throw new IllegalArgumentException("Indice fuera de rango: " + indice + ", tamaño" + elementos.size());
        }
        return elementos.get(indice);
    }

    @Override
    public int cantidad() {
        return elementos.size();
    }
}
