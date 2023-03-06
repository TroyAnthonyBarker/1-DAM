package Practica1_Introduccion_a_Java;

import java.util.Scanner;
import java.lang.Math;

public class Ejercicio6 {
    public static void main(String[] args) {
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        double radio = 0, area = 0;
        /**ALGORITMO */
        System.out.print("Introduce la radio: ");
        radio = sc.nextInt();
        area = Math.PI * Math.pow(radio, 2);
        System.out.println("El área de una circunferencia cuyo radio sea " + radio + " es: " + String.format("%.2f", area));
        sc.close();
    }
}
