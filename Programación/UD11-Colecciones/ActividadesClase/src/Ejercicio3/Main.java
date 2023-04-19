package Ejercicio3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        File gatosFile = new File("Documentos/Gatos.txt");
        boolean newGatos = false, DESC;
        System.out.println("¿Cuántos gatos deseas añadir?");
        try {
            int cantGatos = sc.nextInt();
            if (sc.hasNextLine()) sc.nextLine();
            List<Gato> gatos = Arrays.asList(gatos(cantGatos));
            if (gatosFile.exists()){
                newGatos = existFile(gatosFile.getName());
            }

            DESC = sortDESC(gatosFile.getName());

            if (DESC) Collections.sort(gatos, Collections.reverseOrder());
            else Collections.sort(gatos);

            escribirFichero(gatosFile, newGatos, gatos);

        } catch (InputMismatchException e) {
            System.err.println("ERROR: Introducción no válida.");
        } catch (IllegalArgumentException e) {
            System.err.println("ERROR: Color del gato no valido.");
        } catch (DateTimeParseException e) {
            System.err.println("ERROR: Fecha de nacimiento no valido.");
        } catch (IOException e){
            e.printStackTrace();
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    static void escribirFichero(File fichero, boolean sobreescribir, List<Gato> gatos){
        try {
            FileWriter writer = new FileWriter(fichero, sobreescribir);
            escribeGatos(writer, gatos);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void escribeGatos(FileWriter writer, List<Gato> gatos) {
        gatos.forEach(e -> {
            try {
                writer.write(e + "\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
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

    static boolean existFile(String name) throws Exception {
        System.out.println("El fichero " + name + " existe.");
        System.out.println("¿Deseas sobreescribir? (1. Sí 2. No)");
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

    static Gato[] gatos(int cantidad){
        Gato[] gatos = new Gato[cantidad];
        for (int i = 0; i < gatos.length; i++) {
            gatos[i] = gato();
        }
        return gatos;
    }

    static Gato gato() {
        System.out.println("Introduce los datos del gato: ");
        System.out.print("\tNombre: ");
        String nombre = sc.nextLine();
        System.out.print("\tColor: ");
        String color = sc.nextLine();
        System.out.print("\tRaza: ");
        String raza = sc.nextLine();
        System.out.print("\tFecha de nacimiento (dd/MM/yyyy): ");
        String fechanac = sc.nextLine();
        System.out.println();

        return new Gato(nombre, color, raza, fechanac);
    }
}
