import java.util.Arrays;
import java.util.Scanner;

public class Practica3 {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int opcion = 1;

        do {
            opcion = PideIntMinMax(0, 5, "Elige un Ejercicio entre 1 y 5 (0 para salir): ");
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
        sc.nextLine();
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
        sc.nextLine();
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
        }
    }

    public static void Ejercicio1() {
        /*
        Crea un programa que cree una matriz de tamaño 5x5 que almacene los números
        del 1 al 25 y luego muestre la matriz por pantalla.
         */

        int[][] matriz = new int[5][5];
        int count = 1;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = count;
                count++;
            }
        }

        for (int[] ints : matriz) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public static void Ejercicio2() {
        /*
        Crea un programa que cree una matriz de 10x10 e introduzca los valores de las tablas
        de multiplicar del 1 al 10 (cada tabla en una fila). Luego mostrará la matriz por
        pantalla.
         */

        int[][] matriz = new int[10][10];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (i+1) * (j+1);
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Tabla del " + (i+1) + " es: " + Arrays.toString(matriz[i]));
        }
    }

    public static void Ejercicio3() {
        /*
        Crea un programa que cree una matriz de tamaño NxM (tamaño introducido por
        teclado) e introduzca en ella NxM valores (también introducidos por teclado). Luego
        deberá recorrer la matriz y al final mostrar por pantalla cuántos valores son mayores
        que cero, cuántos son menores que cero y cuántos son igual a cero
         */

        int[][] matriz;
        int columnas = 0, filas = 0, mayor = 0, igual = 0, menor = 0;

        columnas = PideInt("Introduce las columnas que desea: ");
        filas = PideInt("Introduce las filas que desea: ");

        matriz = new int[columnas][filas];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = PideInt("Introduce un número: ");
                if (matriz[i][j] < 0) {
                    menor++;
                } else if (matriz[i][j] > 0) {
                    mayor++;
                } else {
                    igual++;
                }
            }
        }

        System.out.println();

        System.out.println("Hay " + mayor + " números mayores que 0");
        System.out.println("Hay " + menor + " números menores que 0");
        System.out.println("Hay " + igual + " números iguales que 0");
    }

    public static void Ejercicio4() {
        /*
        Necesitamos crear un programa para almacenar las notas de 4 alumnos (llamados
        “Alumno 1”, “Alumno 2”, etc.) y 5 asignaturas. El usuario introducirá las notas por
        teclado y luego el programa mostrará la nota mínima, máxima y media de cada
        alumno.
         */

        double[][] matriz = new double[4][5];
        double media = 0, suma = 0, cantidad = 0, nota = 0.0;

        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Alumno N.º" + (i+1) + ":");
            for (int j = 0; j < matriz[i].length; j++) {
                String texto = "Introduce tu nota de la " + (j+1) + " asignatura: ";
                nota = PideDoubleMinMax(0, 10, texto);
                matriz[i][j] = nota;
            }
            System.out.println();
        }

        for (int i = 0; i < matriz.length; i++) {
            double max = Double.MIN_VALUE, min = Double.MAX_VALUE;
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > max && matriz[i][j] < min) {
                    max = matriz[i][j];
                    min = matriz[i][j];
                } else if (matriz[i][j] > max) {
                    max = matriz[i][j];
                } else if (matriz[i][j] < min) {
                    min = matriz[i][j];
                }
            }

            suma = matriz[i][0];

            for (int j = 1; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }

            cantidad = matriz[i].length;

            media = suma/cantidad;

            System.out.println("Alumno N.º" + (i+1) + ":");
            System.out.println("\tMáxima: " + max);
            System.out.println("\tMínima: " + min);
            System.out.println("\tMedia: " + String.format("%.2f", media));
            System.out.println();
        }
    }

    public static void Ejercicio5() {
        /*
        Necesitamos crear un programa para registrar sueldos de hombres y mujeres de una
        empresa y detectar si existe brecha salarial entre ambos. El programa pedirá por
        teclado la información de N personas distintas (valor también introducido por
        teclado). Para cada persona, pedirá su género (0 para varón y 1 para mujer) y su
        sueldo. Esta información debe guardarse en una única matriz. Luego se mostrará por
        pantalla el sueldo medio de cada género.
         */

        int persona = 0, hombre = 0, mujer = 0, salarioH = 0, salarioM = 0, mediaM = 0, mediaH = 0;
        int[][] matriz; //1genero, 2sueldo

        persona = PideInt("Introduce el Nº de personas: ");

        matriz = new int[persona][2];

        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Persona N.º" + (i+1) + ":");
            matriz[i][0] = PideIntMinMax(0, 1, "\tIntroduce tu genero (0 para varón y 1 para mujer): ");
            matriz[i][1] = PideInt("\tIntroduce tu salario: ");
            System.out.println();
        }

        for (int[] ints : matriz) {
            if (ints[0] == 0) {
                hombre++;
                salarioH += ints[1];
            } else {
                mujer++;
                salarioM += ints[1];
            }
        }



        mediaM = salarioM/mujer;

        mediaH = salarioH/hombre;

        System.out.println("Nº de personas: " + persona);
        System.out.println("Mujeres:");
        System.out.println("\tTrabajadoras: " + mujer);
        System.out.println("\tMedia de Salario: " + mediaM);
        System.out.println("Varones:");
        System.out.println("\tTrabajadores: " + hombre);
        System.out.println("\tMedia de Salario: " + mediaH);
    }
}