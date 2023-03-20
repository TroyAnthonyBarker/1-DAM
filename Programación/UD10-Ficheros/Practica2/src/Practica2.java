import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Practica2 {

    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int opcion;
        do {
            menu();
            System.out.print("Introduce una opción: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                accion(opcion);
            }catch (InputMismatchException e){
                opcion = 0;
            }
        } while (opcion != 0);

    }

    static void menu(){
        System.out.println("""
                
                Opciones (0 para salir)
                    1. Ejercicio 1
                    2. Ejercicio 2
                    3. Ejercicio 3
                    4. Ejercicio 4
                    5. Ejercicio 5
                    6. Ejercicio 6
                """);
    }

    static void accion(int op){
        switch (op){
            case 1 -> {
                System.out.println("\n\t ------------- Ejercicio 1 -------------");
                ejercicio1();
            }
            case 2 -> {
                System.out.println("\n\t ------------- Ejercicio 2 -------------");
                ejercicio2();
            }
            case 3 -> {
                System.out.println("\n\t ------------- Ejercicio 3 -------------");
                ejercicio3();
            }
            case 4 -> {
                System.out.println("\n\t ------------- Ejercicio 4 -------------");
                ejercicio4();
            }
            case 5 -> {
                System.out.println("\n\t ------------- Ejercicio 5 -------------");
                ejercicio5();
            }
            case 6 -> {
                System.out.println("\n\t ------------- Ejercicio 6 -------------");
                ejercicio6();
            }
        }
    }

    static void ejercicio6(){
        try {
            File f = new File("Documentos/pi-million.txt");
            Scanner lector = new Scanner(f);
            StringBuilder pi = new StringBuilder();
            while (lector.hasNextLine()) {
                pi.append(lector.nextLine());
            }
            String num = pideNumero();
            if (pi.toString().matches("(.*)"+num+"(.*)")) System.out.println("Sí aparece");
            else System.out.println("No aparece");
            lector.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String pideNumero() throws Exception {
        System.out.print("Introduce un número: ");
        String numero = sc.nextLine();
        if (!numero.matches("\\d+")) throw new Exception("No es un número");
        return numero;
    }
    static void ejercicio5(){
        File f = new File("Documentos/Diccionario");
        if (!f.exists()) f.mkdir();

        for (int i = 65; i <= 90; i++) {
            char letra = (char) i;
            File temp = new File(f, letra+".txt");
            llenaDiccionario(temp, letra);
        }
    }

    static void llenaDiccionario(File f, char letra) {
        try {
            File diccionario = new File("Documentos/diccionario.txt");
            Scanner lector = new Scanner(diccionario);
            FileWriter writer = new FileWriter(f);
            List<String> palabras = new ArrayList<>();
            while (lector.hasNextLine()) {
                palabras.add(lector.nextLine());
            }
            for (String palabra : palabras) {
                if (palabra.startsWith(String.valueOf(letra))) writer.write(palabra + "\n");
            }
            lector.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void ejercicio4(){
        try {
            List<String> nombres = nombresFichero();
            List<String> apellidos = apellidosFichero();
            System.out.println("¿Cuantos nombres deseas generar?");
            int cantidadNombres = sc.nextInt();
            sc.nextLine();
            System.out.println("¿A que fichero deseas insertar los nombres?");
            File f = new File(sc.nextLine());
            FileWriter writer = new FileWriter(f, true);
            writer.write(mezcla(nombres, apellidos, cantidadNombres));
            writer.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static String mezcla(List<String> nombres, List<String> apellidos, int cantidad){
        List<String> mezcla = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            int randomName = (int) (Math.random()*(nombres.size()-1));
            int randomSurname = (int) (Math.random()*(apellidos.size()-1));
            mezcla.add(nombres.get(randomName) + " " + apellidos.get(randomSurname));
        }
        StringBuilder mezclaString = new StringBuilder();
        for (String line : mezcla) {
            mezclaString.append(line + "\n");
        }
        return mezclaString.toString();
    }

    private static List<String> apellidosFichero() throws FileNotFoundException {
        File f = new File("Documentos/usa_apellidos.txt");
        List<String> apellidos = new ArrayList<>();
        Scanner lector = new Scanner(f);
        while (lector.hasNextLine()){
            apellidos.add(lector.nextLine());
        }
        lector.close();
        return apellidos;
    }

    private static List<String> nombresFichero() throws FileNotFoundException {
        File f = new File("Documentos/usa_nombres.txt");
        List<String> nombres = new ArrayList<>();
        Scanner lector = new Scanner(f);
        while (lector.hasNextLine()){
            nombres.add(lector.nextLine());
        }
        lector.close();
        return nombres;
    }

    static void ejercicio3() {
        File a = pideFile();
        File b = pideFile();

        boolean sobreescribir = checkFile(b);
        while (!sobreescribir) {
            b = pideFile();
            sobreescribir = checkFile(b);
        }
        try{
            Scanner lector = new Scanner(a);
            FileWriter writer = new FileWriter(b);
            writer.write(contenidoOrdenado(lector));
            lector.close();
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    static String contenidoOrdenado(Scanner lector){
        List<String> contenido = new ArrayList<>();
        StringBuilder contenidoOrdenado = new StringBuilder();
        while (lector.hasNextLine()){
            contenido.add(lector.nextLine() + "\n");
        }
        Collections.sort(contenido);
        for (String line : contenido) contenidoOrdenado.append(line);
        return contenidoOrdenado.toString();
    }

    static boolean checkFile(File f){
        boolean sobreescribir;
        if (f.exists()) {
            System.out.println("El fichero " + f.getName() + " existe. ¿Quieres sobreescribir?");
            sobreescribir =
                    sc.nextLine().equalsIgnoreCase("si") ||
                            sc.nextLine().equalsIgnoreCase("sí") ||
                            sc.nextLine().equalsIgnoreCase("s") ||
                            sc.nextLine().equalsIgnoreCase("yes") ||
                            sc.nextLine().equalsIgnoreCase("y");
        } else {
            sobreescribir = true;
        }
        return sobreescribir;
    }

    static File pideFile() {
        File f;
        System.out.println("Introduce una ruta del fichero.");
        f = new File(sc.nextLine());
        return f;
    }

    static void ejercicio2(){
        File f = new File("Documentos/alumnos_notas.txt");
        try{
            List<Alumno> alumnos = alumnos(f);
            for (Alumno alu : alumnos){
                System.out.println(alu.getNombreCompleto() + " Media: " + alu.mediaNotas());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static List<Alumno> alumnos(File f) throws FileNotFoundException {
        Scanner lector = new Scanner(f);
        List<Alumno> alumnos = new ArrayList<>();
        while (lector.hasNextLine()){
            String alu = lector.nextLine();
            String[] datoAlu = alu.split(" ");
            List<Double> notas = new ArrayList<>();
            for (int i = 2; i < datoAlu.length; i++) {
                notas.add(Double.parseDouble(datoAlu[i]));
            }
            alumnos.add(new Alumno(datoAlu[0], datoAlu[1], notas));
        }
        lector.close();
        return alumnos;
    }


    static void ejercicio1(){
        File f = new File("Documentos/numeros.txt");
        try{
            double min, max;
            min = minValueOf(f);
            max = maxValueOf(f);
            System.out.println("El número máximo es " + max + " y el número mínimo es " + min);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    static double minValueOf(File f) throws FileNotFoundException {
        Scanner lector = new Scanner(f);
        double minValue = Double.MAX_VALUE;
        while (lector.hasNext()){
            double valor = lector.nextDouble();
            if (valor < minValue) minValue = valor;
        }
        lector.close();
        return minValue;
    }

    static double maxValueOf(File f) throws FileNotFoundException {
        Scanner lector = new Scanner(f);
        double maxValue = Double.MIN_VALUE;
        while (lector.hasNext()){
            double valor = lector.nextDouble();
            if (valor > maxValue) maxValue = valor;
        }
        lector.close();
        return maxValue;
    }
}
