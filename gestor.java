package peliculas;
import java.util.*;


public class gestor {
    
    private List<peliculas> lista = new ArrayList<>();

    public void agregarPelicula(peliculas p) {
        lista.add(p);
    }

    public List<peliculas> getPeliculasOrdenadas() {
        lista.sort((a, b) -> b.getPuntuacion() - a.getPuntuacion());
        return lista;
    }

    public peliculas buscarPorIndice(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            return lista.get(indice);
        }
        return null;
    }

    public void eliminar(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            lista.remove(indice);
        }
    }

    public int tamaño() {
        return lista.size();
    }
}

