package peliculas;
import javax.swing.JOptionPane;

public class Utils {
    public static String pedirTexto(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }

    public static int pedirEntero(String mensaje, int min, int max) {
        while (true) {
            try {
                int valor = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje));
                if (valor >= min && valor <= max) return valor;
                else JOptionPane.showMessageDialog(null, "Valor fuera de rango (" + min + " , " + max + ")");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Introduce un número válido");
            }
        }
    }

    public static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
