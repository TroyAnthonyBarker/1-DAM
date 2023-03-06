import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args){
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        int radio;
        int result;

        /**ALGORITMO */
        System.out.println("Introduce la radio del circulo");
        radio= sc.nextInt();

        result= (int) (Math.PI * Math.pow(radio, 2));

        System.out.println("El area de un círculo, cuya radio es " + radio + ", es " + result);
        
        sc.close();
    }

}
