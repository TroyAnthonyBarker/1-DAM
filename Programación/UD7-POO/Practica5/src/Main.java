import java.util.Scanner;

public class Main {

    static Scanner sc;

    public static int menu() {
        System.out.println("Elige una opción (0 para salir)");
        System.out.println("\t1- Ver Información del Libro (se imprime por pantalla la info del libro)");
        System.out.println("\t2- Modificar Título");
        System.out.println("\t3- Modificar Autor");
        System.out.println("\t4- Modificar ISBN");
        return Utilidades.PideInt("Introduce una opción: ");
    }

    public static void menuAccion(int opcion, Libro lib) {
        switch (opcion) {
            case 0:
                System.out.println("Adíos!");
                break;
            case 1:
                System.out.println(lib.getInfo());
                break;
            case 2:
                System.out.print("Introduce el Título del libro: ");
                lib.setTitulo(sc.nextLine());
                break;
            case 3:
                System.out.print("Introduce el Autor del libro: ");
                lib.setAutor(sc.nextLine());
                break;
            case 4:
                System.out.print("Introduce el ISBN del libro: ");
                lib.setISBN(sc.nextLine());
                break;
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Utilidades.scx = new Scanner(System.in);
        Libro lib1 = new Libro("Harry Potter", "J. K. Rowling", "9788498382662");
        int option = 0;
        do {
            option = menu();
            System.out.println();
            menuAccion(option, lib1);
            System.out.println();
        } while (option != 0);
    }
}
