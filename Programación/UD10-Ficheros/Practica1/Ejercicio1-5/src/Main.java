import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int opcion = 0;
        do {
            menu();
            System.out.print("Introduce la opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            accionMenu(opcion);
        } while (opcion != 0);
    }

    static void menu(){
        System.out.println("""
                1. Ejercicio 1
                2. Ejercicio 2
                3. Ejercicio 3
                4. Ejercicio 4
                5. Ejercicio 5
                6. Deshacer ejercicio 3
                7. Deshacer ejercicio 4
                8. Deshacer ejercicio 5
                0. Salir
                """);
    }

    static void accionMenu(int op) {
        switch (op){
            case 1 -> ejercicio1();
            case 2 -> ejercicio2();
            case 3 -> ejercicio3();
            case 4 -> ejercicio4();
            case 5 -> ejercicio5();
            case 6 -> deshacerEjercicio3();
            case 7 -> deshacerEjercicio4();
            case 0 -> System.out.println("Adios!!");
        }
    }

    static void ejercicio1() {
        String path;
        do {
            System.out.println("Introduce una ruta del sistema (por ejemplo, “C:/Windows” o “Documentos”)");
            path = sc.nextLine();

            File ruta = new File(path);

            try {
                muestraInfoRutav1(ruta);
            } catch (FileNotFoundException e) {
                if (path.equals("")) {
                    System.out.println("Adios!!");
                } else {
                    e.printStackTrace();
                }
            }
        } while (!path.equals(""));
    }

    static void muestraInfoRutav1(File ruta) throws FileNotFoundException {
        if (!ruta.exists()) throw new FileNotFoundException("Fichero no encontrado");
        if (ruta.isFile()) System.out.println("[A] " + ruta.getName());
        if (ruta.isDirectory()) {
            File[] directorio = ruta.listFiles();
            for (File file : directorio) {
                if (file.isDirectory()) System.out.println("[*] " + file.getName());
            }
            for (File file : directorio) {
                if (file.isFile()) System.out.println("[A] " + file.getName());
            }
        }
    }

    static void ejercicio2() {
        String path;
        boolean info = false;
        System.out.println("¿Quieres mostrar toda la información disponible?");
        String respuesta = sc.nextLine();
        if (
                respuesta.equalsIgnoreCase("si") ||
                respuesta.equalsIgnoreCase("sí")
        ) info = true;

        do {
            System.out.println("Introduce una ruta del sistema (por ejemplo, “C:/Windows” o “Documentos”)");
            path = sc.nextLine();

            File ruta = new File(path);

            try {
                muestraInfoRutav2(ruta, info);
            } catch (FileNotFoundException e) {
                if (path.equals("")) {
                    System.out.println("Adios!!");
                } else {
                    e.printStackTrace();
                }
            }
        } while (!path.equals(""));
    }

    static void muestraInfoRutav2(File ruta, boolean info) throws FileNotFoundException {
        if (!ruta.exists()) throw new FileNotFoundException("Fichero no encontrado");
        if (ruta.isFile()) System.out.println("[A] " + ruta.getName());
        if (ruta.isDirectory()) {
            File[] directorio = ruta.listFiles();
            Arrays.sort(directorio);
            if (info){
                for (File file : directorio) {
                    if (file.isDirectory()) System.out.println("[*] " + file.getName() + " Tamaño Bytes: " + file.length() + " Última modificación: " + file.lastModified());
                }
                for (File file : directorio) {
                    if (file.isFile()) System.out.println("[A] " + file.getName() + " Tamaño Bytes: " + file.length() + " Última modificación: " + file.lastModified());
                }
            } else {
                for (File file : directorio) {
                    if (file.isDirectory()) System.out.println("[*] " + file.getName());
                }
                for (File file : directorio) {
                    if (file.isFile()) System.out.println("[A] " + file.getName());
                }
            }
        }
    }

    static void ejercicio3() {
        File documentos = new File("Documentos");
        File DOCS = new File("DOCS");
        documentos.renameTo(DOCS);

        File fotografias = new File("DOCS/Fotografias");
        File fotos = new File("DOCS/FOTOS");
        fotografias.renameTo(fotos);

        File libros = new File("DOCS/Libros");
        File lectura = new File("DOCS/LECTURAS");
        libros.renameTo(lectura);

        File[] fotosContent = fotos.listFiles();

        for (File foto : fotosContent){
            String name = foto.getName().split("\\.")[0];
            String path = foto.getParent();
            File temp = new File(path+"/"+name);
            foto.renameTo(temp);
        }

        File[] lecturaContent = lectura.listFiles();

        for (File lect : lecturaContent){
            String name = lect.getName().split("\\.")[0];
            String path = lect.getParent();
            File temp = new File(path+"/"+name);
            lect.renameTo(temp);
        }
    }

    static void deshacerEjercicio3(){
        File documentos = new File("Documentos");
        File DOCS = new File("DOCS");
        DOCS.renameTo(documentos);

        File fotografias = new File("Documentos/Fotografias");
        File fotos = new File("Documentos/FOTOS");
        fotos.renameTo(fotografias);

        File libros = new File("Documentos/Libros");
        File lectura = new File("Documentos/LECTURAS");
        lectura.renameTo(libros);

        File[] fotosContent = fotografias.listFiles();

        for (File foto : fotosContent){
            String name = foto.getName() + ".jpg";
            String path = foto.getParent();
            File temp = new File(path+"/"+name);
            foto.renameTo(temp);
        }

        File[] librosContent = libros.listFiles();

        for (File lib : librosContent){
            String name = lib.getName() + ".txt";
            String path = lib.getParent();
            File temp = new File(path+"/"+name);
            lib.renameTo(temp);
        }
    }

    static void ejercicio4(){
        File mis_cosas = new File("Documentos/Mis Cosas");
        mis_cosas.mkdir();

        File fotografias = new File("Documentos/Fotografias");
        File libro = new File("Documentos/Libros");

        File fotografiasNuevo = new File("Documentos/Mis Cosas/Fotografias");
        File libroNuevo = new File("Documentos/Mis Cosas/Libros");

        fotografias.renameTo(fotografiasNuevo);
        libro.renameTo(libroNuevo);


        File alfabeto = new File("Documentos/Alfabeto");
        alfabeto.mkdir();

        for (int i = 65; i <= 90; i++) {
            char c = (char) (i);
            File letra = new File("Documentos/Alfabeto/" + c);
            letra.mkdir();
        }
    }

    static void deshacerEjercicio4(){
        File mis_cosas = new File("Documentos/Mis Cosas");
        File fotografias = new File("Documentos/Fotografias");
        File libro = new File("Documentos/Libros");
        File fotografiasNuevo = new File("Documentos/Mis Cosas/Fotografias");
        File libroNuevo = new File("Documentos/Mis Cosas/Libros");
        File alfabeto = new File("Documentos/Alfabeto");


        fotografiasNuevo.renameTo(fotografias);
        libroNuevo.renameTo(libro);
        mis_cosas.delete();

        for (int i = 65; i <= 90; i++) {
            char c = (char) (i);
            File letra = new File("Documentos/Alfabeto/" + c);
            letra.delete();
        }

        alfabeto.delete();
    }

    static void ejercicio5(){
        File documentos = new File("Documentos");
        File fotogracias = new File("Documentos/Fotografias");
        File libros = new File("Documentos/Libros");

        try {
            borraTodo(fotogracias);
            borraTodo(libros);
            borraTodo(documentos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static boolean borraTodo(File f) throws FileNotFoundException {
        boolean respuesta = false;
        if (!f.exists()) throw new FileNotFoundException("EL fichero no existe");

        if (f.isFile()) respuesta = f.delete();

        if (f.isDirectory()) {
            File[] contenidoF = f.listFiles();
            for (File file : contenidoF){
                borraTodo(file);
            }
            respuesta = f.delete();
        }

        return respuesta;
    }
}
