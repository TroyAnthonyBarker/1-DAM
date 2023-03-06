import java.sql.SQLOutput;
import java.util.Scanner;
import java.lang.Math;

public class Practica1 {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        SeleccionEjercicio();
    }

    public static void SeleccionEjercicio() {
        int opcion;
        do {
            System.out.println();
            System.out.println("Elige un ejercicio entre 1-13");
            System.out.print("Introduce el número del ejercicio que quieres ejecutar (Para salir introduce 0): ");

            testInt();
            opcion = sc.nextInt();
            switch (opcion) {
                case 0 -> // Salir
                        System.out.println("Adios!");
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
                default -> // En otro caso
                        System.out.println("Error: opción incorrecta.");
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
        Escribe un programa que pide la edad por teclado y nos muestra el mensaje de
        “Eres mayor de edad” solo si lo somos.
         */
        /*DATOS*/
        int edad = 0;

        /*ALGORITMO*/
        //Pide los datos
        System.out.print("Introduce tu edad: ");
        edad = sc.nextInt();

        //Comprueba si eres mayor de edad
        if (edad > 17) {
            System.out.println("Eres mayor de edad");
        }
    }

    public static void Ejercicio2() {
        /*
        Escribe un programa que pide la edad por teclado y nos muestra el mensaje de
        “eres mayor de edad” o el mensaje de “eres menor de edad”
         */
        /*DATOS*/
        int edad = 0;

        /*ALGORITMO*/
        //Pide los datos
        System.out.print("Introduce tu edad: ");
        edad = sc.nextInt();

        //Comprueba si eres mayor de edad
        if (edad > 17) {
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }
    }

    public static void Ejercicio3() {
        /*
        Escribe un programa que lee dos números, calcula y muestra el valor de su suma,
        resta, producto y división. (Ten en cuenta la división por cero).
         */
        /*DATOS*/
        int num1 = 0, num2 = 0, suma = 0, resta = 0, producto = 0, division = 0;

        /*ALGORITMO*/
        //Pide los datos
        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();
        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextInt();

        //Operaciones
        suma = num1 + num2;
        resta = num1 - num2;
        producto = num1 * num2;
        division = num1 / num2;

        //Muestra los resultados por pantalla
        System.out.println("Operaciones: ");
        System.out.println("\t" + num1 + " + " + num2 + " = " + suma);
        System.out.println("\t" + num1 + " - " + num2 + " = " + resta);
        System.out.println("\t" + num1 + " * " + num2 + " = " + producto);
        System.out.println("\t" + num1 + " / " + num2 + " = " + division);
    }

    public static void Ejercicio4() {
        /*
        Escribe un programa que lee 2 números y muestra el mayor.
         */
        /*DATOS*/
        int num1 = 0, num2 = 0;

        /*ALGORITMO*/
        //Pide los datos
        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();
        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextInt();

        //Comprueba que número es el mayor
        if (num1 > num2) {
            System.out.println("El número mayor es " + num1);
        } else {
            System.out.println("El número mayor es " + num2);
        }
    }

    public static void Ejercicio5() {
        /*
        Escribe un programa que lee dos números y los visualiza en orden ascendente
         */
        /*DATOS*/
        int num1 = 0, num2 = 0;

        /*ALGORITMO*/
        //Pide los datos
        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();
        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextInt();

        //Comprueba que número es el mayor
        if (num1 > num2) {
            System.out.println(num1 + " > " + num2);
        } else {
            System.out.println(num2 + " > " + num1);
        }
    }

    public static void Ejercicio6() {
        /*
        Escribe un programa que lee dos números y nos dice cuál es el mayor o si son iguales.
         */
        /*DATOS*/
        int num1 = 0, num2 = 0;

        /*ALGORITMO*/
        //Pide los datos
        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();
        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextInt();

        //Comprueba que número es el mayor o si son iguales
        if (num1 > num2) {
            System.out.println("El número mayor es " + num1);
        } else if (num1 == num2) {
            System.out.println("Los números son iguales");
        } else {
            System.out.println("El número mayor es " + num2);
        }
    }

    public static void Ejercicio7() {
        /*
        Escribe un programa que lea tres números distintos y nos diga cuál es el mayor
         */
        /*DATOS*/
        int num1 = 0, num2 = 0, num3 = 0;

        /*ALGORITMO*/
        //Pide los datos
        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();
        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextInt();
        System.out.print("Introduce el tercer número: ");
        num3 = sc.nextInt();

        //Comprueba que número es el mayor
        if (num1 > num2 && num1 > num3) {
            System.out.println("El número mayor es " + num1);
        } else if (num2 > num1 && num2 > num3) {
            System.out.println("El número mayor es " + num2);
        } else if (num3 > num1 && num3 > num2) {
            System.out.println("El número mayor es " + num3);
        } else if (num1 > num2 || num1 > num3) {
            System.out.println("El número mayor es " + num1);
        } else if (num2 > num1) {
            System.out.println("El número mayor es " + num2);
        } else {
            System.out.println("El número mayor es " + num3);
        }
    }

    public static void Ejercicio8(){
        /*
        Realiza el diseño y la posterior implementación en Java del siguiente programa de cálculo de un descuento:
        a) El valor mínimo para optar al descuento es 100 y el descuento será de un 10%
        b) Pedir que se introduzca el precio inicial, en euros
        c) Leer el precio introducido
        d) Comprobar que el precio introducido sea mayor o igual al valor mínimo para optar al descuento.
        En caso afirmativo, aplicar el descuento al precio inicial.
        e) Mostrar el precio final
         */

        /*DATOS*/
        double precio = 0.0, descuento = 0.1, precioFinal = 0;
        final double minimo = 100;

        /*ALGORITMO*/
        //Pide los datos
        System.out.print("Introduce el precio: ");
        precio = sc.nextDouble();

        //Comprueba si es igual o mayor que minimo
        if (precio >= minimo){
            precioFinal = precio - (precio * descuento);
        } else {
            precioFinal = precio;
        }

        //Muestra por pantalla
        System.out.println("El precio total es " + String.format("%.2f", precioFinal) + "€");
    }

    public static void Ejercicio9() {
        /*
        Modifica el programa anterior para que, en lugar de hacer el descuento del 10 % a los productos de 100 € o más,
        aplique una penalización de 2 € si el precio es menor de 30 €
         */
        /*DATOS*/
        double precio = 0.0, penalizacion = 2.0, precioFinal = 0;
        final double minimo = 30.0;

        /*ALGORITMO*/
        //Pide los datos
        System.out.print("Introduce el precio: ");
        precio = sc.nextDouble();

        //Comprueba si es igual o mayor que minimo
        if (precio < minimo){
            precioFinal = precio + penalizacion;
        } else {
            precioFinal = precio;
        }

        //Muestra por pantalla
        System.out.println("El precio total es " + String.format("%.2f", precioFinal) + "€");
    }

    public static void Ejercicio10() {
        /*
        Escribe un programa que lea una calificación numérica entre 0 y 10 y la transforma en calificación alfabética,
        escribiendo el resultado.
            • de 0 a <3 Muy Deficiente.
            • de 3 a <5 Insuficiente.
            • de 5 a <6 Bien.
            • de 6 a <9 Notable
            • de 9 a 10 Sobresaliente
         */
        /* DATOS */
        double nota = 0.0;
        String calificacion = "";

        /* ALGORITMO */
        //Pide los datos
        System.out.print("Introduce tu calificación: ");
        nota = sc.nextDouble();

        //Comprueba la nota y guarda una calificación
        if (nota >= 0 && nota < 3){ //Si es de 0 a <3 es Muy "Deficiente".
            calificacion = "Muy Deficiente";
        } else if (nota >= 3 && nota < 5){ //Si es de 3 a <5 es "Insuficiente".
            calificacion = "Insuficiente";
        } else if (nota >= 5 && nota < 6){ //Si es de 5 a <6 es "Bien".
            calificacion = "Bien";
        } else if (nota >= 6 && nota < 9){ //Si es de 6 a <9 es "Notable"
            calificacion = "Notable";
        } else if (nota >= 9 && nota <= 10){ //Si es de 9 a 10 es "Sobresaliente"
            calificacion = "Sobresaliente";
        } else {
            calificacion = "Nota erronea"; //Si es <0 y >10 es "Nota erronea"
        }

        //Muestra por pantalla
        System.out.println("Tu calificación es: " + calificacion);
    }

    public static void Ejercicio11() {
        /*
        Escribe un programa que calcula el salario neto semanal de un trabajador (al que pediremos nombre,
        horas trabajadas y su tarifa por hora) en función del número de horas trabajadas y la tasa de impuestos
        de acuerdo a las siguientes hipótesis:
            • Las primeras 35 horas se pagan a tarifa normal.
            • Las horas que pasen de 35 se pagan a 1,5 veces la tarifa normal.
            • Las tasas de impuestos son:
                o Los primeros 500 euros son libres de impuestos.
                o Los siguientes 400 tienen un 25% de impuestos.
                o Los restantes un 45% de impuestos.
        Escribir nombre, salario bruto, tasas y salario neto.
         */
        /*DATOS*/
        String name;
        double horasTrabajadas = 0.0, tarifaHora = 0.0, horasTarifaAumentada = 0.0;

        double  salarioBruto = 0.0, salarioBruto1 = 0.0, salarioBruto2 = 0.0,
                salarioNeto = 0.0, salarioNeto1 = 0.0, salarioNeto2 = 0.0, salarioNeto3 = 0.0;

        final double horasTarifaNormal = 35.0, aumento = 1.5, primerImpuesto = 0.0, segundoImpuesto = 0.25,
                tercerImpuesto = 0.45;

        double tasas = 0.0, tasa1 = 0.0, tasa2 = 0.0, tasa3 = 0.0, tarifaHoraAumento = 0.0;

        double cantidadPrimerImpuesto = 500.0, cantidadSegundoImpuesto = 400.0;

        /*ALGORITMO*/
        //Pide los datos
        System.out.print("Introduce el nombre: ");
        name = sc.next();
        System.out.print("Introduce las horas trabajadas: ");
        horasTrabajadas = sc.nextDouble();
        System.out.print("Introduce la tarifa: ");
        tarifaHora = sc.nextDouble();

        //Operaciones
        //Comprueba si ha hecho horas extra
        if (horasTrabajadas > horasTarifaNormal){
            salarioBruto2 = horasTarifaNormal * tarifaHora; //Precio Horas Normal
            horasTarifaAumentada = horasTrabajadas - horasTarifaNormal; //Calcula las horas exatras
            tarifaHoraAumento = tarifaHora * aumento; //Calcula la tarifa de las horas extra
            salarioBruto1 = horasTarifaAumentada * tarifaHoraAumento; //Precio Horas extra
        } else {
            salarioBruto1 = horasTrabajadas * tarifaHora; //Precio Horas Normal
        }

        //Salario Bruto
        salarioBruto = salarioBruto1 + salarioBruto2;

        //Comprueba que el salario Bruto sea mayor que cantidad Primer impuesto
        if (salarioBruto > cantidadPrimerImpuesto) {
            //Comprueba que el salario Bruto sea mayor que cantidad Primer impuesto + cantidad Segundo Impuesto
            if (salarioBruto > cantidadPrimerImpuesto + cantidadSegundoImpuesto) {
                tasa1 = cantidadPrimerImpuesto * primerImpuesto;
                salarioNeto1 = cantidadPrimerImpuesto - tasa1;
                tasa2 = cantidadSegundoImpuesto * segundoImpuesto;
                salarioNeto2 = cantidadSegundoImpuesto - tasa2;
                salarioBruto1 = salarioBruto - (cantidadPrimerImpuesto + cantidadSegundoImpuesto);
                tasa3 = salarioBruto1 * tercerImpuesto;
                salarioNeto3 = salarioBruto1 - tasa3;
            } else { //Si el salario Bruto no es mayor calcula el segundo y el primer impuesto
                tasa1 = cantidadPrimerImpuesto * primerImpuesto;
                salarioNeto1 = cantidadPrimerImpuesto - tasa1;
                salarioBruto1 = salarioBruto - cantidadPrimerImpuesto;
                tasa2 = salarioBruto1 * segundoImpuesto;
                salarioNeto2 = salarioBruto1 - tasa2;
            }
        } else { //Si el salario Bruto no es mayor calcula el primer impuesto
            tasa1 = cantidadPrimerImpuesto * primerImpuesto;
            salarioNeto1 = salarioBruto - tasa1;
        }

        tasas = tasa1 + tasa2 + tasa3;
        salarioNeto = salarioNeto1 + salarioNeto2 + salarioNeto3;



        //Muestra por pantalla
        System.out.println("Nombre del trabajador: " + name);
        System.out.println("Salario bruto: " + String.format("%.2f", salarioBruto) + "€");
        System.out.println("Tasas aplicadas: " + String.format("%.2f", tasas) + "€");
        System.out.println("Salario Neto: " + String.format("%.2f", salarioNeto) + "€");
    }

    public static void Ejercicio12() {
        /*
        Escribe un programa que lea una secuencia de notas que se van introduciendo
        por el teclado (las notas serán valores numéricos que pueden contener
        decimales). La secuencia de notas finalizará cuando se introduzca un valor
        negativo. El programa informará al final del número de aprobados, el número de
        suspensos y la nota media. El programa deberá controlar los posibles errores que
        se puedan producir a la hora de introducir las notas por teclado de tal forma que
        si alguna nota introducida fuera errónea la vuelva a solicitar.
         */
        /*Datos*/
        double nota = 0.0, notaMedia = 0.0, notaMax = 0.0;
        int count = 0, nAPTOS = 0, nSuspensos = 0;

        /*ALGORITMO*/
        while (nota >= 0) {
            count++;
            System.out.println("Introduce la nota del alumno Nº" + count);
            testDouble();
            nota = sc.nextDouble();

            if (nota > 10) {
                do {
                    System.out.println("Vuelve a introducir la nota");
                    nota = sc.nextDouble();
                } while (nota > 10);
            }
            if (nota >= 5) {
                nAPTOS++;
            } else {
                nSuspensos++;
            }

            notaMax += nota;
        }
        notaMax = notaMax -(nota);
        nSuspensos--;
        count--;
        notaMedia = (double) notaMax / count;

        System.out.println("Nº de aprobados: " + nAPTOS);
        System.out.println("Nº de suspensos: " + nSuspensos);
        System.out.println("La nota media es: " + String.format("%.2f", notaMedia));
    }

    public static void Ejercicio13() {
        /*
        Diseña un programa que imite a una calculadora capaz de realizar las
        operaciones básicas (suma, resta, producto y multiplicación) y dos operaciones
        complejas como la potencia y la raíz cuadrada, la aplicación debe mostrar
        inicialmente un menú similar al siguiente:
        > Emulador Calculadora
        Elige una opción:
            1.- Operaciones básicas.
            2.- Operaciones complejas.
            3.- Salir.
        En el caso de la opción 1 se deberá mostrar:
            a. Suma.
            b. Resta.
            c. Producto.
            d. División.
        En el caso de la opción 2 se deberá mostrar:
            a. Potencia.
            b. Raíz cuadrada.
        Una vez elegida la opción correspondiente el programa deberá solicitar los datos
        necesarios y mostrar por pantalla el resultado obtenido en cada caso. El
        programa deberá controlar los posibles errores que se puedan producir a la hora
        de elegir la opción y de introducir los datos por teclado de tal forma que si los
        datos introducidos fueran erróneos los vuelva a solicitar.
         */

        /*DATOS*/
        int opcion = 0;

        /*ALGORITMO*/
        do {
            //Menu
            System.out.println();
            System.out.println("> Emulador Calculadora");
            System.out.println("Elige una opción:");
            System.out.println("\t1.- Operaciones básicas.");
            System.out.println("\t2.- Operaciones complejas.");
            System.out.println("\t3.- Salir.");
            System.out.print("Opción: ");
            testInt();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {//Operaciones basicas
                    System.out.println();
                    System.out.println("Operaciones básicas:");
                    System.out.println("\t1.- Suma.");
                    System.out.println("\t2.- Resta.");
                    System.out.println("\t3.- Producto.");
                    System.out.println("\t4.- División");
                    System.out.print("Opción: ");
                    testInt();
                    OperacionesBasicas();
                }
                case 2 -> {
                    //Operaciones basicas
                    System.out.println("Operaciones básicas:");
                    System.out.println("\t1.- Potencia.");
                    System.out.println("\t2.- Raíz Cuadrada.");
                    System.out.print("Opción: ");
                    testInt();
                    OperacionesComplejas();
                }
                case 3 -> {
                    //Salir
                    System.out.println("Hasta la próxima");
                }
            }
        }while (opcion != 3);
    }

    public static void OperacionesBasicas() {

        int  operacion = 0;
        double num1 = 0.0, num2 = 0.0, resultado = 0.0;
        operacion = sc.nextInt();

        switch (operacion) {
            case 1 -> { //suma
                System.out.println("Introduce los números a sumar, para ver resultado introduce algo distinto a un número");
                do {
                    if (!sc.hasNextDouble()) {
                        sc.next();
                        break;
                    }
                    num1 = sc.nextDouble();
                    resultado += num1 ;
                } while (operacion == 1);
                System.out.println("El resultado de la suma es: " + resultado);
            }
            case 2 -> { //restas
                System.out.println("Introduce los números a restar, para ver resultado introduce algo distinto a un número");
                resultado = sc.nextDouble();
                do {
                    if (!sc.hasNextDouble()) {
                        sc.next();
                        break;
                    }
                    num1 = sc.nextDouble();
                    resultado -= num1 ;
                } while (operacion == 2);
                System.out.println("El resultado de la resta es: " + resultado);
            }
            case 3 -> { //producto
                System.out.println("Introduce los números a multiplicar, para ver resultado introduce algo distinto a un número");
                resultado = sc.nextDouble();
                do {
                    if (!sc.hasNextDouble()) {
                        sc.next();
                        break;
                    }
                    num1 = sc.nextDouble();
                    resultado *= num1 ;
                } while (operacion == 3);
                System.out.println("El resultado de la multiplicación es: " + resultado);
            }
            case 4 -> { //división
                System.out.println("Introduce los números a dividir, para ver resultado introduce algo distinto a un número");
                resultado = sc.nextDouble();
                do {
                    if (!sc.hasNextDouble()) {
                        sc.next();
                        break;
                    }
                    num1 = sc.nextDouble();
                    resultado /= num1 ;
                } while (operacion == 3);
                System.out.println("El resultado de la división es: " + resultado);
            }
            default -> {
                System.out.println("Opción no valida, salida al menú principal");
            }
        }

    }

    public static void OperacionesComplejas() {
        int operacion = 0;
        double num1 = 0.0, num2 = 0.0, resultado = 0.0;
        operacion = sc.nextInt();

        switch (operacion) {
            case 1 -> { //potencia
                System.out.println("Introduce los números a elevar, para ver resultado introduce algo distinto a un número");
                resultado = sc.nextDouble();
                do {
                    if (!sc.hasNextDouble()) {
                        sc.next();
                        break;
                    }
                    num1 = sc.nextDouble();
                    resultado = Math.pow(resultado, num1);
                } while (operacion == 1);
                System.out.println("El resultado de la suma es: " + resultado);
            }
            case 2 -> { //raiz cuadrada
                System.out.println("Introduce los números a restar, para ver resultado introduce algo distinto a un número");
                do {
                    if (!sc.hasNextDouble()) {
                        sc.next();
                        break;
                    }
                    num1 = sc.nextDouble();
                    resultado = Math.sqrt(num1);
                    System.out.println("El resultado de la resta es: " + resultado);
                } while (operacion == 2);
            }
            default -> {
                System.out.println("Opción no valida, salida al menú principal");
            }
        }
    }
}

