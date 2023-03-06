import java.text.DecimalFormat;
import java.util.Scanner;

public class Practica2 {
    static Scanner sc;
    static DecimalFormat formamil;
    public static void main(String[] args) {


        sc = new Scanner(System.in);
        formamil = new DecimalFormat("###,###");

        SeleccionEjercicio();
    }

        public static void SeleccionEjercicio() {
            int opcion;
            do {
                System.out.println();
                System.out.println("Elige un ejercicio entre 1-14");
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
                    }
                    case 2 -> {
                        System.out.println("Has elegido el ejercicio " + opcion);
                        Ejercicio2();
                    }
                    case 3 -> {
                        System.out.println("Has elegido el ejercicio " + opcion);
                        Ejercicio3();
                    }
                    case 4 -> {
                        System.out.println("Has elegido el ejercicio " + opcion);
                        Ejercicio4();
                    }
                    case 5 -> {
                        System.out.println("Has elegido el ejercicio " + opcion);
                        Ejercicio5();
                    }
                    case 6 -> {
                        System.out.println("Has elegido el ejercicio " + opcion);
                        Ejercicio6();
                    }
                    case 7 -> {
                        System.out.println("Has elegido el ejercicio " + opcion);
                        Ejercicio7();
                    }
                    case 8 -> {
                        System.out.println("Has elegido el ejercicio " + opcion);
                        Ejercicio8();
                    }
                    case 9 -> {
                        System.out.println("Has elegido el ejercicio " + opcion);
                        Ejercicio9();
                    }
                case 10 -> {
                    System.out.println("Has elegido el ejercicio " + opcion);
                    Ejercicio10();
                }
                case 11 -> {
                    System.out.println("Has elegido el ejercicio " + opcion);
                    Ejercicio11();
                }
                case 12 -> {
                    System.out.println("Has elegido el ejercicio " + opcion);
                    Ejercicio12();
                }
                case 13 -> {
                    System.out.println("Has elegido el ejercicio " + opcion);
                    Ejercicio13();
                }
                case 14 -> {
                    System.out.println("Has elegido el ejercicio " + opcion);
                    Ejercicio14();
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

        public static void testDouble() {
            while (!sc.hasNextDouble()) {
                System.out.println("Eso no es un número valido!");
                sc.next(); // IMPORTANTE!
            }
        }

        public static void Ejercicio1() {
        /*
        Realiza un programa que muestre por pantalla los 20 primeros números naturales (1, 2, 3... 20).
         */

            /*ALGORITMO*/
            //Muestra los primeros 20 números naturales
            for (int i = 1; i <= 20; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        public static void Ejercicio2() {
        /*
        Realiza un programa que muestre los números pares comprendidos entre el 1 y el 200.
        Para ello utiliza un contador y suma de 2 en 2
         */

            /*ALGORITMO*/
            for (int i = 2; i <= 200 ; i+= 2) {
                System.out.println(i);
            }
            System.out.println();
        }

        public static void Ejercicio3() {
        /*
        Realiza un programa que muestre los números pares comprendidos entre el 1 y el 200.
        Esta vez utiliza un contador sumando de 1 en 1.
         */
            /*ALGORITMO*/
            for (int i = 2; i <= 200 ; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
            System.out.println();

        }

        public static void Ejercicio4() {
        /*
        Realiza un programa que muestre los números desde el 1 hasta un número N que se introducirá por teclado.
         */

            /*Datos*/
            int numMax = 0;

            /*ALGORITMO*/
            //Pide el número máximo
            System.out.print("Introduce el número máximo: ");
            testInt();
            numMax = sc.nextInt();

            for (int i = 1; i <= numMax ; i++) {
                System.out.println(i);
            }
            System.out.println();
        }

        public static void Ejercicio5() {
        /*
        Realiza un programa que lea un número positivo N y calcule y visualice su factorial N!
             Siendo el factorial:
             0! = 1
             1! = 1
             2! = 2 * 1
             3! = 3 * 2* 1
             N! = N * (N-1) * (N-2)........* 3*2*1
         */

            /*DATOS*/
            int numMax = 0, numFactorial = 1;

            /*ALGORITMO*/
            //Pide N por pantalla
            System.out.print("Introduce un número para calcular su factorial: ");
            testInt();
            numMax = sc.nextInt();

            //Operaciones
            for (int i = 1; i <= numMax ; i++) {
                numFactorial = i * numFactorial;
            }
            System.out.println(numMax + "! = " + formamil.format(numFactorial));
        }

        public static void Ejercicio6() {
        /*
        Realiza un programa que lea 10 números no nulos y luego muestre un mensaje de si ha
        leído algún número negativo o no.
         */

            /*Datos*/
            int count = 0, nPositivos = 0, nNegativos = 0;

            /*ALGORITMO*/
            System.out.println("Introduce 10 números no nulos");
            for (int i = 1; i <= 10 ; i++) {
                System.out.print(i + ": ");
                testInt();
                count = sc.nextInt();
                if (count >= 0) {
                    nPositivos++;
                } else {
                    nNegativos++;
                }
            }
            if (nNegativos > 0) {
                System.out.println("Se han leído números negativos");
            } else {
                System.out.println("No se han leído número negativos");
            }
        }

        public static void Ejercicio7() {
        /*
        Realiza un programa que lea 10 números no nulos y luego muestre un mensaje
        indicando cuántos son positivos y cuantos negativos.
         */
            /*Datos*/
            int count = 0, nPositivos = 0, nNegativos = 0;

            /*ALGORITMO*/
            System.out.println("Introduce 10 números no nulos");
            for (int i = 1; i <= 10 ; i++) {
                System.out.print(i + ": ");
                testInt();
                count = sc.nextInt();
                if (count >= 0) {
                    nPositivos++;
                } else {
                    nNegativos++;
                }
            }
            System.out.println("Se han introducido " + nPositivos + " números positivos");
            System.out.println("Se han introducido " + nNegativos + " números negativos");
        }

        public static void Ejercicio8() {
        /*
        Realiza un programa que lea una secuencia de números no nulos hasta que se
        introduzca un 0, y luego muestre si ha leído algún número negativo, cuantos
        positivos y cuantos negativos
         */

            /*Datos*/
            int count = 1, nPositivos = 0, nNegativos = 0, num = 0;

            /*ALGORITMO*/
            System.out.println("Introduce números no nulos (Introduce 0 para salir)");
            do {
                System.out.print(count + ": ");
                testInt();
                num = sc.nextInt();
                if (num > 0) {
                    nPositivos++;
                } else if (num < 0){
                    nNegativos++;
                }
                count++;
            } while (num != 0);
            System.out.println("Se han introducido " + nPositivos + " números positivos");
            System.out.println("Se han introducido " + nNegativos + " números negativos");
        }

        public static void Ejercicio9() {
        /*
        Realiza un programa que calcule y escriba la suma y el producto de los 10 primeros
        números naturales.
         */

            /*Datos*/
            int suma = 0, producto = 1;

            /*ALGORITMO*/
            for (int i = 1; i < 11; i++) {
                suma = suma + i;
                producto = producto * i;
            }
            System.out.println("La suma de los 10 primeros números naturales es " + suma);
            System.out.println("El producto de los 10 primeros números naturales es " + producto);
        }

        public static void Ejercicio10(){
        /*
        Realiza un programa que lea una secuencia de notas (con valores que van de 0 a 10)
        que termina con el valor -1 y nos dice si hubo o no alguna nota con valor 10.
         */

            /*DATOS*/
            double nota = 0.0;
            int nota10 = 0, count = 0;

            /*ALGORITMO*/
            System.out.println("Introduce las notas de los alumnos (-1 para salir del programa)");
            do {
                count++;
                System.out.print("Nota del alumno Nº" + count + ": ");
                do {
                    testDouble();
                    nota = sc.nextDouble();
                    if (nota < -1 || nota > 10) {
                        System.out.println("Nota incorrecta, introduzca una nota valida (0-10) o introduzca -1 para salir");
                    }
                } while (nota < -1 || nota > 10);


                if (nota == 10) {
                    nota10++;
                }
            } while (nota != -1);
            if (nota10 > 0) {
                System.out.println("Si hubo notas con valor 10");
            } else {
                System.out.println("No hubo notas con valor 10");
            }

        }

        public static void Ejercicio11() {
        /*
        Realiza un programa que sume independientemente los pares y los impares de los
        números comprendidos entre 100 y 200, y luego muestra por pantalla ambas sumas.
         */

            /*DATOS*/
            int par = 0, impar = 0, sumaPar = 0, sumaImpar = 0;

            /*ALGORITMO*/
            for (int i = 100; i < 201; i++) {
                if (i % 2 == 0) {
                    par = i;
                    sumaPar += par;
                } else {
                    impar = i;
                    sumaImpar += impar;
                }
            }
            System.out.println("La suma de los números par comprendidos entre 100 y 200 es: " + sumaPar);
            System.out.println("La suma de los números impar comprendidos entre 100 y 200 es: " + sumaImpar);
        }

        public static void Ejercicio12() {
        /*
        Realiza un programa que calcule el valor A elevado a B (A^B) sin hacer uso del
        operador de potencia (^), siendo A y B valores introducidos por teclado, y luego
        muestre el resultado por pantalla.
         */

            /*DATOS*/
            int num = 0, numPotencia = 0, resultado = 1;

            /*ALGORITMO*/
            System.out.print("Introduce el número: ");
            testInt();
            num = sc.nextInt();
            System.out.print("Introduce la potencia: ");

            do {
                testInt();
                numPotencia = sc.nextInt();
                if (numPotencia < 0){
                    System.out.println("Número no valido, vuelva a introducir");
                }
            } while (numPotencia < 0);


            for (int i = 0; i < numPotencia; i++) {
                resultado *= num;
            }
            System.out.println("El resultado de (" + num + "^" + numPotencia + ") es: " + resultado);
        }

        public static void Ejercicio13() {
        /*
        Realiza un programa donde el usuario "piensa" un número del 1 al 100 y el
        ordenador intenta adivinarlo. Es decir, el ordenador irá proponiendo números una y
        otra vez hasta adivinarlo (el usuario deberá indicarle al ordenador si es mayor,
        menor o igual al número que ha pensado).
         */

            /*DATOS*/
            int min = 1, max = 100, numRandom = 0;
            String user = "";

            /*ALGORITMO*/
            System.out.println("Piensa un número");
            do {
                System.out.println(); //Deja una linea de espacio
                //Saca un número random entre un rango
                numRandom = (int) Math.floor(Math.random() * (max - min + 1 ) + min);

                //Muestar por pantalla el numero random
                System.out.println("El número random es: " + numRandom);
                System.out.print("Tu número es mayor (>), menor (<) o igual (=): ");
                user = sc.next();

                if (user.equals(">")) { //SI el usuario indica que es mayor cambia el valor del minimo
                    min = numRandom + 1;
                } else if (user.equals("<")) { //SI el usuario indica que es mayor cambia el valor del maximo
                    max = numRandom - 1;
                }
            } while (!user.equals("=")); //Si es igual Sale del bucle
            System.out.println("El número es: " + numRandom); //Muestra el número que ha pensado el usuario
        }

        public static void Ejercicio14() {
        /*
        . Realiza un programa que dada una cantidad de euros que el usuario introduce por
        teclado (múltiplo de 5 €) mostrará los billetes de cada tipo que serán necesarios para
        alcanzar dicha cantidad (utilizando billetes de 500, 200, 100, 50, 20, 10 y 5). Hay que
        indicar el mínimo de billetes posible.
         */
            /*Datos*/
            int cantidadEuros = 0, billetes500 = 0, billetes200 = 0, billetes100 = 0, billetes50 = 0, billetes20 = 0,
                    billetes10 = 0, billetes5 = 0;


            /*ALGORITMO*/
            System.out.print("Introduce la cantidad de euros que desea introducir (multiplo de 5€): ");
            do {
                testInt();
                cantidadEuros = sc.nextInt();
                if (cantidadEuros % 5 != 0) {
                    System.out.println("Valor Incorrecto (No es modulo de 5), vuelve a introducir");
                }
            } while (cantidadEuros % 5 != 0);

            do {
                if (cantidadEuros >= 500){
                    billetes500++;
                    cantidadEuros -= 500;
                } else if (cantidadEuros >= 200) {
                    billetes200++;
                    cantidadEuros -= 200;
                } else if (cantidadEuros >= 100) {
                    billetes100++;
                    cantidadEuros -= 100;
                } else if (cantidadEuros >= 50) {
                    billetes50++;
                    cantidadEuros -= 50;
                } else if (cantidadEuros >= 20) {
                    billetes20++;
                    cantidadEuros -= 20;
                } else if (cantidadEuros >= 10) {
                    billetes10++;
                    cantidadEuros -= 10;
                } else if (cantidadEuros >= 5) {
                    billetes5++;
                    cantidadEuros -= 5;
                }
            } while (cantidadEuros != 0);

            System.out.println("Tu devolución es:");
            System.out.println("\t" + billetes500 + " billetes de 500€");
            System.out.println("\t" + billetes200 + " billetes de 200€");
            System.out.println("\t" + billetes100 + " billetes de 100€");
            System.out.println("\t" + billetes50 + " billetes de 50€");
            System.out.println("\t" + billetes20 + " billetes de 20€");
            System.out.println("\t" + billetes10 + " billetes de 10€");
            System.out.println("\t" + billetes5 + " billetes de 5€");
        }
}
