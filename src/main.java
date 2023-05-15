public class main {
    public static void main(String[] args) {
        // Crear el modelo
        LibreriaModel modelo = new LibreriaModel();
    
        // Agregar algunos libros de ejemplo al modelo
        Libro libro1 = new Libro("Cien anos de soledad", "Gabriel Garcia Marquez", "Ficcion", true);
        Libro libro2 = new Libro("1984", "George Orwell", "Ficcion", true);
        Libro libro3 = new Libro("El principito", "Antoine de Saint-Exupery", "Infantil", true);
        Libro libro4 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes Saavedra", "Clasicos", true);
        Libro libro5 = new Libro("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Fantasia", true);
        Libro libro6 = new Libro("Libro6", "Profesor6", "Drama", true);
        Libro libro7 = new Libro("Libro6", "Profesor7", "Miedo", true);
        Libro libro8 = new Libro("Libro6", "Profesor8", "Fantasia", true);
        modelo.agregarLibro(libro1);
        modelo.agregarLibro(libro2);
        modelo.agregarLibro(libro3);
        modelo.agregarLibro(libro4);
        modelo.agregarLibro(libro5);
        modelo.agregarLibro(libro6);
        modelo.agregarLibro(libro7);
        modelo.agregarLibro(libro8);
    
        // Crear la vista y el controlador
        LibreriaView vista = new LibreriaView();
        LibreriaController controlador = new LibreriaController(modelo, vista);
    
        // Ejecutar el sistema de gestión de la librería
        controlador.ejecutar();
    }
    
}
