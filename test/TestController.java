package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.LibreriaController;
import main.LibreriaModel;
import main.LibreriaView;
import main.Libro;

import java.util.ArrayList;
import java.util.List;

public class TestController {
    private LibreriaModel modelo;
    private LibreriaView vista;
    private LibreriaController controlador;

    @BeforeEach
    public void setUp() {
        modelo = new LibreriaModel();
        vista = new LibreriaView();
        controlador = new LibreriaController(modelo, vista);
    }

    @Test
    public void testBuscarLibrosPorCategoria() {
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel Garcia Marquez", "Ficcion", true);
        Libro libro2 = new Libro("1984", "George Orwell", "Ficcion", true);
        Libro libro3 = new Libro("El principito", "Antoine de Saint-Exupery", "Infantil", true);

        modelo.agregarLibro(libro1);
        modelo.agregarLibro(libro2);
        modelo.agregarLibro(libro3);

        vista.setCategoriaIngresada("Ficcion");

        controlador.buscarLibrosPorCategoria();

        List<Libro> librosEncontrados = vista.getLibrosMostrados();
        Assertions.assertEquals(2, librosEncontrados.size());
        Assertions.assertTrue(librosEncontrados.contains(libro1));
        Assertions.assertTrue(librosEncontrados.contains(libro2));
    }

    @Test
    public void testReservarLibro() {
        Libro libro = new Libro("Cien años de soledad", "Gabriel Garcia Marquez", "Ficcion", true);
        modelo.agregarLibro(libro);

        vista.setIndiceIngresado(0);

        controlador.reservarLibro();

        Assertions.assertFalse(libro.isDisponible());
        Assertions.assertEquals("Libro reservado exitosamente.", vista.getMensajeMostrado());
    }

    @Test
    public void testComprarLibro() {
        Libro libro = new Libro("Cien años de soledad", "Gabriel Garcia Marquez", "Ficcion", true);
        modelo.agregarLibro(libro);

        vista.setIndiceIngresado(0);

        controlador.comprarLibro();

        List<Libro> librosEncontrados = modelo.buscarLibros("Ficcion");
        Assertions.assertTrue(librosEncontrados.isEmpty());
        Assertions.assertEquals("Libro comprado exitosamente.", vista.getMensajeMostrado());
    }

    @Test
    public void testDevolverLibro() {
        Libro libro = new Libro("Cien años de soledad", "Gabriel Garcia Marquez", "Ficcion", false);
        modelo.agregarLibro(libro);

        List<Libro> libros = new ArrayList<>();
        libros.add(libro);
        vista.setLibrosMostrados(libros);
        vista.setIndiceIngresado(0);

        controlador.devolverLibro();

        Assertions.assertTrue(libro.isDisponible());
        Assertions.assertEquals("Libro devuelto exitosamente.", vista.getMensajeMostrado());
    }

    @Test
    public void testMostrarTodosLosLibros() {
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel Garcia Marquez", "Ficcion", true);
        Libro libro2 = new Libro("1984", "George Orwell", "Ficcion", true);
        modelo.agregarLibro(libro1);
        modelo.agregarLibro(libro2);
        controlador.mostrarTodosLosLibros();

        List<Libro> librosMostrados = vista.getLibrosMostrados();
        Assertions.assertEquals(2, librosMostrados.size());
        Assertions.assertTrue(librosMostrados.contains(libro1));
        Assertions.assertTrue(librosMostrados.contains(libro2));
    }
}    

