/**
Escribe un programa que lea un valor correspondiente a una distancia en millas
marinas y escriba la distancia en metros. Sabiendo que una milla marina equivale a
1.852 metros
 */

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
       /**DATOS */ 
       Scanner sc = new Scanner(System.in);
       int distanciaMillas = 0, distanciaMetros = 0;

       /**ALGORITMO */
       //Pide los datos
       System.out.print("Introduce la distancia que dea convertir de millas a metros: ");
       distanciaMillas = sc.nextInt();

       //Operaciones
       distanciaMetros = distanciaMillas * 1852;

       //Muestra por pantalla
       System.out.println(distanciaMillas + " millas son " + distanciaMetros + " en metros");
       
       sc.close();
    }
}
