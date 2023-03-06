/**
Diseña e implementa el siguiente programa:
1) Introducir una nota
2) Leer la nota
3) Mostrar información acerca de los valores posibles de notas (0 – 10)
a) Si es mayor o igual que 9 o igual a 10 la nota es “Excelente“
b) Entre 6.5 (incluido) y 9, la nota es “Notable“
c) Entre 5 (incluido) y 6.5 la nota es “Aprobado“
d) En cualquier otro caso “Suspendido“
*/

 import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        Double nota = 0.0;
        
        /**ALGORITMO */
        //Pide los datos
        System.out.print("Introduce una nota entre 0 y 10: ");
        nota = sc.nextDouble();

        //Entre 5 (incluido) y 6.5 la nota es “Aprobado“
        if (nota >= 5 && nota < 6.5){
            System.out.println("Aprobado");
        } 
        // Entre 6.5 (incluido) y 9, la nota es “Notable“
        else if (nota >= 6.5 && nota < 9){
            System.out.println("Notable");
        } 
        // Si es mayor o igual que 9 o igual a 10 la nota es “Excelente“
        else if (nota >= 9 && nota <= 10){
            System.out.println("Excelente");
        } 
        // En cualquier otro caso “Suspendido“
        else {
            System.out.println("Suspenso");
        }
        sc.close();
    }
    
}
