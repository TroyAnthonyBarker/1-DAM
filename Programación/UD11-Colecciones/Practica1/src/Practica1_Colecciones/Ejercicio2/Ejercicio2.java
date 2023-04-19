package Practica1_Colecciones.Ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2 {

    static List<String> frases = new ArrayList<>();

    static File frasesTxt = new File("Documentos/frases.txt");
    static File frasesOrdenadosTxt = new File("Documentos/frasesOrdenados.txt");

    public static void main() {
        leerFrases();
        write();
    }


    static void leerFrases(){
        try {
            Scanner lector = new Scanner(frasesTxt);
            while (lector.hasNextLine()){
                frases.add(lector.nextLine());
            }
            lector.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void ordenar(){
        frases.sort(Comparator.comparingInt(String::length));
    }

    static void write(){
        try {
            FileWriter writer = new FileWriter(frasesOrdenadosTxt);
            ordenar();
            escribirFrases(writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void escribirFrases(FileWriter writer) {
        frases.forEach(str -> {
            try {
                writer.write(str + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
