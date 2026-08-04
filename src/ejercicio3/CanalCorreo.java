package ejercicio3;

public class CanalCorreo implements Canal {
    @Override
    public void enviar(String mensaje) {
        System.out.println("[CORREO] " + mensaje);
    }
}
