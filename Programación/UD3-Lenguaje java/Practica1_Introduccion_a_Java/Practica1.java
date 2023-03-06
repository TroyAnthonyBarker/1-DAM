package Practica1_Introduccion_a_Java;

import java.util.Scanner;

public class Practica1 {
    public enum sexo {V,M}  // variable de tipo "enumerado" con 2 posibles valores
    public static void main(String[] args) {
        System.out.println("");

        /**Ejercicio2 */
        System.out.println("Buenos días");
        
        System.out.println("");

        /**Ejercicio3 */
        /**DATOS*/
        int area1;
        /**ALGORITMO */
        area1= 5 * 5;
        System.out.println("El área de un cuadrado cuyo lado sea igua a 5 es: " + area1);
        
        System.out.println("");

        /**Ejercicio4 */
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        String name;

        /**ALGORITMO */
        System.out.print("Introduce tu nombre: ");
        name= sc.next();
        System.out.println("Bienvenido " + name);
        
        System.out.println("");

        /**Ejercicio5 */
        /**DATOS */
        int lado = 0, area2 = 0;

        /**ALGORITMO */
        System.out.print("Introduce el lado del cuadrado: ");
        lado = sc.nextInt();
        area2 = lado * lado;
        System.out.println("El área del cuadrado cuyo lado sea igual a " + lado + " es: " + area2);

        System.out.println("");

        /**Ejercicio6 */
        /**DATOS */
        double radio = 0, area3 = 0;
        /**ALGORITMO */
        System.out.print("Introduce la radio: ");
        radio = sc.nextInt();
        area3 = Math.PI * Math.pow(radio, 2);
        System.out.println("El área de una circunferencia cuyo radio sea " + radio + " es: " + String.format("%.2f", area3));
        
        System.out.println("");

        /**Ejercicio7 */
        /**DATOS */
        int num1 = 0, num2 = 0, suma = 0, resta = 0, producto = 0, division = 0;

        /**ALGORITMO */
        /**Lee dos números */
        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();
        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextInt();

        /**Hace las operaciones */
        suma = num1 + num2;
        resta = num1 - num2;
        producto = num1 * num2;
        division = num1 / num2;

        /**Muestra los resultados */
        System.out.println(num1 + " + " + num2 + " = " + suma);
        System.out.println(num1 + " - " + num2 + " = " + resta);
        System.out.println(num1 + " * " + num2 + " = " + producto);
        System.out.println(num1 + " / " + num2 + " = " + division);
        
        System.out.println("");
        sc.close();

        /**DATOS */
        
        // Sólo puede tener 2 valores true o false
		boolean casado = true;

		// con final declaramos la variable como constante el tipo de variable "int" tiene un rango de valores de: -2,147,483,648 a 2,147,483,647
		final int MAXIMO = 999999;

        // dias de la semana del 1 al 7 con un tipo byte es suficiente
        byte diasem[] = {1,2,3,4,5,6,7};

		// los días del año como max será de 366 por lo que no puede ser "byte" ya que si rango es de -128 a 127 
        // por lo que ha de ser el siguiente tipo "short" que su rango es -32,768 a 32,767
		short diaanual = 300;

		// Los milisegundos transcurridos desde el 01/01/1970 son unos 43 años que son 43 años x 365 dias x 24 horas x 60 min. x 60 seg. x 1000 milisegundos = 1,356048e+12 
        // lo que entra en el rango del tipo de variable long -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807
		long miliseg = 1298332800000L;

		// suficiente con los decimales que nos da el rango float para representar un valor monetario con 2 decimales.
		float totalfactura = 10350.677734F;

		// la población mundial está cerca de los 7.000.000.000 por lo que no es suficiente con el rango de int que no llega ni a 
		// 3.000.000.000 pero si con el de "long" cuyo rango es: -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807
		long poblacion = 6775235741L;

    sexo genero = sexo.M;

      // visualización de las variables con println
      System.out.println("----- EJERCICIO DE VARIABLES Y TIPOS DE DATOS -----");
      System.out.println("\tEl valor de la variable casado es "+ casado);
      System.out.println("\tEl valor de la variable MAXIMO es "+ MAXIMO);
      System.out.println("\tEl valor de la variable diasem es "+ diasem[0]);
      System.out.println("\tEl valor de la variable diaanual es "+ diaanual);
      System.out.println("\tEl valor de la variable miliseg es "+ miliseg);
      System.out.println("\tEl valor de la variable totalfactura es "+ totalfactura);
      System.out.println("\tEl valor de la variable poblacion es "+ poblacion);
      System.out.println("\tEl valor de la variable sexo es "+ genero);
      
      // visualización de las variables con printf
      System.out.printf("%s", "\n----- EJERCICIO DE VARIABLES Y TIPOS DE DATOS -----");
      System.out.printf("%s%s", "\n\tEl valor de la variable casado es ", casado);
      System.out.printf("%s%s", "\n\tEl valor de la variable MAXIMO es ", MAXIMO);
      System.out.printf("%s%s", "\n\tEl valor de la variable diasem es ", diasem[0]);
      System.out.printf("%s%s", "\n\tEl valor de la variable diaanual es ", diaanual);
      System.out.printf("%s%s", "\n\tEl valor de la variable miliseg es ", miliseg);
      System.out.printf("%s%s", "\n\tEl valor de la variable totalfactura es ", String.format("%.5f", totalfactura));
      System.out.printf("%s%s", "\n\tEl valor de la variable totalfactura en notación científica es ", String.format("%1.6e", totalfactura));
      System.out.printf("%s%s", "\n\tEl valor de la variable poblacion es ", poblacion);
      System.out.printf("%s%s", "\n\tEl valor de la variable sexo es ", genero);
    }
}
