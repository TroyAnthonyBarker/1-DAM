import java.util.Scanner;

/**
 * Ejercicio2
 */
public class Ejercicio2 {
    public static void main (String[] args){
        /** Datos */
        Scanner dato = new Scanner(System.in);
        int num1;
        int num2;
        int num3;

        /**Algoritmo */
        System.out.println("Introduce el primer número que desea sumar");
        num1= dato.nextInt();
        System.out.println("Introduce el segundo número que desea sumar");
        num2= dato.nextInt();

        num3= num1 + num2;

        System.out.println("La operacion " + num1 + " + " + num2 + " = " + num3);
    
        dato.close();
    }
}
