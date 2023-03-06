import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainEjercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Gato> listaDeGatos = new ArrayList<>();
        int count = 0;
        do {
            System.out.print("Gato Nº"+(count+1)+" Introduce el nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Gato Nº"+(count+1)+" Introduce la edad: ");
            int edad = sc.nextInt();
            sc.nextLine();
            try{
                listaDeGatos.add(new Gato(nombre, edad));
                count++;
            } catch (InvalidAgeException | InvalidNameException e) {
                e.printStackTrace();
            }
        } while (count < 5);
        System.out.println();
        for (Gato gato : listaDeGatos) {
            gato.imprimir();
        }
    }
}
