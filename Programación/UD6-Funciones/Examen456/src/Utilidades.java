import java.util.Scanner;

public class Utilidades {

    static Scanner sca;

    public static void checkDouble() {
        while (!sca.hasNextDouble()) {
            System.out.println("Número inválido, vuelve a introducir");
            sca.nextLine();
        }
    }

    public static double pideDouble() {
        checkDouble();
        return sca.nextDouble();
    }

    public static void checkInt() {
        while (!sca.hasNextInt()) {
            System.out.println("Número inválido, vuelve a introducir");
            sca.nextLine();
        }
    }

    public static int pideInt() {
        checkInt();
        return sca.nextInt();
    }

    public static String checkDNI(String dni) {
        while (dni.length() != 9 && dni.substring(0, 8).matches(".*[0-9].*")) {
            System.out.println("DNI no valido, vuelve a introducir (Si es NIE cambie la primera letra por 0)");
            dni = sca.nextLine();
        }
        return dni;
    }

    static String pideDNI() {
        System.out.println("Introduce tu DNI");
        return checkDNI(sca.nextLine());
    }

    static int pideCantidad() {
        System.out.println("Introduce la cantidad de productos comprados");
        return Utilidades.pideInt();
    }

    static String userName(String fullName) {
        String[] fullNameSplit;
        fullNameSplit = fullName.split(" ");
        return fullNameSplit[0];
    }

    static String userSurname1(String fullName) {
        String[] fullNameSplit;
        fullNameSplit = fullName.split(" ");
        if (fullName.length() >= 2) {
            return fullNameSplit[1];
        } else {
            return "";
        }
    }

    static String userSurname2(String fullName) {
        String[] fullNameSplit;
        fullNameSplit = fullName.split(" ");
        if (fullName.length() > 4) {
            return fullNameSplit[2];
        } else {
            return "";
        }
    }

    static double[] preciosProductos(int cantidad) {
        double[] precios = new double[cantidad];
        for (int i = 0; i < precios.length; i++) {
            System.out.print("Introduce el precio del " + (i+1) + "º producto: ");
            precios[i] = Utilidades.pideDouble();
        }
        return precios;
    }

    static int numDNI(String dni) {
        String numDNIString = dni.substring(0, 8);
        return Integer.parseInt(numDNIString);
    }

    static String pideNombre() {
        String nombre;
        System.out.println("Introduce tu nombre completo (nombre apellido apellido)");
        nombre = sca.nextLine();
        while (nombre.equals("")) {
            System.out.println("Nombre no introducido, introduce tu nombre completo");
            nombre = sca.nextLine();
        }
        return nombre;
    }

    static void muestraArrayDoublePrice(double[] array) {
        for (double v : array) {
            System.out.println("\t" + String.format("%.2f", v) + "€");
        }
    }
}
