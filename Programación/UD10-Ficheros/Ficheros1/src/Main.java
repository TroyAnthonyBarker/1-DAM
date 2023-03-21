/*
Implementa un programa que cree, dentro de ‘Archivos’, tres nuevas carpetas: ‘Nóminas’,
'Declaraciones de Renta' y ‘Clientes’. Mueve las carpetas ‘Enero’ y ‘Febrero’ dentro
de ‘Nómminas’. Luego crea dentro de ‘Clientes’ una carpeta por cada cliente
(en mayúsculas) de los introducidos previamente por pantalla, con un fichero con sus datos personales
en cada carpeta.
NOTA: Deberéis tener creada la carpeta 'Archivos' en el propio proyecto, así como 'Enero' y 'Febrero' dentro de
'Archivos'. El resto lo creará el programa que implementéis.
Clientes:
Cliente 1
Nombre: Jose Rodriguez Soria
Edad: 43
Ciudad: Alicante
Cliente 2
Nombre: Natalia Quiroga Pérez
Edad: 32
Ciudad: Benidorm
Cliente 3
Nombre: Nuria Sapiña Faez
Edad: 63
Ciudad: Madrid
Cliente 4
Nombre: Marcos Gavilán
Edad: 28
Ciudad: San Juan

 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static File archivos = new File("Archivos");

    public static void main(String[] args) {
        System.out.println("Creación de la carpeta Nóminas: " + crearCarpetas("Nóminas"));
        System.out.println("Creación de la carpeta Declaraciones de Renta: " + crearCarpetas("Declaraciones de Renta"));
        System.out.println("Creación de la carpeta Clientes: " + crearCarpetas("Clientes"));

        System.out.println("Carpeta Enero movido: " + moverCarpetas(new File(archivos.getPath() + "/Enero"), archivos.getPath() + "/Nóminas/Enero"));
        System.out.println("Carpeta Febrero movido: " + moverCarpetas(new File(archivos.getPath() + "/Febrero"), archivos.getPath() + "/Nóminas/Febrero"));

        try{
            System.out.println("Creación de carpetas de clientes con datos personales: " + crearCarpetaClientes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static boolean crearCarpetas(String nombre){
        File carpeta = new File(archivos.getPath() + "/" + nombre);
        return carpeta.mkdir();
    }

    static boolean crearCarpetaClientes() throws IOException {
        File clientes = new File(archivos.getPath() + "/DatosClientes.txt");
        Scanner lector = new Scanner(clientes);
        List<String> datosCliente = new ArrayList<>();
        while (lector.hasNextLine()){
            datosCliente.add(lector.nextLine());
        }
        lector.close();
        File cliente = null;
        for (int i = 0; i < datosCliente.size(); i++) {
            if (i % 4 == 0){
                cliente = new File(archivos.getPath() + "/Clientes/" + datosCliente.get(i).toUpperCase());
                cliente.mkdir();
            } else {
                FileWriter writer = new FileWriter(cliente + "/Datos Personales.txt", true);
                writer.write(datosCliente.get(i) + "\n");
                writer.close();
            }
        }
        return true;
    }

    static boolean moverCarpetas(File origen, String pathDestination){
        File destination = new File(pathDestination);
        return origen.renameTo(destination);
    }
}
