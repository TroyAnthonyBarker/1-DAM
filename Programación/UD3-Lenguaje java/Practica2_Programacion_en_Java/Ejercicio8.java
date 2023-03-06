/**
Realiza un programa que pida un número entre 0 y 9999 y lo muestre con las cifras 
al revés
 */

 import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        int primero = 0, segundo = 0, tercero = 0, cuarto = 0, num1 = 10000;

        /**ALGORITMO */
        //Pide los datos
        System.out.print("Introduce un número entre 0 y 9999: ");
        num1 = sc.nextInt();
        
        //Si el número no es un número entre 0 y 9999 devuelve "Número erroneo"
        if (num1 < 0 || num1 > 9999){
            System.out.println("Número erroneo");
        }

       //Comprueba que el número sea de 1 cifra y devuelve el número al reves
        else if (num1 <= 9){
            primero = num1 % 10;

            System.out.println("EL número " + num1 + " al reves es: " + primero);
        }

        //Comprueba que el número sea de 2 cifra y devuelve el número al reves
        else if (num1 <= 99){
            primero = num1 % 10;
            segundo = num1 % 100 / 10;

            System.out.println("EL número " + num1 + " al reves es: " + primero + segundo);
        }

        //Comprueba que el número sea de 3 cifra y devuelve el número al reves
        else if (num1 <= 999){
            primero = num1 % 10;
            segundo = num1 % 100 / 10;
            tercero = num1 % 1000 / 100;

            System.out.println("EL número " + num1 + " al reves es: " + primero  + segundo  + tercero);
        }

        //Comprueba que el número sea de 4 cifra y devuelve el número al reves
        else if (num1 <= 9999){
            primero = num1 % 10;
            segundo = num1 % 100 / 10;
            tercero = num1 % 1000 / 100;
            cuarto = num1 % 10000 / 1000;

            System.out.println("EL número " + num1 + " al reves es: " + primero + segundo + tercero  + cuarto);
        }

        sc.close();
    }
}
