package main;
import java.util.ArrayList;
import java.util.List;

public class LibreriaModel {
    private List<Libro> libros;

    public LibreriaModel() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> buscarLibros(String categoria) {
        List<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getCategoria().equalsIgnoreCase(categoria)) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    public boolean reservarLibro(int indice) {
        if (indice >= 0 && indice < libros.size()) {
            Libro libro = libros.get(indice);
            if (libro.isDisponible()) {
                libro.setDisponible(false);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean comprarLibro(int indice) {
        if (indice >= 0 && indice < libros.size()) {
            libros.remove(indice);
            return true;
        }
        return false;
    }

    public boolean devolverLibro(Libro libro) {
        if (libro != null && !libro.isDisponible()) {
            libro.setDisponible(true);
            return true;
        }
        return false;
    }
    

    public List<Libro> obtenerTodosLosLibros() {
        return libros;
    }
}
