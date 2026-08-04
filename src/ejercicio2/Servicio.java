package ejercicio2;

public class Servicio<T> {
    private final Repositorio<T> repositorio;

    public Servicio(Repositorio<T> repositorio) {
        this.repositorio = repositorio;
    }

    public void guardar(T elemento) {
        repositorio.guardar(elemento);
    }

    public T obtener(int indice) {
        return repositorio.obtener(indice);
    }

    public int cantidad() {
        return repositorio.cantidad();
    }
}
