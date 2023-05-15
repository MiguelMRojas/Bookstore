import java.util.List;

public class LibreriaController {
    private LibreriaModel modelo;
    private LibreriaView vista;

    public LibreriaController(LibreriaModel modelo, LibreriaView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void ejecutar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarIndice("Ingrese una opción");
            switch (opcion) {
                case 1:
                    buscarLibrosPorCategoria();
                    break;
                case 2:
                    reservarLibro();
                    break;
                case 3:
                    comprarLibro();
                    break;
                case 4:
                    devolverLibro();
                    break;
                case 5:
                    mostrarTodosLosLibros();
                    break;
                case 0:
                    vista.mostrarMensaje("¡Hasta luego!");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }
    

    private void buscarLibrosPorCategoria() {
        String categoria = vista.solicitarCategoria();
        List<Libro> librosEncontrados = modelo.buscarLibros(categoria);
        vista.mostrarLibros(librosEncontrados);
    }

    private void reservarLibro() {
        int indice = vista.solicitarIndice("Ingrese el índice del libro a reservar");
        boolean reservado = modelo.reservarLibro(indice);
        if (reservado) {
            vista.mostrarMensaje("Libro reservado exitosamente.");
        } else {
            vista.mostrarMensaje("No se pudo reservar el libro. Verifique la disponibilidad o el índice ingresado.");
        }
    }

    private void comprarLibro() {
        int indice = vista.solicitarIndice("Ingrese el índice del libro a comprar");
        boolean comprado = modelo.comprarLibro(indice);
        if (comprado) {
            vista.mostrarMensaje("Libro comprado exitosamente.");
        } else {
            vista.mostrarMensaje("No se pudo comprar el libro. Verifique el índice ingresado.");
        }
    }

    private void devolverLibro() {
        List<Libro> libros = modelo.obtenerTodosLosLibros();
        if (libros.isEmpty()) {
            vista.mostrarMensaje("No hay libros disponibles para devolver.");
            return;
        }
        
        vista.mostrarLibros(libros);
        int indice = vista.solicitarIndice("Ingrese el índice del libro a devolver");
        if (indice >= 0 && indice < libros.size()) {
            Libro libro = libros.get(indice);
            boolean devuelto = modelo.devolverLibro(libro);
            if (devuelto) {
                vista.mostrarMensaje("Libro devuelto exitosamente.");
            } else {
                vista.mostrarMensaje("No se pudo devolver el libro. Verifique el índice ingresado.");
            }
        } else {
            vista.mostrarMensaje("Índice inválido. Verifique el índice ingresado.");
        }
    }
    
    private void mostrarTodosLosLibros() {
        List<Libro> libros = modelo.obtenerTodosLosLibros();
        vista.mostrarLibros(libros);
    }
    
    
}
