import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practica2 {

    public static void main(String[] args) {
        ejercicio1();
        System.out.println();
        ejercicio2();
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
        return minValue;
    }

    static double maxValueOf(File f) throws FileNotFoundException {
        Scanner lector = new Scanner(f);
        double maxValue = Double.MIN_VALUE;
        while (lector.hasNext()){
            double valor = lector.nextDouble();
            if (valor > maxValue) maxValue = valor;
        }
        return maxValue;
    }
}
