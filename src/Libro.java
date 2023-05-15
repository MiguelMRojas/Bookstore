
public class Libro {
    private String titulo;
    private String autor;
    private String categoria;
    private boolean disponibilidad;

    public Libro(String titulo, String autor, String categoria, boolean disponibilidad) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.disponibilidad = disponibilidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isDisponible() {
        return disponibilidad;
    }

    public void setDisponible(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
