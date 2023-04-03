package Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static Scanner sc;
    static List<Colores> colores = new ArrayList<>();
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        boolean recogerColores = true;
        Colores blanco = Colores.blanco;
        while (recogerColores) {
            try {
                introducirColores();
            } catch (IllegalArgumentException e) {
                recogerColores = false;
            }
        }
        colores.add(2, Colores.negro);
        muestraColores();

        borrarPrimero(blanco);
        colores.add(3, blanco);

        borrarPrimero(blanco);

        buscar(blanco);

        borrarPrimero(blanco);

        muestraColores();

        colores.remove(2);

        System.out.println("Iterable: ");
        colores.forEach(System.out::println);

        System.out.println("\nLambda: ");
        System.out.print(colores.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "))
        );
    }

    static void muestraColores(){
        System.out.println();
        colores.forEach(System.out::println);
        System.out.println();
    }

    static void introducirColores(){
        System.out.print("Introduce el siguiente color (solo un color): ");
        String color = sc.nextLine().toLowerCase();
        if (color.matches(".*[á].*")) color = color.replace('á', 'a');
        if (color.matches(".*[é].*")) color = color.replace('é', 'e');
        if (color.matches(".*[í].*")) color = color.replace('í', 'i');
        if (color.matches(".*[ó].*")) color = color.replace('ó', 'o');
        if (color.matches(".*[ú].*")) color = color.replace('ú', 'u');

        color = color.replace(" ", "");

        colores.add(Colores.valueOf(color));
    }

    static void borrarPrimero(Colores color){
        for (int i = 0; i < colores.size(); i++) {
            if (colores.get(i).equals(color)){
                colores.remove(i);
                break;
            }
        }
    }

    static void buscar(Colores color){
        int count = 0;
        String linea = "";
        for (int i = 0; i < colores.size(); i++) {
            if (colores.get(i).equals(color)) {
                count++;
                linea += i + " ";
            }
        }
        System.out.println("Hay " + count + " '" + color + "' en la/as linea/as " + linea);
    }
}
