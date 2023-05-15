package main;
import java.util.List;
import java.util.Scanner;

public class LibreriaView {
    private Scanner scanner;

    public LibreriaView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("------ Libros para Todos ------");
        System.out.println("1. Buscar libros por categoría");
        System.out.println("2. Reservar un libro");
        System.out.println("3. Comprar un libro");
        System.out.println("4. Devolver un libro");
        System.out.println("5. Mostrar todos los libros disponibles");
        System.out.println("0. Salir");
        System.out.println("--------------------------------");
    }

    public String solicitarCategoria() {
        System.out.print("Ingrese la categoría del libro: ");
        return scanner.nextLine();
    }

    public int solicitarIndice(String mensaje) {
        System.out.print(mensaje + ": ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarLibros(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros.");
        } else {
            System.out.println("------ Resultados de búsqueda ------");
            for (int i = 0; i < libros.size(); i++) {
                Libro libro = libros.get(i);
                System.out.println("Índice: " + i);
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println("Categoría: " + libro.getCategoria());
                System.out.println("Disponibilidad: " + (libro.isDisponible() ? "Disponible" : "No disponible"));
                System.out.println("-----------------------------------");
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
