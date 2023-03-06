package Practica1_Introduccion_a_Java;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        String name;

        /**ALGORITMO */
        System.out.print("Introduce tu nombre: ");
        name= sc.next();
        System.out.println("Bienvenido " + name);
        sc.close();
    }
}
