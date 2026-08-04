package ejercicio2;

public interface Repositorio<T> {
    void guardar(T elemento);

    T obtener(int indice);

    int cantidad();
}
