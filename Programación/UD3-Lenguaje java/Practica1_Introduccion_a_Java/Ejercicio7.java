package Practica1_Introduccion_a_Java;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        int num1 = 0, num2 = 0, suma = 0, resta = 0, producto = 0, division = 0;

        /**ALGORITMO */
        /**Lee dos números */
        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();
        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextInt();

        /**Hace las operaciones */
        suma = num1 + num2;
        resta = num1 - num2;
        producto = num1 * num2;
        division = num1 / num2;

        /**Muestra los resultados */
        System.out.println(num1 + " + " + num2 + " = " + suma);
        System.out.println(num1 + " - " + num2 + " = " + resta);
        System.out.println(num1 + " * " + num2 + " = " + producto);
        System.out.println(num1 + " / " + num2 + " = " + division);

        sc.close();
    }
}
