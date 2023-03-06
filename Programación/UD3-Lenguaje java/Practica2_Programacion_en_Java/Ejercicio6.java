/**
Diseña un programa Java que calcule la suma, resta, multiplicación y división de dos 
números introducidos por teclado. Incorpora también las funciones que permitan 
realizar la potencia de un número y la raíz cuadrada del otro.
Ejemplo de salida del programa para x=9, y=3:
Introducir primer número: 9
Introducir segundo número: 3
x = 9.0 y = 3.0
x + y = 12.0
x - y = 6.0
x * y = 27.0
x / y = 3.0
x ^ 2 = 81.0
√ x = 3.0
 */

 import java.util.Scanner;
 import java.lang.Math;

public class Ejercicio6 {
    public static void main(String[] args) {
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        double num1 = 0, num2 = 0, potencia = 0, raiz = 0;
        int suma = 0, resta = 0, multiplicacion = 0, division = 0;

        /**ALGORITMO */
        // Pide los datos
        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();
        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextInt();

        // Operaciones
        suma = (int) (num1 + num2);
        resta = (int) (num1 - num2);
        multiplicacion = (int) (num1 * num2);
        division = (int) (num1 / num2);
        potencia = Math.pow(num1, 2);
        raiz = Math.sqrt(num1);

        // Muestra por pantalla
        System.out.println("\nOperaciones:");
        System.out.println("\tLa suma de " + num1 + " y " + num2 + " es igual a " + suma);
        System.out.println("\tLa resta de " + num1 + " y " + num2 + " es igual a " + resta);
        System.out.println("\tLa multiplicación de " + num1 + " y " + num2 + " es igual a " + multiplicacion);
        System.out.println("\tLa división de " + num1 + " y " + num2 + " es igual a " + division);
        System.out.println("\tLa potencia de " + num1 + " es igual a " + potencia);
        System.out.println("\tLa raíz cuadrada de " + num1 + " es igual a " + raiz);

        sc.close();
    }
}
