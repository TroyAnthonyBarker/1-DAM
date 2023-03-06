import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc;
    static List<Vehiculo> parqueVehiculos = new ArrayList<>();

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Utilidades.scx = new Scanner(System.in);
        int opcion;
        do {
            Utilidades.delay(300);
            menuOpciones();
            opcion = Utilidades.pideIntMinMax(0, 4, "Introduce la opción: ");
            accion(opcion);
        } while (opcion != 0);
    }

    static void menuOpciones() {
        System.out.println("""
                
                1. Crear Vehículo
                2. Eliminar Vehículo
                3. Mostrar parque de vehículos
                0. Salir
                """);
    }

    static void accion(int opcion){
        switch (opcion){
            case 1 -> menuTipoVehiculo();
            case 2 -> eliminaVehiculo();
            case 3 -> muestraParqueVehiculos();
            case 0 -> System.out.println("Adiós!!");
            default -> System.err.println("Opción no valida");
        }
    }

    static void muestraParqueVehiculos() {
        if (parqueVehiculos.size() != 0) {
            System.out.println("\nParque de vehículos:");
            for (int i = 0; i < parqueVehiculos.size(); i++) {
                System.out.println("\t" + (i + 1) + ". " + parqueVehiculos.get(i));
            }
        } else {
            System.err.println("El parque está vacío");
        }
    }
    static void menuTipoVehiculo() {
        System.out.println("""
                1. Terrestre
                2. Acuático
                3. Aéreo
                """);
        int opcion = Utilidades.pideIntMinMax(1, 3, "Introduce la opción: ");
        switch (opcion) {
            case 1 -> menuCrearObjetoTerrestre();
            case 2 -> menuCrearObjetoAcuatico();
            case 3 -> menuCrearObjetoAereo();
            default -> System.err.println("Opción inválida");
        }
    }

    static void menuCrearObjetoTerrestre() {
        System.out.println("""
                1. Coche
                2. Moto
                3. Genérico
                """);
        int opcion = Utilidades.pideIntMinMax(1, 3, "Introduce la opción: ");
        switch (opcion) {
            case 1 -> crearCoche();
            case 2 -> crearMoto();
            case 3 -> crearTerrestre();
            default -> System.err.println("Opción inválida");
        }
    }

    static void menuCrearObjetoAcuatico() {
        System.out.println("""
                1. Barco
                2. Submarino
                3. Genérico
                """);
        int opcion = Utilidades.pideIntMinMax(1, 3, "Introduce la opción: ");
        switch (opcion) {
            case 1 -> crearBarco();
            case 2 -> crearSubmarino();
            case 3 -> crearAcuatico();
            default -> System.err.println("Opción inválida");
        }
    }

    static void menuCrearObjetoAereo() {
        System.out.println("""
                1. Avión
                2. Helicóptero
                3. Genérico
                """);
        int opcion = Utilidades.pideIntMinMax(1, 3, "Introduce la opción: ");
        switch (opcion) {
            case 1 -> crearAvion();
            case 2 -> crearHelicoptero();
            case 3 -> crearAereo();
            default -> System.err.println("Opción inválida");
        }
    }

    static boolean validarSN(String sn){
        boolean ok = false;
        do {
            if (
                    sn.equalsIgnoreCase("s") ||
                    sn.equalsIgnoreCase("n") ||
                    sn.equalsIgnoreCase("si") ||
                    sn.equalsIgnoreCase("no") ||
                    sn.equalsIgnoreCase("sí")
            ) {
                ok = true;
            } else {
                System.err.println("Opción no válida. Vuelva a introducir");
                sn = sc.nextLine();
            }
        } while (!ok);
        return ok;
    }

    static String formatoMatriculaTerrestre(){return "NNNNLLL (N = número, L = letra)";}
    static String formatoMatriculaAcuatico() {return "3-10L (N = número, L = letra)";}
    static String formatoMatriculaAereo(){return "LLLLNNNNNN (N = número, L = letra)";}

    static String pideMatricula(int vehiculo) {
        String formato = "";
        switch (vehiculo){
            case 1 ->formato=formatoMatriculaTerrestre();
            case 2 ->formato=formatoMatriculaAcuatico();
            case 3 ->formato=formatoMatriculaAereo();
        }
         System.out.print("Introduce la matricula con el siguiente formato "+formato+": ");


        return sc.nextLine();
    }

    static String pideModelo() {
        System.out.print("Introduce el modelo: ");
        return sc.nextLine();
    }

    static void crearTerrestre() {
        int numRuedas = Utilidades.pideIntMinMax(0, Integer.MAX_VALUE, "Introduce el número de ruedas: ");
        parqueVehiculos.add(new Terrestre(pideMatricula(1), pideModelo(), numRuedas));
    }

    static void crearCoche(){
        System.out.println("¿Tiene aire acondicionado?(S-N)");
        boolean aire = validarSN(sc.nextLine());
        parqueVehiculos.add(new Coche(pideMatricula(1), pideModelo(), aire));
    }

    static void crearMoto() {
        System.out.print("Introduce el color: ");
        String color = sc.nextLine();
        parqueVehiculos.add(new Moto(pideMatricula(1), pideModelo(), color));
    }

    static double pideEslora() {
        return Utilidades.pideDoubleMinMax(0, Double.MAX_VALUE, "Introduce el Eslora: ");
    }
    static void crearAcuatico() {
        parqueVehiculos.add(new Acuatico(pideMatricula(2), pideModelo(), pideEslora()));
    }

    static void crearBarco(){
        System.out.println("¿Tiene motor?(S-N)");
        boolean motor = validarSN(sc.nextLine());
        parqueVehiculos.add(new Barco(pideMatricula(2), pideModelo(), pideEslora(), motor));
    }

    static void crearSubmarino(){
        double profundidadMaxima = Utilidades.pideDoubleMinMax(0, Double.MAX_VALUE, "Introduce la profundidad máxima: ");
        parqueVehiculos.add(new Submarino(pideMatricula(2), pideModelo(), pideEslora(), profundidadMaxima));
    }

    static int pideNumAsientos(){
        return Utilidades.pideIntMinMax(1, Integer.MAX_VALUE, "Introduce el número de asientos: ");
    }
    static void crearAereo() {
        parqueVehiculos.add(new Aereo(pideMatricula(3), pideModelo(), pideNumAsientos()));
    }

    static void crearAvion(){
        double tiempoDeVuelo = Utilidades.pideDoubleMinMax(0, Double.MAX_VALUE, "Introduce el tiempo de vuelo: ");
        parqueVehiculos.add(new Avion(pideMatricula(3), pideModelo(), pideNumAsientos(), tiempoDeVuelo));
    }

    static void crearHelicoptero(){
        int numHelices = Utilidades.pideIntMinMax(1, Integer.MAX_VALUE, "Introduce el número de hélices: ");

        parqueVehiculos.add(new Helicoptero(pideMatricula(3), pideModelo(), pideNumAsientos(), numHelices));
    }

    static void eliminaVehiculo(){
        if (parqueVehiculos.size() != 0) {
            muestraParqueVehiculos();
            System.out.println();
            int opcion = Utilidades.pideIntMinMax(1, parqueVehiculos.size(), "¿Qué vehículo quieres eliminar?: ") - 1;
            parqueVehiculos.remove(opcion);
        } else {
            muestraParqueVehiculos();
        }
    }
}
