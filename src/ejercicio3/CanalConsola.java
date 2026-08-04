package ejercicio3;

public class CanalConsola implements Canal {
    @Override
    public void enviar(String mensaje) {
        System.out.println("[CONSOLA] " + mensaje);
    }
}
