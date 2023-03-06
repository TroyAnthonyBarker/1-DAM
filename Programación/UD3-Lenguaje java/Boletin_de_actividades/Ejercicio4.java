import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args){
        /**DATOS */
        Scanner sc = new Scanner(System.in);
        int num1 = 0, num2 = 0;

        /**ALGORITMO */
        System.out.println("Introduce el primer número");
        num1= sc.nextInt();
        System.out.println("Introduce el segundo número");
        num2= sc.nextInt();

        if (num1 > num2) {
            System.out.println(num2 + " < " + num1);
        } else {
            System.out.println(num1 + " < " + num2);
        }

        sc.close();
    }
}
