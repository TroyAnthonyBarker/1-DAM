/**
Diseña un programa Java para resolver una ecuación de primer grado con una 
incógnita (x), suponiendo que los coeficientes de la ecuación (C1 y C2) se introducen 
desde teclado.
• C1x + C2 = 0
 */

 import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        float C1 = 0, C2 = 0, x = 0;

        /**ALGORITMO */
        //Pide los datos
        System.out.print("Introduce el primer coeficiente: ");
        C1 = sc.nextFloat();
        System.out.print("Introduce el segundo coeficiente: ");
        C2 = sc.nextFloat();

        //Operaciones
        x = 0 - C2/C1;

        //Muestra por pantalla
        System.out.println("El resultado de " + C1 + "x + " + C2 + " = 0 es: " + x);

        sc.close();
    }
}
