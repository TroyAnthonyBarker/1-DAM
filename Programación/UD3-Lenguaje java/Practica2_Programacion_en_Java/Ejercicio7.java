/**
Diseña un programa Java para leer las longitudes de los lados de un triángulo (L1, 
L2, L3) y calcular el área del mismo de acuerdo con la siguiente fórmula:
 */

 import java.util.Scanner;
 import java.lang.Math;

public class Ejercicio7 {
    public static void main(String[] args) {
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        double L1 = 0, L2 = 0, L3 = 0, SP = 0, area = 0;

        /**ALGORITMO */
        // Pide los datos
        System.out.print("Introduce el primer lado del triangulo: ");
        L1 = sc.nextDouble();
        System.out.print("Introduce el segundo lado del triangulo: ");
        L2 = sc.nextDouble();
        System.out.print("Introduce el tercer lado del triangulo: ");
        L3 = sc.nextDouble();

        //Operaciones
        SP = (L1 + L2 + L3)/2;
        area = Math.sqrt(SP * (SP - L1) * (SP - L2) * (SP - L3));

        //Mostrar por pantalla
        System.out.println("El área del triángulo es: " + area);

        sc.close();
    }
}
