import java.util.Scanner;

public class Ejercicio72 {

    static Scanner sc;
    static Persona p1, p2;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        p1 = new Persona();
        p2 = new Persona();

        System.out.println("Primera persona");
        primeraPersona();

        System.out.println();

        System.out.println("Segunda persona");
        segundoPersona();

        System.out.println();

        System.out.println("La primera persona");
        p1.printPersona();

        System.out.println();

        System.out.println("La segunda persona");
        p2.printPersona();
    }

    public static void primeraPersona() {
        System.out.println("Introduce los datos de la persona");

        // Asigna el dni de la persona p1
        System.out.print("DNI: ");
        p1.setDni(sc.nextLine());

        // Asigna el nombre de la persona p1
        System.out.print("Nombre: ");
        p1.setNombre(sc.nextLine());

        // Asigna el apellido de la persona p1
        System.out.print("Apellido: ");
        p1.setApellidos(sc.nextLine());

        // Asigna el edad de la persona p1
        System.out.print("Edad: ");
        p1.setEdad(sc.nextInt());
        sc.nextLine();
    }

    public static void segundoPersona() {
        System.out.println("Introduce los datos de la persona");

        // Asigna el dni de la persona p1
        System.out.print("DNI: ");
        p2.setDni(sc.nextLine());

        // Asigna el nombre de la persona p1
        System.out.print("Nombre: ");
        p2.setNombre(sc.nextLine());

        // Asigna el apellido de la persona p1
        System.out.print("Apellido: ");
        p2.setApellidos(sc.nextLine());

        // Asigna el edad de la persona p1
        System.out.print("Edad: ");
        p2.setEdad(sc.nextInt());
        sc.nextLine();
    }
}
