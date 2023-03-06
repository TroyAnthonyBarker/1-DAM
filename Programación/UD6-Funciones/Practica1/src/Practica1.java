import java.util.Arrays;
import java.util.Scanner;

public class Practica1 {

    static Scanner sc;

    public static void main(String[] args) {
        Utilidades.sca = new Scanner(System.in);
        sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println();
            opcion = Utilidades.pideIntMinMax(0, 16, "Elije un ejercicio entre 1-16 (0 para salir): ");

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
            case 9 -> {
                ejercicio9();
            }
            case 10 -> {
                ejercicio10();
            }
            case 11 -> {
                ejercicio11();
            }
            case 12 -> {
                ejercicio12();
            }
            case 13 -> {
                ejercicio13();
            }
            case 14 -> {
                ejercicio14();
            }
            case 15 -> {
                ejercicio15();
            }
            case 16 -> {
                ejercicio16();
            }
        }
    }

    private static void ejercicio16() {
        /*
        Escribe un programa que cree un array del tamaño indicado por teclado y luego
        lo rellene con valores aleatorios (utiliza Math.random()). Implementa la función
        que rellena un array con valores aleatorios
         */
        int length = Utilidades.pideInt("Introduce el tamaño del array: ");

        System.out.println(Arrays.toString(arrayAleatorio(length)));
    }

    static double[] arrayAleatorio(int length) {
        double [] arrayAleatorio = new double[length];
        for (int i = 0; i < arrayAleatorio.length; i++) {
            arrayAleatorio[i] = Math.random();
        }
        return arrayAleatorio;
    }

    private static void ejercicio15() {
        /*
        Escribe un programa que cree un array de tamaño 100 con los primeros 100
        números naturales. Luego muestra la suma total y la media. Implementa una
        función que calcule la suma de un array y otra que calcule la media de un array
         */
        int[] arrays = new int[100];

        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = i+1;
        }
        System.out.println("La suma del array es: " + sumaArrays(arrays));
        System.out.println("La media del array es: " + mediaArrays(arrays));
    }

    static int sumaArrays(int[] arrays) {
        int suma = 0;
        for (int array : arrays) {
            suma += array;
        }
        return suma;
    }

    static double mediaArrays(int[] arrays) {
        return (double) sumaArrays(arrays)/arrays.length;
    }

    private static void ejercicio14() {
        /*
        Escribe una función que muestre por pantalla un triángulo como el del ejemplo.
        Deberá recibir dos parámetros: el carácter que se desea imprimir y el número de
        líneas del triángulo.
         */
        String caracter = "";
        int numLineas = 0;

        System.out.print("Introduce el caracter que desea para el triangulo: ");
        caracter = sc.nextLine();
        while (caracter.length() != 1) {
            System.out.println("Mas de un caracter introducido, vuelve a introducir");
            caracter = sc.nextLine();
        }

        numLineas = Utilidades.pideInt("Introduce el número de lineas: ");

        triangulo(caracter, numLineas);
    }

    static void triangulo (String caracter, int lineas) {
        int numLine = lineas;
        String formato, lineaTriangulo = caracter;

        for (int i = 0; i < lineas; i++) {
            formato = "%" + numLine + "s" + "%n";
            System.out.printf(formato, lineaTriangulo);
            lineaTriangulo += "" + caracter + caracter;
            numLine += 1;
        }
    }

    private static void ejercicio13() {
        /*
        Realiza un programa que calcule el porcentaje de descuento que nos han hecho
        al comprar algo. Se debe solicitar la cantidad sin descuento y la cantidad con el
        descuento aplicado. Se debe crear una función a la que le pasemos ambos
        valores y nos devuelva el descuento.
         */
        double precio_sin_Descuento = Utilidades.pideDouble("Introduce el precio del producto sin descuento: ");
        double precio_con_Descuento = Utilidades.pideDouble("Introduce el precio del producto con descuento: ");
        System.out.println("El descuento aplicado es de " + String.format("%.2f", descuentoAplicado(precio_sin_Descuento, precio_con_Descuento)) + "%");
    }

    static double descuentoAplicado(double precio_sin_Descuento, double precio_con_Descuento) {
        return (precio_sin_Descuento * precio_con_Descuento)/100;
    }

    private static void ejercicio12() {
        /*
        Realiza un programa que dado un valor en kilómetros nos lo traduce a millas. El
        programa debe tener una función que reciba como parámetro una cantidad en
        kilómetros y nos la devuelva en millas.
         */
        double km = Utilidades.pideDouble("Introduce los kilometros que desea saber en millas: ");
        System.out.println(km + "km son " + String.format("%.2f", kilometros_a_millas(km)) + " en millas");
    }

    static double kilometros_a_millas(double km) {// Devuelve la conversión de millas a kilómetros
        return km / 1.60934;
    }

    private static void ejercicio11() {
        /*
        Realiza un programa que escriba la tabla de multiplicar de un número
        introducido por teclado. Para ello implementa una función que reciba como
        parámetro un número entero y muestre por pantalla la tabla de multiplicar de
        dicho número.
         */
        int num = Utilidades.pideInt("Introduce el número que desea saber la tabla de multiplicar: ");
        System.out.println("La tabla de multiplicar de " + num + " es: " + tablaMultiplicar(num));
    }

    static String tablaMultiplicar(int a) {
        int[] tabla = new int[10];
        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = (i + 1) * a;
        }
        return Arrays.toString(tabla);
    }

    private static void ejercicio10() {
        /*
        Realiza un programa que lea una fecha introduciendo el día, mes y año por
        separado y nos diga si la fecha es correcta o no. Supondremos que todos los
        meses tienen 30 días. Se debe crear una función donde le pasemos los datos y
        devuelva si es correcta o no.
         */
        int dia = Utilidades.pideInt("Introduce el día: ");
        int mes = Utilidades.pideInt("Introduce el mes: ");
        int ano = Utilidades.pideInt("Introduce el año: ");

        validaFecha(dia, mes, ano);
    }

    static void validaFecha(int dia, int mes, int ano) {
        if (validaDia(dia)) {
            if (validaMes(mes)){
                if (validaAno(ano)){
                    System.out.println("Fecha correcta");
                } else {
                    System.out.println("Año incorrecto");
                }
            } else if (validaAno(ano)){
                System.out.println("Mes incorrecto");
            } else {
                System.out.println("Mes y año incorrecto");
            }
        } else if (validaMes(mes)) {
            if (validaAno(ano)){
                System.out.println("Día incorrecto");
            } else {
                System.out.println("Año y día incorrecto");
            }
        } else if (validaAno(ano)){
            if (validaMes(mes)){
                System.out.println("Día incorrecto");
            } else {
                System.out.println("Mes y día incorrecto");
            }
        } else {
            System.out.println("Año, mes y día incorrecto");
        }
    }

    static boolean validaDia(int a) {
        return a > 0 && a < 31;
    }
    static boolean validaMes(int a) {
        return a > 0 && a < 13;
    }
    static boolean validaAno(int a){
        return a > 0;
    }

    private static void ejercicio9() {
        /*
        Realiza un programa que pida introducir tres valores enteros y nos diga cuál de
        ellos es el más elevado. Impleméntalo creando únicamente una función a la que
        le pasemos dos valores (no tres) y nos devuelva el máximo de los dos valores.
         */
        int num1 = Utilidades.pideInt("Introduce un número: ");
        int num2 = Utilidades.pideInt("Introduce otro número: ");
        int num3 = Utilidades.pideInt("Introduce otro número: ");
        int maximo = maximo(maximo(num1, num2), num3);

        System.out.println("El número más elevado es: " + maximo);
    }

    static int maximo(int a, int b) {
        return Math.max(a, b);
    }

    private static void ejercicio8() {
        /*
        Escribe un programa que pida un valor N entero y luego muestre: el sumatorio
        desde 1 a N, el productorio de 1 a N y el valor intermedio entre 1 y N. Implementa
        y utiliza las funciones:
            int suma1aN(int n) // Devuelve la suma de enteros de 1 a n
            int producto1aN(int n) // Devuelve el producto de enteros de 1 a n
            double intermedio1aN(int n) // Devuelve el valor intermedio entre 1 y n
         */
        int num = Utilidades.pideInt("Introduce un número: ");
        int sumatorio = suma1aN(num), productorio = producto1aN(num);
        double intermedio = intermedio1aN(num);

        System.out.println("El sumatorio de " + num + " es: " + sumatorio);
        System.out.println("El productorio de " + num + " es: " + productorio);
        System.out.println("El intermedio de " + num + " es: " + intermedio);
    }

    static int suma1aN(int n) {// Devuelve la suma de enteros de 1 a n
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i;
        }
        return suma;
    }

    static int producto1aN(int n) {// Devuelve el producto de enteros de 1 a n
        int producto = 1;
        for (int i = 1; i <= n; i++) {
            producto *= i;
        }
        return producto;
    }

    static double intermedio1aN(int n) {// Devuelve el valor intermedio entre 1 y n
        return (double) n/2;
    }

    private static void ejercicio7() {
        /*
        Escribe un programa que pida el ancho y alto de un rectángulo y muestre por
        pantalla su área y su perímetro. Implementa y utiliza las funciones:
            double perimetroRectangulo(double ancho, double alto) // Devuelve el perímetro
            double areaRectangulo(double ancho, double alto) // Devuelve el área
         */
        double alto = Utilidades.pideDouble("Introduce la altura del rectángulo: ");
        double ancho = Utilidades.pideDouble("Introduce la anchura del rectángulo: ");

        System.out.println("El perimetro del rectángulo es: " + perimetroRectangulo(ancho, alto));
        System.out.println("El area del rectángulo es: " + areaRectangulo(ancho, alto));
    }

    static double perimetroRectangulo(double ancho, double alto) { // Devuelve el perímetro
        return (ancho * 2) + (alto * 2);
    }

    static double areaRectangulo(double ancho, double alto) {// Devuelve el área
        return ancho * alto;
    }

    private static void ejercicio6() {
        /*
        Escribe un programa que pida cinco precios y muestre por pantalla el precio de
        venta de cada uno tras aplicarle un 21% de IVA. Implementa y utiliza la función:
            double precioConIVA(double precio) // Devuelve el precio tras sumarle un 21% de IVA
         */

        double[] producto = new double[5];

        for (int i = 0; i < producto.length; i++) {
            String text = "Precio del " + (i+1) + "º producto: ";
            producto[i] = precioConIVA(Utilidades.pideDouble(text));
        }

        System.out.println();
        System.out.println("Precios con iva: ");

        for (int i = 0; i < producto.length; i++) {
            System.out.println("\tPrecio del " + (i+1) + "º producto: " + String.format("%.2f", producto[i]) + "€");
        }
    }

    static double precioConIVA(double precio) {// Devuelve el precio tras sumarle un 21% de IVA
        double iva = (precio*21)/100;
        return precio + iva;
    }

    private static void ejercicio5() {
        /*
        Escribe un programa que pida un valor entero en millas y muestre su equivalente
        en kilómetros. Recuerda que una milla son 1,60934 kilómetros. Implementa y
        utiliza la función:
            double millas_a_kilometros(int millas) // Devuelve la conversión de millas a kilómetros
         */
        double km = 0.0;
        int millas = Utilidades.pideInt("Introduce millas: ");
        km = millas_a_kilometros(millas);
        System.out.println(millas + " son " + km + "km");
    }

    static double millas_a_kilometros(int millas) {// Devuelve la conversión de millas a kilómetros
        return millas * 1.60934;
    }

    private static void ejercicio4() {
        /*
        Escribe un programa que pida un número entero por teclado y muestre por
        pantalla si es positivo, negativo o cero. Implementa y utiliza la función:
            int dimeSigno(int a) // Devuelve -1 si es negativo, 0 si es igual a 0, 1 si es positivo
        */
        int num = dimeSigno(Utilidades.pideInt("Introduce un número: "));

        if (num == 0) {
            System.out.println("Es cero");
        } else if (num == -1) {
            System.out.println("Es negativo");
        } else {
            System.out.println("Es positivo");
        }
    }

    static int dimeSigno(int a) {// Devuelve -1 si es negativo, 0 si es igual a 0, 1 si es positivo
        if (a > 0) {
            return 1;
        } else if (a < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    private static void ejercicio3() {
        /*
        Escribe un programa que pida dos números enteros por teclado y muestre por
        pantalla cual es el mínimo. Implementa y utiliza la función
           int minimo(int a, int b) // Devuelve el menor entre a y b
         */
        int num1 = 0, num2 = 0;

        num1 = Utilidades.pideInt("Introduce un número: ");
        num2 = Utilidades.pideInt("Introduce otro número: ");
        System.out.println("El mínimo es: " + minimo(num1, num2));

    }

    static int minimo(int a, int b) {
        return Math.min(a, b);
    }

    private static void ejercicio2() {
        /*
        Escribe un programa que pida la edad por teclado y muestre por pantalla si eres
        mayor de edad o no. Implementa y utiliza la función
            boolean esMayorEdad(int a) // Devuelve verdadero si a>=18, falso en caso contrario
         */
        int edad = 0;

        edad = Utilidades.pideInt("Introduce tu edad: ");

        if (esMayorEdad(edad)) {
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }
    }

    static boolean esMayorEdad(int a) { // Devuelve verdadero si a>=18, falso en caso contrario
        return a >= 18;
    }

    public static void ejercicio1() {
        /*
        Escribe un programa que pida dos números reales por teclado y muestre por
        pantalla el resultado de multiplicarlos. Implementa y utiliza la función:
            double multiplica(double a, double b) // Devuelve la multiplicación de dos números
         */
        double a, b, result;
        a = Utilidades.pideDouble("Introduce el primer número que desea multiplicar: ");
        b = Utilidades.pideDouble("Introduce el segundo número que desea multiplicar: ");
        result = multiplica(a, b);
        System.out.println("El resutlado de " + a + " * " + b + " es: " + result);
    }

    static double multiplica (double a, double b) {
        return a*b;
    }

}