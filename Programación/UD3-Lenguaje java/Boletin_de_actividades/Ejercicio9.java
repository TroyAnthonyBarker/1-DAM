/**
Pedir dos fechas y mostrar el número de días que hay de diferencia.
Suponiendo todos los meses de 30 días.
*/
 import java.util.Scanner;
 
 public class Ejercicio9{
	 public static void main(String[] args){
		 /**DATOS*/
		 Scanner sc = new Scanner(System.in);
		 String fecha1 = "", fecha2 = "", diaFecha1 = "", diaFecha2 = "", mesFecha1 = "", mesFecha2 = "", anoFecha1 = "", anoFecha2 = "";
		 int diferencia = 1, mes = 30, ano = 365, diafecha1 = 0, diafecha2 = 0, mesfecha1 = 0, mesfecha2 = 0, anofecha1 = 0, anofecha2 = 0, difsDias = 0, difsMeses = 0, difsAnos = 0;
		
		 /**Algoritmo*/
		 //Pide los datos
		 System.out.print("Introduce la primera fecha con formato dd/mm/aaaa: ");
		 fecha1 = sc.nextLine();
		 System.out.print("Introduce la segunda fecha con formato dd/mm/aaaa: ");
		 fecha2 = sc.nextLine();
		 
		 //Substring
		 diaFecha1 = fecha1.substring(0, 2);
		 diaFecha2 = fecha2.substring(0, 2);
		 mesFecha1 = fecha1.substring(3, 5);
		 mesFecha2 = fecha2.substring(3, 5);
		 anoFecha1 = fecha1.substring(6, 10);
		 anoFecha2 = fecha2.substring(6, 10);
		 
		 //Conversión
		 diafecha1 = Integer.parseInt(diaFecha1);
		 diafecha2 = Integer.parseInt(diaFecha2);
		 mesfecha1 = Integer.parseInt(mesFecha1);
		 mesfecha2 = Integer.parseInt(mesFecha2);
		 anofecha1 = Integer.parseInt(anoFecha1);
		 anofecha2 = Integer.parseInt(anoFecha2);
		 
		 //Operaciones
		 difsDias = diafecha2 - diafecha1;
		 difsMeses = (mesfecha2 - mesfecha1) * mes;
		 difsAnos = (anofecha2 - anofecha1) * ano;
		 diferencia = difsDias + difsMeses + difsAnos;
		 
		 //Muestra por pantalla
		 System.out.println("La diferencia en días de las dos fechas es: " + diferencia);
		 sc.close();
	 }
 }