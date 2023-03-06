import es.iesmz.prueba.Coche;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Coche primerCoche = new Coche("Fiat", "Panda", "Amarillo");
        Coche segundoCoche = new Coche("", "", "");

        primerCoche.imprime();                      // Imprimir dades del cotxe

        primerCoche.pinta();                        // Pintar el cotxe

        System.out.print("Introduce la marca: ");   // Establir Marca (demanant per teclat)
        segundoCoche.setMarca(sc.nextLine());

        System.out.print("Introduce el modelo: ");  // Establir Model (demanant per teclat)
        segundoCoche.setModelo(sc.nextLine());

        System.out.print("Introduce el color: ");   // Establir Color (demanant per teclat)
        segundoCoche.setColor(sc.nextLine());

        System.out.print("Introduce la velocidad de aceleración: ");    // Accelerar (Demanant la velocitat per teclat)
        segundoCoche.acelera(sc.nextInt());

        System.out.print("Introduce la velocidad de aceleración: ");    // Frenar (Demanant la velocitat per teclat)
        segundoCoche.frena(sc.nextInt());

        segundoCoche.para();                        // Parar
    }
}