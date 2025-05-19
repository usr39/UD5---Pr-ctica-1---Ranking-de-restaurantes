package peliculas;


public class peliculas {
    private String titulo;
    private String director;
    private int anio;
    private int puntuacion; 

    public peliculas(String titulo, String director, int anio, int puntuacion) {
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
        this.puntuacion = puntuacion;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }

    @Override
    public String toString() {
        return " Titulo: " + titulo + " Director: " + director + " Año: " + anio + " Puntuación " + puntuacion;
    }
}

