import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        int numero1 = 0, num2 = 0, num3 = 0;

        /**ALGORITMO */
        System.out.println("Introduce el primer número");
        numero1= sc.nextInt();
        System.out.println("Introduce el segundo número");
        num2= sc.nextInt();
        System.out.println("Introduce el tercer número");
        num3= sc.nextInt();

        /** El primer número es el mayor */
        if (numero1 >= num2 && numero1 >= num3) {
            if (num2 > num3) {
                System.out.println(numero1 + " > " + num2 + " > " + num3);
            } else {
                System.out.println(numero1 + " > " + num3 + " > " + num2);
            } 
        }
        /** El segundo número es el mayor */
        else if (num2 >= numero1 && num2 >= num3) { 
            if (numero1 > num3) {
                System.out.println(num2 + " > " + numero1 + " > " + num3);
            } else {
                System.out.println(num2 + " > " + num3 + " > " + numero1);
            } 
        }
        /** El tercer número es el mayor */
        else if (num3 >= num2 && num3 >= numero1) {
            if (num2 > numero1) {
                System.out.println(num3 + " > " + num2 + " > " + numero1);
            } else {
                System.out.println(num3 + " > " + numero1 + " > " + num2);
            } 
        }
 

        sc.close();
    }
}