package Practica1_Introduccion_a_Java;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        int lado = 0, area = 0;

        /**ALGORITMO */
        System.out.print("Introduce el lado del cuadrado: ");
        lado = sc.nextInt();
        area = lado * lado;
        System.out.println("El área del cuadrado cuyo lado sea igual a " + lado + " es: " + area);
        sc.close();
    }
    
}
