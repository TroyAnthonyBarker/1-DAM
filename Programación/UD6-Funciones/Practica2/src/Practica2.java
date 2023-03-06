import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;

public class Practica2 {

    static Scanner sc;

    public static void main(String[] args) {
        Utilidades.sca = new Scanner(System.in);
        sc = new Scanner(System.in);
        int opcion;

        do {
        System.out.println();
        opcion = Utilidades.pideIntMinMax(0, 16, "Elije un ejercicio entre 1-8 (0 para salir): ");

        eligeEjercicio(opcion);
        }  while (opcion != 0);
    }

    public static void eligeEjercicio(int option) {
        System.out.println();
        if (option != 0) {
            System.out.println("Ejercicio " + option);
            System.out.println();
        }
        switch (option) {
            default -> {
                System.out.println("Adiós");
            }
            case 1 -> {
                ejercicio1();
            }
            case 2 -> {
                ejercicio2();
            }
            case 3 -> {
                ejercicio3();
            }
            case 4 -> {
                ejercicio4();
            }
            case 5 -> {
                ejercicio5();
            }
            case 6 -> {
                ejercicio6();
            }
            case 7 -> {
                ejercicio7();
            }
            case 8 -> {
                ejercicio8();
            }
        }
    }

    private static void ejercicio1() {
        /*
        Realiza un programa que nos pida número enteros hasta que se introduzca el 0,
        diciéndonos, para cada número introducido si es primo o no. Hay que recordar
        que un número es primo si es divisible por si mismo y por 1. El 1 no es primo por
        convenio. Se debe crear una función que pasándole un número entero devuelva
        si es primo o no.
         */

        int num = Utilidades.pideIntMinMax(0, Integer.MAX_VALUE, "Introduce un número positivo: ");

        if (esPrimo(num)) {
            System.out.println("El número introducido es primo.");
        } else {
            System.out.println("El número introducido no es primo.");
        }

    }

    static boolean esPrimo(int numUser) {
        boolean primo = true;

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

        return primo;
    }

    private static void ejercicio2() {
        /*
        El NIF (o letra asociada a un DNI) se obtiene de la siguiente manera: Se divide el
        número de DNI entre 23 y el resto es codificado por una letra según la siguiente
        equivalencia:

        0: "T", 1: "R", 2: "W", 3: "A", 4: "G", 5: "M", 6: "Y", 7: "F", 8: "P", 9: "D",10:"X", 11: "B", 12: "N",
        13: "J", 14: "Z", 15: "S", 16: "Q", 17: "V", 18: "H", 19: "L", 20: "C", 21: "K", 22: "E".

        Escribe un programa que pida el DNI y muestre por pantalla la letra asociada.
        Para ello se deberá crear una función a la que se le pase el número y devuelva la
        letra.
         Ejemplo: para el DNI 56321122 el NIF es ‘X’
         */
        String dni = pideDNI();

        if (validaDNI(dni)) {
            System.out.println("DNI/NIE correcto");
        } else {
            System.out.println("DNI/NIE incorrecto");
        }

    }

    static String pideDNI() {
        String dni = "";

        System.out.print("Introduce el número del DNI (si es NIE cambie la primera letra por 0): ");

        dni = sc.nextLine();

        while (dni.length() != 9 || dni.substring(0, 8).matches(".*[a-z A-Z].*")) {
            System.out.println("DNI/NIE incorrecto, si es NIE cambie la primera letra por 0");
            dni = sc.nextLine();
        }
        return dni;
    }

    static char letraDNI(int numDNI) {
        int posLetra = numDNI % 23;
        char[] letra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return letra[posLetra];
    }

    static boolean validaDNI(String dni) {
        String numDNIString = dni.substring(0, 8);
        int numDNI = Integer.parseInt(numDNIString);
        String dniLetra = dni.substring(8, 9);
        dniLetra = dniLetra.toUpperCase();
        return dniLetra.equals(Character.toString(letraDNI(numDNI)));
    }

    private static void ejercicio3() {
        /*
        Realiza un programa que permita comprobar si una terna de valores enteros (3
        valores) se ajusta a la ecuación de Pitágoras: x ² + y ² = z ². El programa solicita al
        usuario los valores x, y, z. Se deberá crear una función a la que se le pase x, y, z y
        devuelva si son iguales o no.
        Por ejemplo: 3 ² + 4 ² = 5 ².
         */
        double x = Utilidades.pideDouble("Introduce la medida de un lado: ");
        double y = Utilidades.pideDouble("Introduce la medida de otro lado: ");
        double z = Utilidades.pideDouble("Introduce la medida de la hipotenusa: ");
        if (esTriangulo(x, y, z)) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }

    }

    static boolean esTriangulo(double x, double y, double z) {
        x = Math.pow(x, 2);
        y = Math.pow(y, 2);
        z = Math.pow(z, 2);
        return (x + y) == z;
    }

    private static void ejercicio4() {
        /*
        Escribe un programa que imprima las tablas de multiplicar del 1 al 10.
        Implementa una función que reciba un número entero como parámetro e
        imprima su tabla de multiplicar
         */
        int num = Utilidades.pideInt("Introduce un número: ");
        tablaMultiplicar(num);
    }

    static void tablaMultiplicar(int x) {
        int[] tabla = new int[10];
        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = (i + 1) * x;
        }
        System.out.println("Tabla de multiplicar del " + x);
        for (int i = 0; i < tabla.length; i++) {
            System.out.println("\t" + (i + 1) + " * " + x + " = " + tabla[i]);
        }
    }

    private static void ejercicio5() {
        /*
        Escribe un programa que muestre un menú con 2 opciones: “1.Circunferencia” y
        “2.Área”.
        En ambas se le pedirá al usuario que introduzca un radio y luego se le mostrará el cálculo
        oportuno. Implementa las funciones:
            int menu() // Muestra el menú y devuelve el número elegido
            double pideRadio() // Pide que se introduzca el radio y lo devuelve
            double circunferencia(double r) // Calcula la circunferencia y la devuelve
            double area(double r) // Calcula el área y la devuelve
        Modifica el programa añadiendo otra opción llamada “Volumen”, permitiendo que el
        usuario también pueda solicitar el cálculo del volumen. Añade la función:
            double volumen(double r) // Calcula el volumen y lo devuelve
        Modifica el programa añadiendo otra opción llamada “Todas” en la que se pida el radio
        una sola vez y se muestren los tres cálculos posibles (circunferencia, área y volumen).
        Modifica el programa anterior de modo que el proceso se repita una y otra vez (mostrar
        menú -> realizar el cálculo -> volver a mostrar menú). Añade una opción más llamada
        “Salir” que terminará el programa si es elegida.
         */
        int option = 0;

        do {
            option = menu();
            operacionCirculoElegido(option);
        } while (option != 0);
    }

    static int menu() {
        System.out.println("""
                Opciones:
                \t1. Circunferencia
                \t2. Área
                \t3. Volumen
                \t4. Todas las anteriores
                \t0. Salir
                """);
        return Utilidades.pideIntMinMax(0, 4, "Elige una opción: ");
    }

    static void operacionCirculoElegido(int option) {
        switch (option) {
            default -> {
                System.out.println("Adíos!");
            }
            case 1 -> {
                System.out.println("La circunferencia es: " + String.format("%.2f", circunferencia(pideRadio())));
            }
            case 2 -> {
                System.out.println("El área es: " + String.format("%.2f", areaCirculo(pideRadio())));
            }
            case 3 -> {
                System.out.println("El volumen es: " + String.format("%.2f", volumenCirculo(pideRadio())));
            }
            case 4 -> {
                double radio = pideRadio();
                System.out.println("La circunferencia es: " + String.format("%.2f", circunferencia(radio)));
                System.out.println("El área es: " + String.format("%.2f", areaCirculo(radio)));
                System.out.println("El volumen es: " + String.format("%.2f", volumenCirculo(radio)));
            }
        }
    }

    static double pideRadio() {
        return Utilidades.pideDouble("Introduce la radio: ");
    }

    static double circunferencia(double r) {
        return Math.PI * (r * 2);
    }

    static double areaCirculo(double r) {
        return Math.PI * Math.pow(r, 2);
    }

    static double volumenCirculo(double r) {
        return (double) 4 / 3 * Math.PI * Math.pow(r, 3);
    }

    private static void ejercicio6() {
        /*
        Dado un String, que se pedirá por pantalla, encuentra la primera letra mayúscula
        y muéstrala por pantalla. Realiza este programa inicialmente de forma recursiva,
        y posteriormente de forma iterativa.
         */
        String frase, mayuscula = "";

        System.out.println("Introduce una frase: ");
        frase = sc.nextLine();

        for (int i = 0; i < frase.length(); i++) {
            if (Character.isUpperCase(frase.charAt(i))) {
                mayuscula = String.valueOf(frase.charAt(i));
                i = frase.length();
            }
        }

        System.out.println("De forma iterativa es: " + mayuscula);
        System.out.println("De forma recursiva es: " + primeraMayuscula(frase, 0));
    }

    static char primeraMayuscula(String frase, int cont) {
        if (Character.isUpperCase(frase.charAt(cont))) {
            return frase.charAt(cont);
        } else {
            return primeraMayuscula(frase, cont + 1);
        }
    }

    //h gft

    private static void ejercicio7() {
        /*
        Dado un array de enteros, imprime por pantalla un triángulo con la suma de cada
        nivel, subiendo hacia arriba. El primer nivel de números será el que se pase por
        parámetro. A partir de ese primer nivel (nivel base) de abajo del todo, los
        superiores irán conteniendo un elemento menos a medida que va formándose
        el triángulo con la suma de los elementos nexos del nivel anterior. Esta tarea se
        tendrá que realizar mediante recursividad y también mostrará por pantalla el
        triángulo.
         */
        int lineas = Utilidades.pideInt("Introduce las lineas del triangulo: ");
        triangulo(lineas, lineas, "*", 0);
//        triangulo2(lineas, 0);
    }

    static void triangulo(int lineas, int numLine, String lineaTriangulo, int count) {
        if (count < lineas) {
            String formato = "%" + numLine + "s" + "%n";
            System.out.printf(formato, lineaTriangulo);
            numLine++;
            lineaTriangulo += "**";
            count++;
            triangulo(lineas, numLine, lineaTriangulo, count);
        }
    }

    static void triangulo2(int lineas, int count) {
        String[] linea = new String[lineas];
        String formato;

        if (count == 0) {
            formato = "%" + lineas + "s" + "%n";
            linea[0] = "*";
            System.out.printf(formato, linea[0]);
            count++;
            triangulo2(lineas, count);
        } else if (count < linea.length) {
            int numFormato = lineas + count;
            formato = "%" + numFormato + "s" + "%n";
            linea[count] = "**" + linea[count - 1];
            System.out.printf(formato, linea[count]);
            count++;
            triangulo2(lineas, count);
        }

        /*for (int i = 1; i < linea.length; i++) {
            int numFormato = lineas + i;
            formato = "%" + numFormato + "s" + "%n";
            linea[i] = linea[i-1] + "**";
            System.out.printf(formato, linea[i]);
        }*/
    }


    private static void ejercicio8() {
        /*
        Realiza un programa que encuentre el mínimo y máximo elemento de un array
        mediante dos funciones (una para cada uno). Este programa tendrá que obtener
        la solución mediante recursión y lo mostrará por pantalla.
         */
        int[] numeros = new int[10];
        numeros = fillArrayRandom(numeros, 0);

        int minimo = minimo(numeros, Integer.MAX_VALUE, 0);
        int maximo = maximo(numeros, Integer.MIN_VALUE, 0);

        System.out.println("El array es: " + Arrays.toString(numeros));
        System.out.println("El número mínimo es: " + minimo);
        System.out.println("El número máximo es: " + maximo);
    }

    static int[] fillArrayRandom(int[] array, int count) {
        if (count < array.length) {
            array[count] = (int) (1000 * Math.random());
            count++;
            return fillArrayRandom(array, count);
        } else {
            return array;
        }
    }

    static int minimo(int[] array, int minimo, int count) {
        if (count < array.length) {
            if (minimo > array[count]) {
                minimo = array[count];
            }
            count++;
            return minimo(array, minimo, count);
        } else {
            return minimo;
        }
    }
    static int maximo(int[] array, int max, int count) {
        if (count < array.length) {
            if (max < array[count]) {
                max = array[count];
            }
            count++;
            return maximo(array, max, count);
        } else {
            return max;
        }

    }
}