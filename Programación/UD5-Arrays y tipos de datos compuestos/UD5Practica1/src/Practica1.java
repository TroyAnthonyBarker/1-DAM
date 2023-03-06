import java.lang.Math;
import java.util.*;

public class Practica1 {

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int opcion = 1;

        do {
            opcion = PideIntMinMax(0, 20, "Elige un Ejercicio entre 1 y 20 (0 para salir): ");

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

    public static double PideDouble(String textoPideNum) {
        double num = 0.0;

        //Muestra la frase asignada en cada método que lo pida
        System.out.print(textoPideNum);

        //Comprueba que el dato introducido sea un int
        while (!sc.hasNextDouble()) {
            System.out.println("Eso no es un número válido! (Ej. 1,89)");
            sc.next(); // IMPORTANTE!
        }

        num = sc.nextDouble();
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

    public static double PideDoubleMinMax(double min, double max, String texto){
        double num;

        if (texto.equals("")){
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
            case 6 -> {
                Ejercicio6();
                System.out.println();
            }
            case 7 -> {
                Ejercicio7();
                System.out.println();
            }
            case 8 -> {
                Ejercicio8();
                System.out.println();
            }
            case 9 -> {
                Ejercicio9();
                System.out.println();
            }
            case 10 -> {
                Ejercicio10();
                System.out.println();
            }
            case 11 -> {
                Ejercicio11();
                System.out.println();
            }
            case 12 -> {
                Ejercicio12();
                System.out.println();
            }
            case 13 -> {
                Ejercicio13();
                System.out.println();
            }
            case 14 -> {
                Ejercicio14();
                System.out.println();
            }
            case 15 -> {
                Ejercicio15();
                System.out.println();
            }
            case 16 -> {
                Ejercicio16();
                System.out.println();
            }
            case 17 -> {
                Ejercicio17();
                System.out.println();
            }
            case 18 -> {
                Ejercicio18();
                System.out.println();
            }
            case 19 -> {
                Ejercicio19();
                System.out.println();
            }
            case 20 -> {
                Ejercicio20();
                System.out.println();
            }
        }
    }

    public static void Ejercicio1() {
        /*
        Crea un programa que pida diez números reales por teclado, los almacene en un
        array, y luego muestre todos sus valores.
         */

        int[] num = new int[10];

        for (int i = 0; i < num.length; i++) {
            num[i] = PideInt("Introduce un número: ");
        }

        System.out.println();
        System.out.println("Los valores introducidos son " + Arrays.toString(num));
    }

    public static void Ejercicio2() {
        /*
        Crea un programa que pida diez números reales por teclado, los almacene en un
        array, y luego muestre la suma de todos los valores.
        */

        int[] num = new int[10];
        int suma = 0;

        for (int i = 0; i < num.length; i++) {
            num[i] = PideInt("Introduce un número: ");
        }

        for (int j : num) {
            suma += j;
        }

        System.out.println();
        System.out.println("La suma de los número introducidos es " + suma);
    }

    public static void Ejercicio3() {
        /*
        Crea un programa que pida diez números reales por teclado, los almacene en un
        array, y luego lo recorra para averiguar el máximo y mínimo y mostrarlos por pantalla.
         */

        int[] num = new int[10];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i = 0; i < num.length; i++) {
            num[i] = PideInt("Introduce un número: ");
        }

        for (int j : num) {
            if (j < min || j > max){
                if (j > max) {
                    max = j;
                }
                if (j < min) {
                    min = j;
                }
            }
        }

        System.out.println();
        System.out.println("El número máximo es: " + max);
        System.out.println("El número mínimo es: " + min);
    }

    public static void Ejercicio4() {
        /*
        Crea un programa que pida veinte números enteros por teclado, los almacene
        en un array y luego muestre por separado la suma de todos los valores positivos
        y negativos.
         */

        int[] num = new int[10];
        int sumaPosi = 0, sumaNega = 0;

        for (int i = 0; i < num.length; i++) {
            num[i] = PideInt("Introduce un número: ");
        }

        for (int j : num) {
            if (j > 0) {
                sumaPosi += j;
            } else {
                sumaNega += j;
            }
        }

        System.out.println();
        System.out.println("La suma de los número positivos introducidos es: " + sumaPosi);
        System.out.println("La suma de los número negativos introducidos es: " + sumaNega);
    }

    public static void Ejercicio5() {
        /*
        Crea un programa que pida veinte números reales por teclado, los almacene en
        un array y luego lo recorra para calcular y mostrar la media: (suma de valores) /
        nº de valores.
         */

        int[] num = new int[20];
        int suma = 0;
        double media = 0.0;

        for (int i = 0; i < num.length; i++) {
            num[i] = PideInt("Introduce un número: ");
        }

        for (int j : num) {
            suma += j;
        }

        media = (double) suma / num.length;

        System.out.println();
        System.out.println("La media de los número introducidos es " + media);
    }

    public static void Ejercicio6() {
        /*
        Crea un programa que pida dos valores enteros N y M, luego cree un array de
        tamaño N, escriba M en todas sus posiciones y lo muestre por pantalla.
         */

        int[] num;
        int n = 0, m = 0;

        n = PideInt("Introduce el tamaño del array: ");

        m = PideInt("Introduce un número: ");

        num = new int[n];

        Arrays.fill(num, m);

        System.out.println();
        System.out.println(Arrays.toString(num));
    }

    public static void Ejercicio7() {
        /*
        Crea un programa que pida dos valores enteros P y Q, luego cree un array que
        contenga todos los valores desde P hasta Q, y lo muestre por pantalla.
         */

        int[] num;
        int p = 0, q = 0, tamano, menor;

        p = PideInt("Introduce un número: ");

        q = PideInt("Introduce un otro número: ");

        if (p < q) {
            tamano = (q - p) + 1;
        } else if (p > q) {
            tamano = (p - q) + 1;
        } else {
            tamano = 1;
        }

        menor = Math.min(p, q);

        num = new int[tamano];

        num[0] = menor;

        for (int i = 1; i < num.length; i++) {
            num[i] = num[i-1] + 1;
        }

        System.out.println();
        System.out.println(Arrays.toString(num));
    }

    public static void Ejercicio8() {
        /*
        Crea un programa que cree un array con 100 números reales aleatorios entre 0.0
        y 1.0, utilizando Math.random(), y luego le pida al usuario un valor real R. Por
        último, mostrará cuántos valores del array son igual o superiores a R.
         */

        double[] num = new double[100];
        double numUser = 0.0;
        int count = 0;

        numUser = PideDoubleMinMax(0, 1);

        for (int i = 0; i < num.length; i++) {
            num[i] = Math.random();
            if (numUser <= num[i]) {
                count++;
            }
        }

        System.out.println(count + " valores del array son igual o superiores a " + numUser);
    }

    public static void Ejercicio9() {
        /*
        Crea un programa que cree un array de enteros de tamaño 100 y lo rellene con
        valores enteros aleatorios entre 1 y 10 (utiliza 1 + Math.random()*10). Luego
        pedirá un valor N y mostrará en qué posiciones del array aparece N.
         */

        int[] num = new int[100], posiciones;
        int numUser = 0, tamano = 0;

        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (1 + Math.random() * 10);
        }

        numUser = PideIntMinMax(1, 10, "");

        System.out.println();

        for (int j : num) {
            if (numUser == j) {
                tamano++;
            }
        }

        posiciones = new int[tamano];

        tamano = 0;

        for (int i = 0; i < num.length; i++) {
            if (numUser == num[i]) {
                posiciones[tamano] = i;
                tamano++;
            }
        }

        System.out.println("El número introducido se encuentra en las posiciones del array " + Arrays.toString(posiciones));

    }

    public static void Ejercicio10() {
        /*
        Crea un programa para realizar cálculos relacionados con la altura (en metros)
        de personas. Pedirá un valor N y luego almacenará en un array N alturas
        introducidas por teclado. Luego mostrará la altura media, máxima y mínima, así
        como cuántas personas miden por encima y por debajo de la media.
         */

        double[] num;
        int tamano;
        double media = 0.0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        tamano = PideInt("Introduce la cantidad de alturas que quieres introducir: ");

        num = new double[tamano];

        for (int i = 0; i < num.length; i++) {
            num[i] = PideDouble("Introduce la altura: ");
        }

        for (double v : num) {
            media += v;
        }

        media /= num.length;

        for (double v : num) {
            if (v > max && v < min) {
                max = v;
                min = v;
            }else if (v > max){
                max = v;
            } else if (v < min){
                min = v;
            }
        }

        System.out.println();
        System.out.println("La media de las alturas introducidas es: " + String.format("%.2f", media));
        System.out.println("La altura más alta es: " + max);
        System.out.println("La altura más pequeño es: " + min);
    }

    public static void Ejercicio11() {
        /*
        Crea un programa que cree dos arrays de enteros de tamaño 100. Luego
        introducirá en el primer array todos los valores del 1 al 100. Por último, deberá
        copiar todos los valores del primer array al segundo array en orden inverso, y
        mostrar ambos por pantalla.
         */

        int[] num1 = new int[100], num2 = new int[100];

        num1[0] = 1;


        for (int i = 1; i < num1.length; i++) {
            num1[i] = num1[i-1] +1;
        }

        for (int j = num1.length -1; j >= 0; j--) {
            num2[j] = num1[(num1.length - 1) - j];
        }

        System.out.println("Array1: " + Arrays.toString(num1));
        System.out.println("Array2: " + Arrays.toString(num2));
    }

    public static void Ejercicio12() {
        /*
        Crea un programa que cree un array de 10 enteros y luego muestre el siguiente
        menú con distintas opciones:
            a. Mostrar valores.
            b. Introducir valor.
            c. Salir.
        La opción ‘a’ mostrará todos los valores por pantalla. La opción ‘b’ pedirá un
        valor V y una posición P, luego escribirá V en la posición P del array. El menú
        se repetirá indefinidamente hasta que el usuario elija la opción ‘c’ que
        terminará el programa.
         */

        int[] num = new int[10];
        String option = "";
        int v = 0, p = 0;

        do {
            System.out.println("Elige una opción:");
            System.out.println("\ta. Mostrar valores.");
            System.out.println("\tb. Introducir valor.");
            System.out.println("\tc. Salir.");
            option = sc.next();
            while (!option.equals("a") && !option.equals("b") && !option.equals("c")){
                System.out.println("Opción no valida vuelve a introducir");
                option = sc.next();
            }

            System.out.println();

            if (option.equals("a")) {
                System.out.println(Arrays.toString(num));
            } else if (option.equals("b")){
                p = PideIntMinMax(1, 10, "Elige la posición que desea reemplazar: ");
                v = PideInt("Introduce el valor que deas introducir: ");
                num[p-1] = v;
            } else {
                System.out.println("Adios!!");
            }
            System.out.println();
        } while (!option.equals("c"));
    }

    public static void Ejercicio13() {
        /*
        Crea un programa que permita al usuario almacenar una secuencia aritmética en
        un array y luego mostrarla. Una secuencia aritmética es una serie de números
        que comienza por un valor inicial V, y continúa con incrementos de I. Por
        ejemplo, con V=1 e I=2, la secuencia sería 1, 3, 5, 7, 9… Con V=7 e I=10, la
        secuencia sería 7, 17, 27, 37… El programa solicitará al usuario V, I además de N
        (nº de valores a crear).
         */

        int[] num;
        int v = 0, i = 0, n = 0;

        v = PideInt("Introduce el valor inicial: ");
        i = PideInt("Introduce el incremento: ");
        n = PideInt("Introduce el Nº de valores a crear: ");

        num = new int[n];

        num[0] = v;

        for (int j = 1; j < num.length; j++) {
            num[j] = num[j - 1] + i;
        }

        System.out.println();
        System.out.println("La secuencia aritmética es: " + Arrays.toString(num));
    }

    public static void Ejercicio14() {
        /*
         Crea un programa que cree un array de enteros e introduzca la siguiente
        secuencia de valores: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, etc. hasta introducir 10
        diez veces, y luego la muestre por pantalla.
         */

        int[] num = new int[55];
        int count = 0;

        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j < i; j++) {
                num[count] = i;
                count++;
            }
        }

        System.out.println(Arrays.toString(num));

    }

    public static void Ejercicio15() {
        /*
        Crea un programa que pida al usuario dos valores N y M y luego cree un array de
        tamaño N que contenga M en todas sus posiciones. Luego muestra el array por
        pantalla.
         */

        int[] num;
        int n = 0, m = 0;

        n = PideInt("Introduce el tamaño del array: ");

        m = PideInt("Introduce un número: ");

        num = new int[n];

        Arrays.fill(num, m);

        System.out.println();
        System.out.println(Arrays.toString(num));
    }

    public static void Ejercicio16() {
        /*
        Crea un programa que cree un array de enteros e introduzca la siguiente
        secuencia de valores: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, etc. hasta introducir 10
        diez veces, y luego la muestre por pantalla. En esta ocasión has de utilizar
        Arrays.fill().
         */

        int[] num = new int[55];
        int position = 0, positiontofill = 0;

        for (int i = 0; i < 10; i++) {
            positiontofill += i+1;
            Arrays.fill(num, position, positiontofill, i+1);
            position = positiontofill;
        }

        System.out.println(Arrays.toString(num));
    }

    public static void Ejercicio17() {
        /*
        Crea un programa que pida al usuario 20 valores enteros e introduzca los 10
        primeros en un array y los 10 últimos en otro array. Por último, comparará ambos
        arrays y le dirá al usuario si son iguales o no.
         */

        int[] num = new int[10], num1 = new int[10];

        for (int i = 0; i < num.length; i++) {
            num[i] = PideInt("Introduce un número: ");
        }

        for (int i = 0; i < num1.length; i++) {
            num1[i] = PideInt("Introduce un número: ");
        }

        if (Arrays.equals(num, num1)) {
            System.out.println("Los 10 primero valores son iguales a los 10 últimos valores");
        } else {
            System.out.println("Los 10 primero valores no son iguales a los 10 últimos valores");
        }

    }

    public static void Ejercicio18() {
        /*
        Crea un programa que cree un array de tamaño 30 y lo rellene con valores
        aleatorios entre 0 y 9 (utiliza Math.random()*10). Luego ordena los valores del
        array y los mostrará por pantalla.
         */

        int[] num = new int[30];

        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random() * 10);
        }

        Arrays.sort(num);

        System.out.println(Arrays.toString(num));
    }

    public static void Ejercicio19() {
        /*
        Necesitamos crear un programa para mostrar el ranking de puntuaciones de un
        torneo de ajedrez con 8 jugadores. Se le pedirá al usuario que introduzca las
        puntuaciones de todos los jugadores (habitualmente valores entre 1000 y 2800,
        de tipo entero) y luego muestre las puntuaciones en orden descendente (de la
        más alta a la más baja)
         */

        int[] num = new int[8], numcopy;
        String text = "";

        for (int i = 0; i < num.length; i++) {
            text = "El jugador N.º" + (i + 1) + " introduce tu puntuación (1000-2800): ";
            num[i] = PideIntMinMax(1000, 2800, text);
        }

        numcopy = Arrays.copyOf(num, num.length);

        Arrays.sort(num);

        System.out.println();

        System.out.println("Ranking:");
        for (int i = (num.length - 1); i >= 0; i--) {
            for (int j = 0; j < numcopy.length; j++) {
                if (num[i] == numcopy[j]){
                    System.out.println("\t" + (num.length - i) + "º Jugador " + (j + 1) + " con " + num[i] + " puntos");
                }
            }
        }
    }

    public static void Ejercicio20() {
        /*
        Crea un programa que cree un array de tamaño 1000 y lo rellene con valores
        enteros aleatorios entre 0 y 99 (utiliza Math.random()*100). Luego pedirá por
        teclado un valor N y se mostrará por pantalla si N existe en el array, además de
        cuantas veces
         */

        int[] num = new int[1000];
        int numUser = 0, count = 0;

        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random() * 100);
        }

        numUser = PideIntMinMax(0, 99, "");

        for (int j : num) {
            if (j == numUser) {
                count++;
            }
        }

        if (count != 0) {
            System.out.println();
            System.out.println(numUser + " si existe en el array, aparece " + count + " veces.");
        }
    }

}