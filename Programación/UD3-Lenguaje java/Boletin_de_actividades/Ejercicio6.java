import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        /** DATOS */
        Scanner sc = new Scanner(System.in);
        Double nota = 0.0;
        String calificacion = "";

        /** ALGORITMO */
        System.out.print("Introduce tu calificación: ");
        nota = sc.nextDouble();

        if (nota >= 0 && nota < 5){
            calificacion = "Suspenso";
        }
        else if (nota >= 5 && nota < 6){
            calificacion = "Suficiente";
        }
        else if (nota >= 6 && nota < 7){
            calificacion = "Bien";
        }
        else if (nota >= 7 && nota < 9){
            calificacion = "Notable";
        }
        else if (nota >= 9 && nota <= 10){
            calificacion = "Sobresaliente";
        }
        else {
            calificacion = "Nota erroneo";
        }

        System.out.println("Tu calificación es: " + calificacion);

        sc.close();
    }
}
