import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MiniFileManager {

    private String pwd;

    public MiniFileManager(String pwd) {
        this.pwd = pwd;
    }

    public void help(){
        System.out.println("""
                    • pwd:  Muestra cual es la carpeta actual.
                    • cd <DIR>: Cambia la carpeta actual a ‘DIR’. Con .. cambia a la carpeta superior.
                    • ls:   Muestra la lista de directorios y archivos de la carpeta actual (primero directorios,
                            luego archivos, ambos ordenados alfabéticamente).
                    • ll:   Como ls pero muestra también el tamaño y la fecha de última modificación.
                    • mkdir <DIR>:  Crea el directorio ‘DIR’ en la carpeta actual.
                    • rm <FILE>:    Borra ‘FILE’. Si es una carpeta, borrará primero sus archivos y luego la
                                    carpeta. Si tiene subcarpetas, las dejará intactas y mostrará un aviso al usuario.
                    • mv <FILE1> <FILE2>:   Mueve o renombra ‘FILE1’ a ‘FILE2’.
                    • help: Muestra una breve ayuda con los comandos disponibles.
                    • exit: Termina el programa.         
                """);
    }

    public void mv(String parametro) {
        
    }

    public boolean rm(String parametro) throws FileNotFoundException {
        boolean ok = false;
        File x = new File(parametro);
        if (!x.exists()) throw new FileNotFoundException("Fichero no existe");
        if (x.isFile()) {
            x.delete();
            ok = true;
        } else {
            File[] z = x.listFiles();
            for (int i = 0; i < z.length; i++) {
                if (z[i].isDirectory()) {
                    ok = false;
                    System.err.println("El directorio contiene subdirectorios, NO SE HA REALIZADO LA OPERACIÓN");
                    break;
                } else {
                    z[i].delete();
                    ok = true;
                }
            }
        }

        return ok;
    }

    public boolean mkdir(String parametro) {
        boolean ok;
        File f = new File(parametro);
        if (f.exists()) {
            ok = false;
            System.err.println("El fichero/directorio ya existe");
        } else {
            ok = f.mkdir();
        }

        return ok;
    }

    public void ll() {
        File[] d = new File(pwd).listFiles();
        Arrays.sort(d);
        for (File file : d) {
            if (file.isDirectory()) System.out.println(file.getName() + " Tamaño Bytes: " + file.length() + " Última modificación: " + file.lastModified());
        }
        for (File file : d) {
            if (file.isFile()) System.out.println(file.getName() + " Tamaño Bytes: " + file.length() + " Última modificación: " + file.lastModified());
        }
    }

    public void ls() {
        File[] d = new File(pwd).listFiles();
        Arrays.sort(d);
        for (File file : d) {
            if (file.isDirectory()) System.out.println(file.getName());
        }
        for (File file : d) {
            if (file.isFile()) System.out.println(file.getName());
        }
    }

    public boolean cd(String ruta) {
        String[] parametros = ruta.split("/");
        File tempPWD = new File(pwd);
        ruta = "";
        for (int i = 0; i < parametros.length; i++) {
            if (parametros[i].equals("..")){
                ruta += tempPWD.getParent();
                tempPWD = new File(ruta);
            } else {
                ruta += parametros[i] + "/";
            }
        }
        File destino = new File(ruta);

        if (destino.exists()){
            pwd = ruta;
            return true;
        } else {
            System.err.println("Destino no existe");
            return false;
        }
    }

    public String getPwd() {
        return pwd;
    }
}
