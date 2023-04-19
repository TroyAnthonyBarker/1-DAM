package Practica1_Colecciones.Ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ejercicio1 {

    static List<Integer> numeros = new ArrayList<>();

    static File numerosTxt = new File("Documentos/numeros.txt");
    static File numerosOrdenadosTxt = new File("Documentos/numerosOrdenados.txt");

    public static void main() {
        leerNumeros();
        write();
    }

    static void leerNumeros(){
        try {
            Scanner lector = new Scanner(numerosTxt);
            while (lector.hasNextLine()){
                numeros.add(Integer.parseInt(lector.nextLine()));
            }
            lector.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void ordenDESC(){
        numeros.sort(Collections.reverseOrder());
    }

    static void ordenASC(){
        Collections.sort(numeros);
    }

    static void write(){
        try {
            FileWriter writer = new FileWriter(numerosOrdenadosTxt);

            writer.write("Números ordenados de mayor a menor:\n");
            ordenDESC();
            escribirNumeros(writer);
            writer.write("\n------------------------------------\n");
            writer.write("Números ordenados de menor a mayor: \n");
            ordenASC();
            escribirNumeros(writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void escribirNumeros(FileWriter writer) {
        numeros.forEach(num -> {
            try {
                writer.write(num + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
