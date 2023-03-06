import java.util.Scanner;

public class Utilidades {
    static Scanner scx;

    public static int PideInt(String textoPideNum) {
        int num = 0;

        //Muestra la frase asignada en cada método que lo pida
        if (textoPideNum.equals("")) {
            System.out.println("Introduce un número entero: ");
        } else {
            System.out.print(textoPideNum);
        }

        //Comprueba que el dato introducido sea un int
        while (!scx.hasNextInt()) {
            System.out.println("Eso no es un número entero!");
            scx.next(); // IMPORTANTE!
        }

        num = scx.nextInt();
        scx.nextLine();
        return num;
    }

    public static int PideIntMinMax(int min, int max, String text) {
        int num;

        if (text.equals("")) {
            text = "Elige un número entre " + min + " y " + max + ": ";
        }
        do {
            num = PideInt(text);
            if (num < min || num > max) {
                System.out.println("Opción errónea");
            }
        } while (num < min || num > max);

        return num;
    }

    public static double PideDouble(String textoPideNum) {
        double num = 0.0;

        //Muestra la frase asignada en cada método que lo pida
        if (textoPideNum.equals("")) {
            System.out.println("Introduce un número: ");
        } else {
            System.out.print(textoPideNum);
        }

        //Comprueba que el dato introducido sea un int
        while (!scx.hasNextDouble()) {
            System.out.println("Eso no es un número válido! (Ej. 1,89)");
            scx.next(); // IMPORTANTE!
        }

        num = scx.nextDouble();
        scx.nextLine();
        return num;
    }

    public static double PideDoubleMinMax(double min, double max, String texto) {
        double num;

        if (texto.equals("")) {
            texto = "Elige un número entre " + min + " y " + max + ": ";
        }
        do {
            num = PideDouble(texto);
            if (num < min || num > max) {
                System.out.println("Opción errónea");
            }
        } while (num < min || num > max);

        return num;
    }
}