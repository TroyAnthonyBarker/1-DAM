package Practica1_Colecciones.Ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio3 {

    static List<Libro> libros = new ArrayList<>();
    static File libro = new File("Documentos/Libros");

    public static void main() {
        File[] ficherosLibros = libro.listFiles();
        assert ficherosLibros != null;
        for (File f : ficherosLibros) leer(f);
        sortLibros();
        libros.forEach(System.out::println);
    }

    static void sortLibros() {
        Scanner sc = new Scanner(System.in);
        int op, desc;

        System.out.println("¿Por qué campo deseas ordenar? (1. Title | 2. Author | 3. Posting Date | 4. Release Date | 5. Language)");
        op = sc.nextInt();
        if (sc.hasNextLine()) sc.nextLine();

        System.out.println("¿Deseas ordenar: 1. Ascendiente | 2. Descendiente?");
        desc = sc.nextInt();
        if (sc.hasNextLine()) sc.nextLine();

        if (desc == 1) sortLibrosAsc(op);
        else sortLibrosDesc(op);
    }

    static void sortLibrosDesc(int op){
        switch (op) {
            case 1 -> libros.sort(Comparator.comparing(Libro::getTitle).reversed());
            case 2 -> libros.sort(Comparator.comparing(Libro::getAuthor).reversed());
            case 3 -> libros.sort(Comparator.comparing(Libro::getPostingDate).reversed());
            case 4 -> libros.sort(Comparator.comparing(Libro::getReleaseDate).reversed());
            case 5 -> libros.sort(Comparator.comparing(Libro::getLanguage).reversed());
        }
    }

    static void sortLibrosAsc(int op){
        switch (op) {
            case 1 -> libros.sort(Comparator.comparing(Libro::getTitle));
            case 2 -> libros.sort(Comparator.comparing(Libro::getAuthor));
            case 3 -> libros.sort(Comparator.comparing(Libro::getPostingDate));
            case 4 -> libros.sort(Comparator.comparing(Libro::getReleaseDate));
            case 5 -> libros.sort(Comparator.comparing(Libro::getLanguage));
        }
    }


    static void leer(File libro) {
        try {
            Scanner lector = new Scanner(libro);
            String title = "No info", author = "No info", releaseDate = "", postingDate = "", language = "No info";

            while (lector.hasNextLine()) {
                String line = lector.nextLine();
                String[] lineSplit = line.split(":");
                if (line.contains("Title") && lineSplit.length > 1) title = lineSplit[1];
                if (line.contains("Author") && lineSplit.length > 1) author = lineSplit[1];
                if (line.contains("Release Date") && lineSplit.length > 1) releaseDate = lineSplit[1];
                if (line.contains("Posting Date") && lineSplit.length > 1) postingDate = lineSplit[1];
                if (line.contains("Language") && lineSplit.length > 1) language = lineSplit[1];
            }

            if (postingDate.equals("")) {
                if (releaseDate.equals(" ") || releaseDate.equals(""))
                    libros.add(new Libro(title, author, "January 01, 2000", language));
                else libros.add(new Libro(title, author, releaseDate.trim(), language));
            } else {
                if (releaseDate.equals("") || releaseDate.equals(" "))
                    libros.add(new Libro(title, author, postingDate.trim(), "January 01, 2000", language));
                else libros.add(new Libro(title, author, postingDate.trim(), releaseDate.trim(), language));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
