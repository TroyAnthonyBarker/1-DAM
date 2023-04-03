package Ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    static Scanner sc;
    final static File numeros = new File("Documentos/numeros.txt");
    final static File personas = new File("Documentos/personas.txt");

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        try{
            leerFichero(numeros, "SalidaEnteros");
            leerFichero(personas, "SalidaCadenas");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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

    static void leerFichero(File fichero, String nombre) throws FileNotFoundException {
        List<String> contenido = new ArrayList<>();
        Scanner lector = new Scanner(fichero);

        while (lector.hasNextLine()){
            contenido.add(lector.nextLine());
        }
        lector.close();

        escribirFichero(contenido, nombre);
    }

    static void escribirFichero(List<String> contenido, String nombre){
        boolean DESC;
        FileWriter writer;

        File fichero = new File("Documentos/" + nombre + ".txt");

        try {
            DESC = sortDESC(nombre);
            writer = new FileWriter(fichero);

            if (DESC) Collections.sort(contenido, Collections.reverseOrder());
            else Collections.sort(contenido);

            contenido.forEach(str -> {
                try {
                    writer.write(str + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            writer.close();
        }catch (IOException | RuntimeException e){
            e.printStackTrace();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
