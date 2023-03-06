/**
Escribe un programa que dado el precio de un artículo y el precio de venta real nos
muestre el porcentaje de descuento realizado.
 */

import java.util.Scanner;

 public class Ejercicio2 {
    public static void main(String[] args) {
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        float precioVenta = 0, precioReal = 0;
        int descuento = 0;

        /**ALGORITMO */
        //Pide los datos
        System.out.print("Introduce el precio de venta: ");
        precioVenta = sc.nextFloat();
        System.out.print("Introduce el precio de real: ");
        precioReal = sc.nextFloat();

        //Operaciones
        descuento = (int) ((precioVenta * 100) / precioReal);
        descuento = 100 - descuento;
        
        //Muestra por pantalla
        System.out.println("El descuento es de " + descuento + "%");

        sc.close();

    }
}
