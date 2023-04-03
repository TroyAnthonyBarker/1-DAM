package Ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

    }

    static boolean sortDESC(String name) throws Exception {
        System.out.println("¿Cómo quieres ordenar los datos de " + name + "? (1. Ascendiente 2. Descendiente)");
        try {
            int option = sc.nextInt();
            if (sc.hasNextLine()) sc.nextLine();
            if (option < 1 || option > 2) throw new Exception("ERROR: Opción no válida (Operación cancelada)");
            return option == 2;
        } catch (InputMismatchException e){
            if (sc.hasNextLine()) sc.nextLine();
            throw new Exception("ERROR: Se ha introducido un o varios caracteres (Operación cancelada)");
        }
    }
}
