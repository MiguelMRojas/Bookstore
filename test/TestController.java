import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.LibreriaController;
import main.LibreriaModel;
import main.LibreriaView;
import main.Libro;

import java.util.Collections;

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
    public void buscarLibrosPorCategoria() {
        modelo.agregarLibro(new Libro("Libro 1", "Autor 1", "Categoria 1", true));
        modelo.agregarLibro(new Libro("Libro 2", "Autor 2", "Categoria 2", true));
        modelo.agregarLibro(new Libro("Libro 3", "Autor 3", "Categoria 1", true));

        vista.simularEntradaUsuario("Categoria 1");
        controlador.buscarLibrosPorCategoria();

        Assertions.assertEquals(2, vista.obtenerLibrosMostrados().size());
    }

    @Test
    public void reservarLibro() {
        modelo.agregarLibro(new Libro("Libro 1", "Autor 1", "Categoria 1", true));

        vista.simularEntradaUsuario("0");
        controlador.reservarLibro();

        Assertions.assertFalse(modelo.obtenerTodosLosLibros().get(0).isDisponible());
    }

    @Test
    public void comprarLibro() {
        modelo.agregarLibro(new Libro("Libro 1", "Autor 1", "Categoria 1", true));

        vista.simularEntradaUsuario("0");
        controlador.comprarLibro();

        Assertions.assertTrue(modelo.obtenerTodosLosLibros().isEmpty());
    }

    @Test
    public void devolverLibro() {
        Libro libro = new Libro("Libro 1", "Autor 1", "Categoria 1", false);
        modelo.agregarLibro(libro);

        vista.simularEntradaUsuario("0");
        controlador.devolverLibro();

        Assertions.assertTrue(libro.isDisponible());
    }

    @Test
    public void mostrarTodosLosLibros() {
        modelo.agregarLibro(new Libro("Libro 1", "Autor 1", "Categoria 1", true));
        modelo.agregarLibro(new Libro("Libro 2", "Autor 2", "Categoria 2", true));

        controlador.mostrarTodosLosLibros();

        Assertions.assertEquals(2, vista.obtenerLibrosMostrados().size());
    }
}
