package Practica1_Colecciones.Ejercicio5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Ejercicio5 {

    static File libro = new File("Documentos/Libros");

    public static void main() {
        File[] ficherosLibros = libro.listFiles();
        assert ficherosLibros != null;
        for (File f : ficherosLibros) leer(f);
    }

    static void leer(File fichero) {
        int numLineas=0, numPalabras=0, numCaracteres=0;
        Hashtable<String, Integer> cuentaPalabras = new Hashtable<>();
        try {
            Scanner lector = new Scanner(fichero);
            while (lector.hasNextLine()) {
                String line = lector.nextLine();
                String[] palabras = line.split("\\s");
                numLineas++;
                numPalabras += palabras.length;
                numCaracteres += line.length();
                for (String palabra : palabras) cuentaPalabras.merge(palabra, 1, Integer::sum);
            }
            show(numLineas, numPalabras, numCaracteres, cuentaPalabras, fichero);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void show(int numLineas, int numPalabras, int numCaracteres, Hashtable<String, Integer> cuentaPalabras, File fichero){
        List<Map.Entry<String, Integer>> palabras = new ArrayList<>(cuentaPalabras.entrySet());
        palabras.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        System.out.println(fichero.getName());
        System.out.println("-------------------------------");
        System.out.println("Lineas: " + numLineas + "\nPalabras: " + numPalabras + "\nCaracteres: " + numCaracteres + "\nPalabras más comunes:");
        for (int i = 0; i < 10; i++) {
            assert palabras.get(i) != null;
            System.out.println("\t" + palabras.get(i));
        }
        System.out.println("-------------------------------");
        System.out.println();
    }
}
