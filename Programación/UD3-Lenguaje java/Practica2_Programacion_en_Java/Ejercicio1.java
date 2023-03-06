import java.util.Scanner;
/** 
Escribe un programa que toma como dato de entrada un número que corresponde
a la longitud de un radio y nos escribe la longitud de la circunferencia, el área del
círculo y el volumen de la esfera que corresponden con dicho radio.
*/

public class Ejercicio1 {
    public static void main(String[] args) {
    
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        double radio = 0, area = 0, circunferencia = 0, volumen = 0;

        /**ALGORITMO */
        //Pide los datos
        System.out.print("Introduce la radio: ");
        radio = sc.nextInt();

        //Operaciones
        area = Math.PI * Math.pow(radio, 2);
        circunferencia = Math.PI * (radio * 2);
        volumen = 4/3 * Math.PI * Math.pow(radio, 3);
        
        //Muestra por pantalla
        System.out.println("Dando que la radio sea " + radio + " tenemos:");
        System.out.println("\tArea = " + String.format("%.2f", area));
        System.out.println("\tCircunferencia = " + String.format("%.2f", circunferencia));
        System.out.println("\tVolumen = " + String.format("%.2f", volumen));

        sc.close();

    }
}