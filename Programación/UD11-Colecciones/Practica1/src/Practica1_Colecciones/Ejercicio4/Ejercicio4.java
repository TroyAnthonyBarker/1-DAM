package Practica1_Colecciones.Ejercicio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Ejercicio4 {

    static File colores = new File("Documentos/colores.txt");
    static List<HashSet<String>> hashSets = new ArrayList<>();

    public static void main() {
        leerColores();
        compare(0, 1);
        compare(1, 2);
        System.out.println();
        convertHashSetToList(0);
        notEquals(0, 1);
    }

    static void leerColores(){
        int count = 0;
        hashSets.add(new HashSet<>());
        try {
            Scanner lector = new Scanner(colores);
            while (lector.hasNextLine()){
                String linea = lector.nextLine();
                if (linea.contains("-")) {
                    count++;
                    hashSets.add(new HashSet<>());
                } else {
                    hashSets.get(count).add(linea);
                }
            }
            lector.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void compare(int obj1, int obj2){
        if (hashSets.get(obj1).equals(hashSets.get(obj2))) System.out.println("La lista " + (obj1+1) + " es igual que la lista " + (obj2+1));
        else System.out.println("La lista " + (obj1+1) + " no es igual que la lista " + (obj2+1));
    }

    static List<String> convertHashSetToList(int obj){
        List<String> lista = new ArrayList<>(hashSets.get(obj));
        hashSets.remove(obj);
        return lista;
    }

    static void notEquals(int obj1, int obj2){
        HashSet<String> notEquals1 = new HashSet<>(hashSets.get(obj1));
        HashSet<String> notEquals2 = new HashSet<>(hashSets.get(obj2));
        notEquals1.removeAll(hashSets.get(obj2));
        notEquals2.removeAll(hashSets.get(obj1));
        HashSet<String> notEquals = new HashSet<>(notEquals1);
        notEquals.addAll(notEquals2);
        System.out.println("Distintos colores entre " + obj1 + " y " + obj2);
        System.out.println(notEquals);
    }

}
