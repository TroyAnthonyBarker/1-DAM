/**
 Realiza el diseño y la posterior implementación en Java del siguiente programa
“Adivina el número“
a) El número secreto será el 241
b) Pedir un número por teclado
c) Leer el número
d) Comprobar si el número introducido es igual al número secreto
1) Si es igual, se informa del acierto
2) Si no es igual, se informa de que se ha fallado
 */

 import java.util.Scanner;

 public class Ejercicio1{
    public static void main(String[] args) {
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        int secret = 241, acierto = 0;

        /**ALGORITMO */
        // Piede los datos
        System.out.print("Introduce un número: ");
        acierto = sc.nextInt();

        // Comprueba si el número introducido es el mismo que el número secreto
        if (secret == acierto){
            System.out.println("En hora buena has acertado el número secreto.");
        } else {
            System.out.println("No has acertado el número secreto");
        }
        sc.close();
    }
 }