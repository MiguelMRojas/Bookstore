package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import main.LibreriaModel;
import main.Libro;

public class TestModel {
    private LibreriaModel modelo;

    @BeforeEach
    public void setUp() {
        modelo = new LibreriaModel();
    }

    @Test
    public void testAgregarLibro() {
        Libro libro = new Libro("Cien años de soledad", "Gabriel Garcia Marquez", "Ficcion", true);
        modelo.agregarLibro(libro);

        List<Libro> librosEncontrados = modelo.buscarLibros("Ficcion");
        Assertions.assertEquals(1, librosEncontrados.size());
        Assertions.assertEquals(libro, librosEncontrados.get(0));
    }

    @Test
    public void testBuscarLibrosPorCategoria() {
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel Garcia Marquez", "Ficcion", true);
        Libro libro2 = new Libro("1984", "George Orwell", "Ficcion", true);
        Libro libro3 = new Libro("El principito", "Antoine de Saint-Exupery", "Infantil", true);

        modelo.agregarLibro(libro1);
        modelo.agregarLibro(libro2);
        modelo.agregarLibro(libro3);

        List<Libro> librosEncontrados = modelo.buscarLibros("Ficcion");
        Assertions.assertEquals(2, librosEncontrados.size());
        Assertions.assertTrue(librosEncontrados.contains(libro1));
        Assertions.assertTrue(librosEncontrados.contains(libro2));
    }

    @Test
    public void testReservarLibro() {
        Libro libro = new Libro("Cien años de soledad", "Gabriel Garcia Marquez", "Ficcion", true);
        modelo.agregarLibro(libro);

        boolean reservado = modelo.reservarLibro(0);
        Assertions.assertTrue(reservado);
        Assertions.assertFalse(libro.isDisponible());
    }

    @Test
    public void testComprarLibro() {
        Libro libro = new Libro("Cien años de soledad", "Gabriel Garcia Marquez", "Ficcion", true);
        modelo.agregarLibro(libro);

        boolean comprado = modelo.comprarLibro(0);
        Assertions.assertTrue(comprado);
        List<Libro> librosEncontrados = modelo.buscarLibros("Ficcion");
        Assertions.assertTrue(librosEncontrados.isEmpty());
    }

    @Test
    public void testDevolverLibro() {
        Libro libro = new Libro("Cien años de soledad", "Gabriel Garcia Marquez", "Ficcion", false);
        modelo.agregarLibro(libro);

        boolean devuelto = modelo.devolverLibro(libro);
        Assertions.assertTrue(devuelto);
        Assertions.assertTrue(libro.isDisponible());
    }
}

