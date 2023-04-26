package Practica1_Colecciones.Ejercicio1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            BufferedReader lc = new BufferedReader(new FileReader(numerosTxt));
            String line = "";
            while ((line = lc.readLine()) != null){
                numeros.add(Integer.parseInt(line));
            }
            lc.close();
        } catch (IOException e) {
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
            BufferedWriter writer = new BufferedWriter(new FileWriter(numerosOrdenadosTxt));

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

    static void escribirNumeros(BufferedWriter writer) {
        numeros.forEach(num -> {
            try {
                writer.write(num + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
