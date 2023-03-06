import java.util.Scanner;

public class MarcosZaragozaBank {

    static Scanner sc;
    static CuentaBancaria cuenta;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Utilidades.scx = new Scanner(System.in);
        int opcion;
        boolean cuentaOk = false;
        do {
            cuentaOk = crearCuenta();
            if (!cuentaOk){
                System.err.println("Letras del IBAN deben estar en mayúscula");
                System.err.println("El titular debe tener nombre y apellidos(2)");
            }
        } while (!cuentaOk);


        do {
            System.out.println();
            menu();
            opcion = Utilidades.pideIntMinMax(0, 8, "Introduce una opción: ");
            System.out.println();
            accion(opcion);
        } while (opcion != 0);

    }

    public static boolean crearCuenta(){
        System.out.println("Creemos una cuenta:");
        System.out.println("Introduce el IBAN (Dos letras y 22 números): ");
        String iban = sc.nextLine();
        System.out.println("Introduce el titular (Nombre, Apellido1 y Apellido2)");
        String titular = sc.nextLine();
        boolean creada = false;
        try {
            cuenta = new CuentaBancaria(iban, titular);
            creada = true;
        } catch (InvalidIBANException | InvalidTitularException e) {
            e.printStackTrace();
        }
        return creada;
    }

    public static void menu(){
        System.out.println("""
                1. Datos de la cuenta. Mostrará el IBAN, el titular y el saldo.
                2. IBAN. Mostrará el IBAN.
                3. Titular. Mostrará el titular.
                4. Saldo. Mostrará el saldo disponible.
                5. Ingreso. Pedirá la cantidad a ingresar y realizará el ingreso si es posible.
                6. Retirada. Pedirá la cantidad a retirar y realizará la retirada si es posible.
                7. Movimientos. Mostrará una lista con el historial de movimientos.
                0. Salir. Termina el programa.
                """);
    }

    public static void accion(int opcion){
        switch (opcion){
            case 1 -> System.out.println(cuenta);
            case 2 -> System.out.println(cuenta.getIban());
            case 3 -> System.out.println(cuenta.getTitular());
            case 4 -> System.out.println(cuenta.getSaldo());
            case 5 -> ingreso();
            case 6 -> retirada();
            case 7 -> System.out.println(cuenta.movimientos());
            case 8 -> multiple();
            case 0 -> System.out.println("Adíos!");
        }
    }

    public static void multiple(){
        System.out.println("1. Ingreso \n2. Retirada");
        int opcion = Utilidades.pideIntMinMax(1, 2, "Opción: ");
        int catidad = Utilidades.pideInt("Cantidad de veces: ");
        double dinero = Utilidades.pideDouble("Introduce la cantidad que deseas ingresar/retirar: ");

        switch (opcion) {
            case 1 -> {
                for (int i = 0; i < catidad; i++) {
                    try {
                        cuenta.ingresos(dinero);
                    } catch (InvalidIngresoException e) {
                        System.err.println(e.getMessage());
                    } catch (AvisoException e) {
                        System.err.println("AVISO: hacienda notificado");;
                    }
                }
            }
            case 2 -> {
                for (int i = 0; i < catidad; i++) {
                    try {
                        cuenta.retirada(dinero);
                    } catch (InvalidRetiradaExeption e) {
                        System.err.println(e.getMessage());
                    } catch (AvisoException e) {
                        System.err.println("AVISO: hacienda notificado");;
                    }
                }
            }
        }
    }

    public static void ingreso(){
        try {
            cuenta.ingresos(Utilidades.pideDouble("Introduce la cantidad que deseas ingresar: "));
        } catch (InvalidIngresoException e) {
            System.err.println(e.getMessage());
        } catch (AvisoException e) {
            System.err.println("AVISO: hacienda notificado");;
        }
    }

    public static void retirada(){
        try {
            cuenta.retirada(Utilidades.pideDouble("Introduce la cantidad que deseas retirar: "));
        } catch (InvalidRetiradaExeption e) {
            System.err.println(e.getMessage());
        } catch (AvisoException e) {
            System.err.println("AVISO: hacienda notificado");;
        }
    }
}
