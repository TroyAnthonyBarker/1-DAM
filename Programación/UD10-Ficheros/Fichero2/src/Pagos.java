import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Actividad 2. En el fichero pagos.txt, tenemos a personas que han realizado compras a lo largo del mes de Marzo.
En el txt aparece el nombre y un apellido, más el tercer campo, que sería la edad que tiene, y el cuarto su sexo (M/H).
Los demás campos serán los importes de las compras que ha realizado, habiendo un máximo de 10 compras (si se pasa
tendremos que notificarlo con un mensaje por pantalla).

Obtén la información, y genera dos nuevos ficheros, uno para mujeres y otro para hombres,
y en el que indiquéis la media de cada uno de ellos (escribiendo su nombre, apellido y edad también),
así como la media de edad y media de gasto todo el colectivo en la última línea de cada fichero.

En estos ficheros, tendréis que implementar el manejo de excepciones requeridas, así como la definición de una excepción
que sea lanzada cuando el fichero esté mal definido (que tenga más de 10 compras un comprador, que su campo sexo no
tenga el valor que debería H o M o que haya más de 50 registros de compradores).

Tendréis subido un ejemplo de fichero pagos.txt. No obstante, sería recomendable probar con más opciones para poner a
prueba a vuestro programa en casos que no se den en ese fichero.

Como extra/opcional, podréis también valorar las opciones de:
- Que introduzca un segundo apellido en algunos/todos nombres
- Que valide que el campo edad sea un numérico no negativo y que aparece en todos los compradores
- Que valide que el sexo tiene correctamente o H o M y que aparece en todos los compradores
- Que valide que no haya importes de compras en negativo
- Que en vez de sólo revisar un fichero pagos.txt, revise los ficheros de una carpeta llamada Pagos y tenga la misma funcionalidad, clasificando en hombres y mujeres
Estos extras ampliarán las opciones de poder lanzar dicha excepción de FileMalformed
 */
public class Pagos {

    static Scanner sc;
    static final DecimalFormat df = new DecimalFormat("0.00");
    static List<Persona> personasH = new ArrayList<>();
    static List<Persona> personasM = new ArrayList<>();
    static File carpeta = new File("input/Pagos");
    static File archivo = new File("input/Pagos.txt");

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        carpetaOarchivo();
    }

    public static void carpetaOarchivo() {

        if (archivo.exists() && archivo.isFile() && carpeta.exists() && carpeta.isDirectory()) {
            System.out.println("Existe la carpeta y el archivo. ¿Qué desea leer? (1. carpeta, 2. archivo)");
            int opcion = sc.nextInt();
            sc.nextLine();
            if (opcion == 1) {
                leercarpeta(carpeta);
            } else {
                leerarchivo(archivo);
            }
        } else if (archivo.exists() && archivo.isFile()) {
            leerarchivo(archivo);
        } else if (carpeta.exists() && carpeta.isDirectory()) {
            leercarpeta(carpeta);
        }
        try {
            escribirArchivo(personasM, "Mujeres");
            escribirArchivo(personasH, "Hombres");
        } catch (IOException |FileMalformed  e) {
            throw new RuntimeException(e);
        }
    }

    private static void leerarchivo(File archivo) {
        try {
            Scanner lector = new Scanner(archivo);
            List<String> personas = new ArrayList<>();
            List<Persona> personas1 = new ArrayList<>();
            while (lector.hasNextLine()) {
                personas.add(lector.nextLine());
            }

            lector.close();

            for (String persona : personas) {
                personas1.add(stringToPersona(persona));
            }
            for (Persona persona : personas1) {
                if (persona != null) {
                    switch (persona.getSexo()) {
                        case H -> personasH.add(persona);
                        case M -> personasM.add(persona);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FileMalformed e) {
            throw new RuntimeException(e);
        }


    }

    private static void escribirArchivo(List<Persona> personas, String name) throws IOException, FileMalformed {
        if (personas.size() > 50) throw new FileMalformed("Más de 50 compradores registrados");
        File persona= new File("output/" + name + ".txt");
        int count = 1;
        while (persona.exists()){
            persona = new File("output/" + name +" ("+ count+ ").txt");
            count++;
        }

        if (!persona.exists()) persona.getParentFile().mkdir();
        FileWriter writer = new FileWriter(persona);
        double sum = 0;
        writer.write(name + ": \n\n");
        for (Persona p : personas) {
            sum += p.mediaPagos();
            writer.write("\t" + p + "\n");
        }
        double media = sum / ((double) (personas.size()));
        writer.write("\nMedia total " + df.format(media) + "\n");
        writer.close();
    }

    private static Persona stringToPersona(String persona) throws FileMalformed {
        Persona pTemp = null;
        String[] datosPersona = persona.split(" ");
        try {
            if (!valida2Apellidos(datosPersona)) {
                String nombre = datosPersona[0];
                String apellido = datosPersona[1];
                int edad = Integer.parseInt(datosPersona[2]);
                String sexo = datosPersona[3];
                String pagos = datosPersona[4];
                for (int i = 5; i < datosPersona.length; i++) {
                    pagos += " " + datosPersona[i];
                }
                pTemp = new Persona(nombre, apellido, edad, sexo, pagos);
            } else {
                String nombre = datosPersona[0];
                String apellido = datosPersona[1];
                String apellido2 = datosPersona[2];
                int edad = Integer.parseInt(datosPersona[3]);
                String sexo = datosPersona[4];
                String pagos = datosPersona[5];
                for (int i = 6; i < datosPersona.length; i++) {
                    pagos += " " + datosPersona[i];
                }
                pTemp = new Persona(nombre, apellido, apellido2, edad, sexo, pagos);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            throw new FileMalformed("Sexo no válido");
        }

        return pTemp;
    }

    private static boolean valida2Apellidos(String[] datosPersona) {
        return datosPersona[2].matches("[A-Za-z]+");
    }

    private static void leercarpeta(File carpeta) {
        File[] ficheros = carpeta.listFiles();
        for (File fichero : ficheros) {
            if (fichero.isFile()) {
                leerarchivo(fichero);
            }
        }
    }
}