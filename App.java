import peliculas.gestor;
import peliculas.peliculas;
import javax.swing.JOptionPane;
import peliculas.Utils;

public class App {

    public static void main(String[] args) throws Exception {
        gestor gestor = new gestor();
        gestor.agregarPelicula(new peliculas(titulo, director, anio, puntuacion));
        String opcion;

        do {
            opcion = JOptionPane.showInputDialog(
            "Elige una opción:" +
            "1. Añadir película" +
            "2. Editar película" +
            "3. Mostrar películas" +
            "4. Eliminar película" +
            "Q. Salir"
            );

            if (opcion == null) {
                continue;
            }

            switch (opcion.toLowerCase()) {
                case "1" ->
                    añadir(gestor);
                case "2" ->
                    editar(gestor);
                case "3" ->
                    mostrar(gestor);
                case "4" ->
                    eliminar(gestor);
                case "q" ->
                    System.exit(0);
                default ->
                    Utils.mostrarMensaje("Opción no válida");
            }
        } while (true);
    }

    private static void añadir(gestor gestor) {
        String titulo = Utils.pedirTexto("Título:");
        String director = Utils.pedirTexto("Director:");
        int anio = Utils.pedirEntero("Año de estreno:", 1900, 2100);
        int puntuacion = Utils.pedirEntero("Puntuación (1-5):", 1, 5);
        gestor.agregarPelicula(new peliculas(titulo, director, anio, puntuacion));
    }

    private static void mostrar(gestor gestor) {
        StringBuilder sb = new StringBuilder(" Ranking de películas:");
        int i = 0;
        for (peliculas p : gestor.getPeliculasOrdenadas()) {
            sb.append(i++).append(" - ").append(p).append("");
        }
        Utils.mostrarMensaje(sb.toString());
    }

    private static void editar(gestor gestor) {
        if (gestor.tamaño() == 0) {
            Utils.mostrarMensaje("No hay películas para editar.");
            return;
        }
        mostrar(gestor);
        int index = Utils.pedirEntero("Introduce el número de la película a editar:", 0, gestor.tamaño() - 1);
        peliculas p = gestor.buscarPorIndice(index);
        if (p != null) {
            p.setTitulo(Utils.pedirTexto("Nuevo título (" + p.getTitulo() + "):"));
            p.setDirector(Utils.pedirTexto("Nuevo director (" + p.getDirector() + "):"));
            p.setAnio(Utils.pedirEntero("Nuevo año (" + p.getAnio() + "):", 1900, 2100));
            p.setPuntuacion(Utils.pedirEntero("Nueva puntuación (1-5):", 1, 5));
        }
    }

    private static void eliminar(gestor gestor) {
        if (gestor.tamaño() == 0) {
            Utils.mostrarMensaje("No hay películas para eliminar.");
            return;
        }
        mostrar(gestor);
        int index = Utils.pedirEntero("Introduce el número de la película a eliminar:", 0, gestor.tamaño() - 1);
        gestor.eliminar(index);
        Utils.mostrarMensaje("Película eliminada.");
    }
}
