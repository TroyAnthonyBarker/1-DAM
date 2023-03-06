import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int opcion = 0;
        boolean salir = false;

        do {
            System.out.println();
            menu();
            System.out.print("Introduce una opción (Cualquier otra tecla para salir): ");
            try {
                opcion = sc.nextInt();
                System.out.println();
                acion(opcion);
            } catch (InputMismatchException e) {
                System.out.println("\nAdíos!!");
                salir = true;
            }
        } while (!salir);
    }

    static void acion(int op) {
        switch (op){
            case 1 -> ejercicio1();
            case 2 -> ejercicio2();
            case 3 -> ejercicio3();
            case 4 -> ejercicio4();
            case 5 -> ejercicio5();
        }
    }

    static void menu(){
        System.out.println("""
                1. Ejercicio 1
                2. Ejercicio 2
                3. Ejercicio 3
                4. Ejercicio 4
                5. Ejercicio 5
                """);
    }

    static void ejercicio1(){
        int valor;
        System.out.print("Introduce un valor entero: ");
        try{
            valor = sc.nextInt();
            sc.nextLine();
            System.out.println("Valor introducido: " + valor);
        } catch (InputMismatchException e) {
            System.err.println("Valor introducido incorrecto");
        }
    }

    static void ejercicio2(){
        int valorA, valorB;
        double div;
        try{
            System.out.print("Introduce un valor entero: ");
            valorA = sc.nextInt();
            sc.nextLine();
            System.out.print("Introduce un valor entero: ");
            valorB = sc.nextInt();
            sc.nextLine();
            div = valorA/valorB; 
        } catch (InputMismatchException e) {
            System.err.println("Valor introducido incorrecto");
        } catch (ArithmeticException e) {
            System.err.println("Error a la hora de dividir");
        }
    }

    static void ejercicio3(){
        double[] vector = new double[5];
            for (int i = 0; i < vector.length; i++) {
                boolean ok = false;
                do {
                    try {
                        System.out.print("Introduce un número: ");
                        vector[i] = sc.nextInt();
                        sc.nextLine();
                        ok = true;
                    } catch (InputMismatchException e) {
                        sc.nextLine();
                        System.err.println("Input no valido, vuelve a introducir");
                    }
                }while (!ok);
            }
        System.out.println(Arrays.toString(vector));
    }

    static void ejercicio4(){
        int numAleatorio = (int) (Math.random() * 100 + (1));
        int[] vector = new int[numAleatorio];
        for (int i = 0; i < vector.length; i++) {
            numAleatorio = (int) (Math.random() * 10 + (1));
            vector[i] = numAleatorio;
        }
        int opcion = 0;
        do {
            try {
                System.out.println("¿Qué posición del vector deseas visualizar? (Número negativo para salir)");
                opcion = sc.nextInt();
                System.out.println("Valor: "+vector[opcion]);
            }catch (InputMismatchException e){
                sc.nextLine();
                System.err.println("Posición invalida");
                opcion = 0;
            }catch (ArrayIndexOutOfBoundsException e) {
                sc.nextLine();
                if (opcion >= 0) System.err.println("Posición no existe");
            }
        }while (opcion >= 0);
    }

    static void ejercicio5(){
        int num, opcion;
        boolean salir = false, ok = false;
        num = pideNumero();
        do {
            try {
                System.out.println("Elige una opción: \n1. Ver número positivo \n2. Ver número negativo \n3. Introducir número");
                System.out.print("Opción (Cualquier otra tecla para salir): ");
                opcion = sc.nextInt();
                switch (opcion){
                    case 1 -> imprimePositivo(num);
                    case 2 -> imprimeNegativo(num);
                    case 3 -> num = pideNumero();
                }
            } catch (InputMismatchException e){
                salir = true;
            } catch (InvalidPositivoException | InvalidNegativoException e) {
                e.printStackTrace();
            }

        } while (!salir);
    }

    static int pideNumero(){
        int num = 0;
        boolean ok = false;
        do {
            System.out.print("Introduce un número: ");
            try {
                num = sc.nextInt();
                sc.nextLine();
                ok = true;
            }catch (InputMismatchException e) {
                sc.nextLine();
                System.err.println("Número erróneo");
            }
        } while (!ok);
        return num;
    }

    static void imprimePositivo(int p) throws InvalidPositivoException{
        if (p < 0) throw new InvalidPositivoException("Número es negativo");
        System.out.println(p);
    }

    static void imprimeNegativo(int n) throws InvalidNegativoException{
        if (n >= 0) throw new InvalidNegativoException("Número es positivo");
        System.out.println(n);
    }
}
