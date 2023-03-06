import java.util.Scanner;

public class Ejercicio72 {

    static Scanner sc;
    static Persona p1, p2;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

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
        String dni, nombre, apellido;
        int edad;

        System.out.println("Introduce los datos de la persona");

        // Asigna el dni de la persona p1
        System.out.print("DNI: ");
        dni = sc.nextLine();

        // Asigna el nombre de la persona p1
        System.out.print("Nombre: ");
        nombre = sc.nextLine();

        // Asigna el apellido de la persona p1
        System.out.print("Apellido: ");
        apellido = sc.nextLine();

        // Asigna el edad de la persona p1
        System.out.print("Edad: ");
        edad = sc.nextInt();
        sc.nextLine();

        p1 = new Persona(dni, nombre, apellido, edad);
    }

    public static void segundoPersona() {
        String dni, nombre, apellido;
        int edad;

        System.out.println("Introduce los datos de la persona");

        // Asigna el dni de la persona p1
        System.out.print("DNI: ");
        dni = sc.nextLine();

        // Asigna el nombre de la persona p1
        System.out.print("Nombre: ");
        nombre = sc.nextLine();

        // Asigna el apellido de la persona p1
        System.out.print("Apellido: ");
        apellido = sc.nextLine();

        // Asigna el edad de la persona p1
        System.out.print("Edad: ");
        edad = sc.nextInt();
        sc.nextLine();

        p2 = new Persona(dni, nombre, apellido, edad);
    }
}
