import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {

    static Scanner scb;

    public static void main(String[] args) {
        Utilidades.sca = new Scanner(System.in);
        scb = new Scanner(System.in);
        int[][] matriz = fillMatriz(pideMatriz());

        System.out.println("La matriz:");
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("\tFila " + (i+1) + ": " + Arrays.toString(matriz[i]));
        }

        for (int i = 0; i < matriz.length; i++) {
            System.out.println("\tSuma de la fila " + (i+1) + ": " + sumaFila(matriz[i]));
        }

    }

    static int sumaFila (int[] matriz) {
        int suma = 0;
        for (int j : matriz) {
            suma += j;
        }
        return suma;
    }

    static int[][] pideMatriz() {
        System.out.print("Introduce la cantidad de columnas: ");
        int columnas = Utilidades.pideInt();
        System.out.print("Introduce la cantidad de filas: ");
        int filas = Utilidades.pideInt();

        return new int[columnas][filas];
    }

    static int[][] fillMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) ((-5) + Math.random() * (5 - (-5) + 1));
            }
        }
        return matriz;
    }

}
