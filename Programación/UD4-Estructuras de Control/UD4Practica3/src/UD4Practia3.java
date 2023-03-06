import java.text.DecimalFormat;
import java.util.Scanner;

public class UD4Practia3 {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        SeleccionEjercicio();
    }

    public static void SeleccionEjercicio() {
        int opcion;
        do {
            System.out.println();
            System.out.println("Elige un ejercicio entre 1-9");
            System.out.print("Introduce el número del ejercicio que quieres ejecutar (Para salir introduce 0): ");
            testInt();
            opcion = sc.nextInt();

            switch (opcion) {
                case 0 -> { // Salir
                    System.out.println("Adios!");
                }
                case 1 -> {
                    System.out.println("Has elegido el ejercicio " + opcion);
                    Ejercicio1();
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("Has elegido el ejercicio " + opcion);
                    Ejercicio2();
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Has elegido el ejercicio " + opcion);
                    Ejercicio3();
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("Has elegido el ejercicio " + opcion);
                    Ejercicio4();
                    System.out.println();
                }
                case 5 -> {
                    System.out.println("Has elegido el ejercicio " + opcion);
                    Ejercicio5();
                    System.out.println();
                }
                case 6 -> {
                    System.out.println("Has elegido el ejercicio " + opcion);
                    Ejercicio6();
                    System.out.println();
                }
                case 7 -> {
                    System.out.println("Has elegido el ejercicio " + opcion);
                    Ejercicio7();
                    System.out.println();
                }
                case 8 -> {
                    System.out.println("Has elegido el ejercicio " + opcion);
                    Ejercicio8();
                    System.out.println();
                }
                case 9 -> {
                    System.out.println("Has elegido el ejercicio " + opcion);
                    Ejercicio9();
                    System.out.println();
                }
                default -> { // En otro caso
                    System.out.println("Error: opción incorrecta.");
                }
            }
        } while (opcion != 0);
    }

    public static void testInt() {
        while (!sc.hasNextInt()) {
            System.out.println("Eso no es un número entero!");
            sc.next(); // IMPORTANTE!
        }
    }

    public static int testPosiInt() {
        int numIntro = 0;
        do {
            testInt();
            numIntro = sc.nextInt();

            if (numIntro < 0) {
                System.out.println("Número negativo, vuelve a introducir un número");
            }
        } while (numIntro < 0);
        return numIntro;
    }

    public static void Ejercicio1() {
        /*
        Realiza un programa que cuente los múltiplos de 3 desde el 1 hasta un número que introducimos por teclado.
         */

        /*DATOS*/
        int multiplo3 = 0, numUser = 0;

        /*ALGORITMO*/
        System.out.print("Introduce un número: ");
        testInt();
        numUser = sc.nextInt();

        for (int i = 0; i < numUser; i++) {
            if (i % 3 == 0) {
                multiplo3++;
            }
        }

        System.out.println("Hay " + multiplo3 + " multiplos de 3 en " + numUser);
    }

    public static void Ejercicio2() {
        /*
        Realiza un programa en java que pida un número entero positivo y nos diga si es primo o no.
         */

        /*DATOS*/
        int numUser = 0;
        boolean primo = true;

        /*ALGORITMO*/
        System.out.print("Introduce un número positivo: ");
        numUser = testPosiInt();

        if (numUser == 0 || numUser == 1 || numUser == 4) {
            primo = false;
        } else {
            for (int i = 2; i < numUser / 2; i++) {
                primo = numUser % i != 0;
                if (!primo) {
                    break;
                }
            }
        }
        if (primo) {
            System.out.println(numUser + " es un número primo");
        } else {
            System.out.println(numUser + " no es un número primo");
        }
    }

    public static void Ejercicio3() {
        /*
        Realiza un programa que lea y acepte únicamente aquellos que sean mayores que el
        último dado. La introducción de números finaliza con la introducción de un 0. Al final
        se mostrará:
            El total de números introducidos, excluido el 0.
            El total de números fallados.
         */

        /*DATOS*/
        int countIntro = 0, countFallos = 0, numUser = 0, oldnumUser = -2147483648;

        /*ALGORITMO*/
        do {
            System.out.print("Introduce un número (0 para salir): ");
            testInt();
            numUser = sc.nextInt();
            System.out.println();

            if  (oldnumUser > 0 && numUser == 0) {
                countFallos--;
            }

            if (numUser < oldnumUser) {
                System.out.println("El número es menor que el anterior (Solo aceptamos números que sea mayor que el anterior)");
                countFallos++;
            }

            countIntro++;


            oldnumUser = numUser;

        } while (numUser != 0);

        countIntro--;

        System.out.println("El total de números introducidos, excluido el 0 es: " + countIntro);
        System.out.println("El total de fallos es: " + countFallos);
    }

    public static void Ejercicio4() {
        /*
        Realiza un programa para calcular la suma de los cuadrados de los 5 primeros
        números naturales
         */

        /*DATOS*/
        int suma = 0;

        /*ALGORITMO*/
        for (int i = 1; i <= 5; i++) {
            suma += Math.pow(i, 2);
        }

        System.out.println("La suma del cuadrado de los 5 primeros números naturales es: " + suma);
    }

    public static void Ejercicio5() {
        /*
        Realiza un programa que lea un número y a continuación escriba el carácter “*”
        tantas veces igual al valor numérico leído. En aquellos casos en que el valor leído no
        sea positivo se deberá escribir un único asterisco.
         */

        /*DATOS*/
        int numUser = 0;

        /*ALGORITMO*/
        System.out.print("Introduce un número: ");
        testInt();
        numUser = sc.nextInt();
        if (numUser < 0){
            System.out.print("* ");
        } else {
            for (int i = 0; i < numUser; i++) {
                System.out.print("* ");
            }
        }
    }

    public static void Ejercicio6() {
        /*
        Realiza un programa que pida un número entero N entre 0 y 20 y luego muestre por
        pantalla los números desde 1 hasta N, uno en cada línea, repitiendo cada número
        tantas veces como su valor.
         */

        /*DATOS*/
        int numUser = 0;

        /*ALGORITMO*/
        System.out.println("Introduce un número entero N entre 0 y 20: ");
        numUser = testPosiInt();

        while (numUser > 20) {
            System.out.println("Número erroneo, vuelve a introducir un número");
            numUser = testPosiInt();
        }

        for (int i = 1; i <= numUser; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public static void Ejercicio7() {
        /*
        Realiza un programa que pida dos números enteros A y B, siendo B mayor que A.
        Luego visualiza los números desde A hasta B e indicar cuantos hay que sean pares.
         */

        /*DATOS*/
        int numA = 0, numB = 0, numPares = 0;

        /*ALGORITMO*/
        System.out.print("Dime un número entero: ");
        testInt();
        numA = sc.nextInt();

        System.out.print("Dime otro número entero mayor al anterior: ");
        testInt();
        numB = sc.nextInt();

        while (numB < numA) {
            System.out.println("El número introducido es menor al anterior, introduce uno mayor al anterior");
            testInt();
            numB = sc.nextInt();
        }

        for (int i = numA; i <= numB; i++) {
            System.out.print(i + " ");
            if (i % 2 == 0) {
                numPares++;
            }
        }

        System.out.println("\nHay " + numPares + " números pares");
    }

    public static void Ejercicio8() {
        /*
        Realiza un programa que pida un número y construya por pantalla su pirámide.
         Deberás coger un folio y plantearte como calcular los espacios y los asteriscos que son
         necesarios para la fila n.
         */

        /*DATOS*/
        int numUser=0, numLine = 0;
        String symbol = "*", formato = "%0s";

        /*ALGORITMO*/
        System.out.print("Introduce un número: ");
        testInt();
        numUser = sc.nextInt();

        numLine = numUser;

        for (int i = 0; i < numUser; i++) {
            formato = "%" + numLine + "s" + "%n";
            System.out.printf(formato, symbol);
            symbol += "**";
            numLine += 1;
        }
    }

    public static void Ejercicio9() {
        /*
        Realiza el siguiente ejercicio de potencias.
            • Debes sumar las potencias de tres de cada uno de los números que forman
            un número entero recibido por teclado.
            Por ejemplo, 42 tiene dos dígitos y las potencias terceras de sus dígitos son
            64,8 que suman 72.
            • Deberás coger un folio y plantearte como separar los dígitos con todo lo
            estudiado hasta ahora, para calcular la potencia utiliza la clase Math
            explicada en clase.
         */

        /*DATOS*/
        int numUser = 0, suma = 0, length = 0, numUserInicial = 0;

        /*ALGORITMO*/
        System.out.print("Introduce un número: ");
        testInt();
        numUser = sc.nextInt();

        numUserInicial = numUser;

        length = String.valueOf(numUser).length();

        for (int i = 0; i < length; i++) {
            suma += Math.pow((numUser % 10), 3);
            numUser /= 10;
        }

        System.out.println("La suma de las potencias terceras de " + numUserInicial + " es: " + suma);
    }
}