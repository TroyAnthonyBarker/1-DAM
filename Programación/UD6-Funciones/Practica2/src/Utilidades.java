import java.util.Scanner;

public class Utilidades {
    static Scanner sca;
    public static int pideInt(String textoPideNum) {
        int num = 0;

        //Muestra la frase asignada en cada método que lo pida
        System.out.print(textoPideNum);

        //Comprueba que el dato introducido sea un int
        while (!sca.hasNextInt()) {
            System.out.println("Eso no es un número entero!");
            sca.next(); // IMPORTANTE!
        }

        num = sca.nextInt();
        sca.nextLine();
        return num;
    }

    public static int pideIntMinMax(int min, int max, String text){
        int num;

        if (text.equals("")){
            text = "Elige un número entre " + min + " y " + max + ": ";
        }
        do {
            num = pideInt(text);
            if (num < min || num > max) {
                System.out.println("Opción errónea");
            }
        } while (num < min || num > max);

        return num;
    }

    public static double pideDouble(String textoPideNum) {
        double num = 0.0;

        //Muestra la frase asignada en cada método que lo pida
        System.out.print(textoPideNum);

        //Comprueba que el dato introducido sea un int
        while (!sca.hasNextDouble()) {
            System.out.println("Eso no es un número válido! (Ej. 1,89)");
            sca.next(); // IMPORTANTE!
        }

        num = sca.nextDouble();
        sca.nextLine();
        return num;
    }

    public static double pideDoubleMinMax(double min, double max, String texto){
        double num;

        if (texto.equals("")){
            texto = "Elige un número entre " + min + " y " + max + ": ";
        }
        do {
            num = pideDouble(texto);
            if (num < min || num > max) {
                System.out.println("Opción errónea");
            }
        } while (num < min || num > max);

        return num;
    }}