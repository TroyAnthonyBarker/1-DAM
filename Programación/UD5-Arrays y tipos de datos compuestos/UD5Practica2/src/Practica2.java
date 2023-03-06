import java.util.Arrays;
import java.util.Scanner;

public class Practica2 {

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int opcion = 1;

        do {
            opcion = PideIntMinMax(0, 5, "Elige un Ejercicio entre 1 y 5 (0 para salir): ");
            sc.nextLine();
            EligeEjercicio(opcion);
        } while (opcion != 0);
    }

    public static int PideInt(String textoPideNum) {
        int num = 0;

        //Muestra la frase asignada en cada método que lo pida
        System.out.print(textoPideNum);

        //Comprueba que el dato introducido sea un int
        while (!sc.hasNextInt()) {
            System.out.println("Eso no es un número entero!");
            sc.next(); // IMPORTANTE!
        }

        num = sc.nextInt();
        return num;
    }

    public static int PideIntMinMax(int min, int max, String text){
        int num;

        if (text.equals("")){
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

    public static void EligeEjercicio(int opcion) {
        System.out.println();
        switch (opcion) {
            default -> {
                System.out.println("Adíos!!");
            }
            case 1 -> {
                Ejercicio1();
                System.out.println();
            }
            case 2 -> {
                Ejercicio2();
                System.out.println();
            }
            case 3 -> {
                Ejercicio3();
                System.out.println();
            }
            case 4 -> {
                Ejercicio4();
                System.out.println();
            }
            case 5 -> {
                Ejercicio5();
                System.out.println();
            }
        }
    }

    public static void Ejercicio1() {
        /*
        Crea un programa que pida una cadena de texto por teclado y luego muestre cada
        palabra de la cadena en una línea distinta.
         */

        String cadena1 = "";
        String[] split;

        System.out.print("Introduce una frase: ");
        cadena1 = sc.nextLine();

        split = cadena1.split(" ");

        System.out.println();

        for (String i : split){
            System.out.println(i);
        }
    }

    public static void Ejercicio2() {
        /*
        Crea un programa que pida dos cadenas de texto por teclado y luego indique si son
        iguales, además de si son iguales sin diferenciar entre mayúsculas y minúsculas
         */
        String cadena1 = "", cadena2 = "";

        System.out.println("Introduce un texto: ");
        cadena1 = sc.nextLine();
        System.out.println();

        System.out.println("Introduce otro texto: ");
        cadena2 = sc.nextLine();
        System.out.println();

        if (cadena1.equals(cadena2)){
            System.out.println("Son iguales. Sin diferencia entre mayúsculas y minúsculas");
        } else if (cadena1.equalsIgnoreCase(cadena2)) {
            System.out.println("Son iguales. Con diferencia entre mayúsculas y minúsculas");
        } else {
            System.out.println("Son distintos");
        }
    }

    public static void Ejercicio3() {
        /*
        Crea un programa que pida por teclado tres cadenas de texto: nombre y dos
        apellidos. Luego mostrará un código de usuario (en mayúsculas) formado por la
        concatenación de las tres primeras letras de cada uno de ellos. Por ejemplo, si se
        introduce “Alberto”, “Alemany” y “Navarro” mostrará “ALBALENAV”
         */

        String nombre = "", apellido1 = "", apellido2 = "", codigo1 = "", codigo2 = "", codigo3 = "", codigo = "";
        char[] name, surname1, surname2;

        System.out.print("Introduce tu nombre: ");
        nombre = sc.nextLine();

        System.out.print("Introduce tu primer apellido: ");
        apellido1 = sc.nextLine();

        System.out.print("Introduce tu segundo apellido: ");
        apellido2 = sc.nextLine();

        nombre = nombre.toUpperCase();
        apellido1 = apellido1.toUpperCase();
        apellido2 = apellido2.toUpperCase();

        name = nombre.toCharArray();
        surname1 = apellido1.toCharArray();
        surname2 = apellido2.toCharArray();

        for (int i = 0; i < 3; i++) {
            codigo1 += name[i];
            codigo2 += surname1[i];
            codigo3 += surname2[i];
        }

        codigo = codigo1 + codigo2 + codigo3;

        System.out.println();
        System.out.println("Tu código de usuario es: " + codigo);

    }

    public static void Ejercicio4() {
        /*
        Crea un programa que muestre por pantalla cuantas vocales de cada tipo hay
        (cuantas ‘a’, cuantas ‘e’, etc.) en una frase introducida por teclado. No se debe
        diferenciar entre mayúsculas y minúsculas. Por ejemplo, dada la frase “Mi mama me
        mima” dirá que hay:
            Nº de A's: 3
            Nº de E's: 1
            Nº de I's: 2
            Nº de O's: 0
            Nº de U's: 0
         */

        String cadena1 = "";
        char[] frase;
        int a = 0, e = 0, i = 0, o = 0, u = 0;

        System.out.println("Introduce una frase:");
        cadena1 = sc.nextLine();

        cadena1 = cadena1.toLowerCase();

        frase = cadena1.toCharArray();

        for (char c : frase) {
            if (c == 'a') {
                a++;
            } else if (c == 'e') {
                e++;
            } else if (c == 'i') {
                i++;
            } else if (c == 'o') {
                o++;
            } else if (c == 'u') {
                u++;
            }
        }

        System.out.println();
        System.out.println("Vocales de la frase: ");
        System.out.println("\tN.º de A's: " + a);
        System.out.println("\tN.º de E's: " + e);
        System.out.println("\tN.º de I's: " + i);
        System.out.println("\tN.º de O's: " + o);
        System.out.println("\tN.º de U's: " + u);
    }

    public static void Ejercicio5() {
        /*
        Realiza un programa que lea una frase por teclado e indique si la frase es un
        palíndromo o no (ignorando espacios y sin diferenciar entre mayúsculas y
        minúsculas). Supondremos que el usuario solo introducirá letras y espacios (ni
        comas, ni puntos, ni acentos, etc.). Un palíndromo es un texto que se lee igual de
        izquierda a derecha que de derecha a izquierda.
        Por ejemplo:
            Amigo no gima
            Dabale arroz a la zorra el abad
            Amo la pacífica paloma
            A man a plan a canal Panama
         */

        String cadena = "", cadena1 = "", cadena2 = "";
        char[] letras;

        System.out.println("Introduce un texto: ");
        cadena = sc.nextLine();

        cadena = cadena.toLowerCase();

        cadena = cadena.replace(" ", "");

        letras = cadena.toCharArray();

        // amigonogima

        for (int i = 0; i < (cadena.length()/2); i++) {
            cadena1 += letras[i];
        }

        if (cadena.length()%2 == 0) {
            for (int i = cadena.length()-1; i >= (cadena.length()/2); i--) {
                cadena2 += letras[i];
            }
        } else {
            for (int i = cadena.length()-1; i >= ((cadena.length()/2) + 1); i--) {
                cadena2 += letras[i];
            }
        }

        System.out.println();

        if (cadena1.equals(cadena2)){
            System.out.println("Es una frase palíndromo");
        } else {
            System.out.println("No es una frase palíndromo");
        }
    }
}
