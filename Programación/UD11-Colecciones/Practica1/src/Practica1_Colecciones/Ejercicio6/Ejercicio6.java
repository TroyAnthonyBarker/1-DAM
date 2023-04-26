package Practica1_Colecciones.Ejercicio6;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Ejercicio6 {

    static File paisesCapitalesFile = new File("Documentos/paises-capitales.csv");

    static HashMap<String, Integer> pais_capital = new HashMap<>();

    static List<String> lista = new ArrayList<>();

    public static void main(String[] args) {
        try {
            leer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void leer() throws IOException {
        Scanner lector = new Scanner(paisesCapitalesFile);
        BufferedReader lc = new BufferedReader(new FileReader(paisesCapitalesFile));
        String line;
        while ((line = lc.readLine()) != null ){
            byte[] lineByte = line.getBytes();
            lista.add(new String(lineByte, StandardCharsets.UTF_8));
        }

        lector.close();
        lc.close();
        System.out.println(lista);
    }



}
