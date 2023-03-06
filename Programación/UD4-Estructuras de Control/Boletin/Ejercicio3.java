import java.util.Scanner;
import java.lang.Math;

/**
 Diseña e implementa el siguiente programa: (SWITCH)
• Mostrar un menú que dé a elegir entre 5 opciones posibles:
• Leer la opción seleccionada
    +, -, *, /, ^
• Se muestra el resultado por pantalla
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        int option = 0, num1 = 0, num2 = 0, resultado = 0;

        /**ALGORITMO */ 
        //Pide los datos
        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();
        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextInt();
        System.out.println("\nOpciones:");
        System.out.println("\t 1. Sumar");
        System.out.println("\t 2. Restar");
        System.out.println("\t 3. Multiplicar");
        System.out.println("\t 4. Dividir");
        System.out.println("\t 5. Potencia");
        System.out.print("Introduce la opción: ");
        option = sc.nextInt();

        //Realiza la opción introducida
        switch (option){
            case 1:
                resultado = num1 + num2;
                // Muestra por pantalla
                System.out.println("El resutlado de la suma es: " + resultado);
                break;
            case 2:
                resultado = num1 - num2;
                // Muestra por pantalla
                System.out.println("El resutlado de la resta es: " + resultado);
                break;
            case 3:
                resultado = num1 * num2;
                // Muestra por pantalla
                System.out.println("El resutlado de la multiplicación es: " + resultado);
                break;
            case 4:
                resultado = num1 / num2;
                // Muestra por pantalla
                System.out.println("El resutlado de la división es: " + resultado);
                break;
            case 5:
                resultado = (int) (Math.pow(num1, num2));
                // Muestra por pantalla
                System.out.println("El resutlado de la potencia es: " + resultado);
                break;
            default:
                System.out.println("Opción incorrecta");
        }
    sc.close();
    }
    
}
