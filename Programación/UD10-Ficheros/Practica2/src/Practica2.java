import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Practica2 {

    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("\t ------------- Ejercicio 1 -------------");
        ejercicio1();
        System.out.println("\n\t ------------- Ejercicio 2 -------------");
        ejercicio2();
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
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    static String contenidoOrdenado(Scanner lector){
        List<String> contenido = new ArrayList<>();
        StringBuilder contenidoOrdenado = new StringBuilder();
        while (lector.hasNextLine()){
            contenido.add(lector.nextLine());
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
