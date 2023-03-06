/**
Actividad 8. Pedir un número entre 0 y 9999 y decir cuantas cifras tiene
*/

 import java.util.Scanner;
 
 public class Ejercicio8 {
	 public static void main(String[] args){
		 /**DATOS*/
		 Scanner sc = new Scanner(System.in);
		 int num1 = 9999;
		 String numero1 = "";
		 
		 /**ALGORITMO*/
		 //Pide los datos
		 System.out.print("Introduce un número entre 0 y 9999: ");
		 num1 = sc.nextInt();
		 
		 // Comprueba que tiene entre 0 y 4 cifras, convierte de INT a STRING y muestra por pantalla
		 if (num1 >= 0 && num1 <= 9999){
		 numero1 = String.valueOf(num1);
		 System.out.println("El número tiene " + numero1.length() + " cifras");
		 }
		 else {
			 System.out.println("El número es incorrecto");
		 }
		 sc.close();
	 }
 }
		 