import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Inventario {
    static final Animal[] animales = new Animal[100];
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Utilidades.scx = new Scanner(System.in);
        int opcion;
        do {
            muestraMenu();
            opcion = Utilidades.pideIntMinMax(0, 6, "Elige una opción (0 para salir): ");
            accion(opcion);
        } while (opcion != 0);
    }

    public static void muestraMenu(){
        System.out.println("""
            
            Opciones:
            1 ◦ Mostrar la lista de animales (solo tipo y nombre, 1 línea por animal).
            2 ◦ Mostrar todos los datos de un animal concreto.
            3 ◦ Mostrar todos los datos de todos los animales.
            4 ◦ Insertar animales en el inventario.
            5 ◦ Eliminar animales del inventario.
            6 ◦ Vaciar el inventario
            """);
    }

    public static void  accion(int opcion) {
        switch (opcion) {
            case 1 -> muestraListaAnimales();
            case 2 -> muestraAnimalConcreto();
            case 3 -> muestraListaDatosAnimales();
            case 4 -> anyadirAniaml();
            case 5 -> eliminarAnimal();
            case 6 -> vaciarInventario();
            default -> System.out.println("Adiós");
        }
    }

    public static void muestraListaAnimales(){
        String lista = "";
        for (int i = 0; i < animales.length; i++) {
            if (animales[i] != null){
                lista += animales[i].toStringLimitado() +"\n";
            }
        }
        if (lista.equals("")) System.err.println("No hay mascotas registradas");
        else System.out.println(lista);
    }

    public static void muestraAnimalConcreto(){
        System.out.println("¿A quien buscas?");
        String nombre = sc.nextLine();
        if (buscaAnimal(nombre) != null) System.out.println(buscaAnimal(nombre));
        else System.err.println("Esa mascotas no está registrada");
    }

    public static Animal buscaAnimal(String nombre){
        Animal animal = null;
        for (int i = 0; i < animales.length; i++) {
            if (animales[i] != null && animales[i].getNombre().equalsIgnoreCase(nombre)){
                animal =  animales[i];
                break;
            }
        }
        return animal;
    }

    public static void muestraListaDatosAnimales(){
        String lista = "";
        for (int i = 0; i < animales.length; i++) {
            if (animales[i] != null){
                lista += animales[i] + "\n";
            }
        }
        if (lista.equals("")) System.err.println("No hay mascotas registradas");
        else System.out.println(lista);
    }

    public static void anyadirAniaml(){
        int opcion = Utilidades.pideIntMinMax(1, 3, "¿Que tipo de animal desea añadir? (1. Perro, 2. Gato o 3. Loro)\n");

        switch (opcion) {
            case 1 -> anyadePerro();
            case 2 -> anyadeGato();
            case 3 -> anyadeLoro();
            default -> System.err.println("No admitimos esa opción");
        }
    }

    public static Animal datosAnimal(){
        String nombre, estado, fechaNac;
        int year, month, day;

        System.out.print("Nombre de la mascota: ");
        nombre = sc.nextLine();

        System.out.print("Fecha de nacimiento de la mascota(dd/mm/yyyy): ");
        fechaNac = sc.nextLine();
        day = Integer.parseInt(fechaNac.substring(0, 2));
        month = Integer.parseInt(fechaNac.substring(3, 5));
        year = Integer.parseInt(fechaNac.substring(6));

        System.out.print("Estado de la mascota: ");
        estado = sc.nextLine();

        return new Animal(nombre, LocalDate.of(year, month, day), estado);
    }

    public static Perro creaPerro(){
        Animal temp = datosAnimal();
        String color, raza;

        System.out.print("Raza de la mascota: ");
        raza = sc.nextLine();

        System.out.print("Color de la mascota: ");
        color = sc.nextLine();

        return new Perro(temp.getNombre(), temp.getFechaNac(), temp.getEstado(), color, raza);
    }

    public static Gato creaGato(){
        Animal temp = datosAnimal();
        String color, pelo;

        System.out.print("Color de la mascota: ");
        color = sc.nextLine();

        System.out.println("¿Cuál es la longitud del pelo? (largo, medio, corto)");
        pelo = sc.nextLine();

        return new Gato(temp.getNombre(), temp.getFechaNac(), temp.getEstado(), color, pelo);
    }

    public static Loro creaLoro(){
        Animal temp = datosAnimal();
        String origen;
        boolean longPico;

        System.out.print("Origen de la mascota: ");
        origen = sc.nextLine();

        System.out.print("Tiene el pico largo? (S o N)");
        longPico = sc.nextLine().equalsIgnoreCase("s");

        return new Loro(temp.getNombre(), temp.getFechaNac(), temp.getEstado(), longPico, origen);
    }

    public static void anyadePerro(){
        for (int i = 0; i < animales.length; i++) {
            if (animales[i] == null) {
                animales[i] = creaPerro();
                break;
            }
        }
    }

    public static void anyadeGato(){
        for (int i = 0; i < animales.length; i++) {
            if (animales[i] == null) {
                animales[i] = creaGato();
                break;
            }
        }
    }

    public static void anyadeLoro(){
        for (int i = 0; i < animales.length; i++) {
            if (animales[i] == null) {
                animales[i] = creaLoro();
                break;
            }
        }
    }

    public static void eliminarAnimal(){
        System.out.println("¿Qué animal se ha ido?");
        String nombre = sc.nextLine();

        for (int i = 0; i < animales.length; i++) {
            if (animales[i] != null && animales[i].getNombre().equalsIgnoreCase(nombre)){
                animales[i] = null;
                break;
            }
        }
    }
    public static void vaciarInventario(){
        Arrays.fill(animales, null);
    }
}
