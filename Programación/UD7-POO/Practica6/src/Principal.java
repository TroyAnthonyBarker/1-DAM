import java.util.Scanner;

public class Principal {

    static Scanner sc;
    static final Libro[] library = new Libro[10];

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Utilidades.scx = new Scanner(System.in);
        int option = 0;

        do {
            option = menu();
            System.out.println();
            menuAccion(option);
            System.out.println();
        } while (option != 0);
    }

    public static int menu() {
        Utilidades.delay(300);
        System.out.print("""
                Opción:
                    1- Añadir un libro
                    2- Visualizar Biblioteca
                    3- Modificar Título
                    4- Modificar Autor
                    5- Modificar ISBN
                    0- Salir
                """);
        return Utilidades.pideInt("Introduce una opción: ");
    }

    public static void menuAccion(int opcion) {
        switch (opcion) {
            case 0 -> {
                System.out.println("Adíos!");
            }
            case 1 -> {
                addBook();
            }
            case 2 -> {
                getLibrary();
            }
            case 3 -> {
                changeTitle();
            }
            case 4 -> {
                changeAuthor();
            }
            case 5 -> {
                changeISBN();
            }
            default -> {
                System.out.println("Número introducido no es una opción valida");
            }
        }
    }

    public static void addBook() {
        for (int i = 0; i < library.length; i++) {
            if (library[i] == null) {
                library[i] = new Libro(pideTitulo(), pideAutor(), pideISBN());
                break;
            } else if (i == library.length - 1 && library[library.length - 1] != null) {
                System.err.println("No se pueden añadir más libros (Fallo al añadir libro)");
            }
        }
    }

    static String pideTitulo() {
        System.out.print("Introduce el título del libro: ");
        String titulo = sc.nextLine();
        return titulo;
    }

    static String pideAutor() {
        System.out.print("Introduce el autor del libro: ");
        String autor = sc.nextLine();
        return autor;
    }

    static String pideISBN() {
        System.out.print("Introduce el ISBN del libro: ");
        String isbn = sc.nextLine();
        return isbn;
    }

    public static void getLibrary() {
        if (library[0] == null) {
            System.err.println("No hay libros registrados");
        } else {
            for (int i = 0; i < library.length; i++) {
                if (library[i] != null) {
                    System.out.println("\t" + String.format("%02d", (i + 1)) + "- " + library[i].getInfo());
                }
            }
        }
    }

    public static void changeTitle() {
        int opcion;
        String titulo;

        // Muestra los libro que hay en la biblioteca
        getLibrary();
        System.out.println();
        opcion = Utilidades.pideIntMinMax(1, library.length - 1, "Elige el libro que desea modificar: ") - 1;

        // Comprueba si el libro elegido está registrado
        if (library[opcion] == null) {
            System.err.println("Libro no existe, añada el libro");
        } else {
            library[opcion].setTitulo(pideTitulo());
        }
    }

    public static void changeAuthor() {
        int opcion;
        String autor;

        // Muestra los libro que hay en la biblioteca
        getLibrary();
        System.out.println();
        opcion = Utilidades.pideIntMinMax(1, library.length - 1, "Elige el libro que desea modificar: ") - 1;

        // Comprueba si el libro elegido está registrado
        if (library[opcion] == null) {
            System.err.println("Libro no existe, añada el libro");
        } else {
            library[opcion].setAutor(pideAutor());
        }
    }

    public static void changeISBN() {
        int opcion;
        String isbn;

        // Muestra los libro que hay en la biblioteca
        getLibrary();
        System.out.println();
        opcion = Utilidades.pideIntMinMax(1, library.length - 1, "Elige el libro que desea modificar: ") - 1;

        // Comprueba si el libro elegido está registrado
        if (library[opcion] == null) {
            System.err.println("Libro no existe, añada el libro");
        } else {
            library[opcion].setISBN(pideISBN());
        }
    }
}
