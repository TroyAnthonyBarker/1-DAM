import java.io.FileNotFoundException;
import java.util.Scanner;

public class MiniTerminal {

    static MiniFileManager manager;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bien venido a la terminal, si necesitas ayuda escriba help");
        String interaccion = "";
        manager = new MiniFileManager("C:/");
        do {
            System.out.print(manager.getPwd() + "> ");
            try {
                interaccion = sc.nextLine();
                interaccion(interaccion);
            }catch (StringIndexOutOfBoundsException e){
                System.out.println("Parámetros no válidos");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } while (!interaccion.equals("exit"));
    }

    public static void interaccion(String interaccion) throws FileNotFoundException {
        String comando = interaccion.split(" ")[0];
        switch (comando){
            case "pwd" -> System.out.println(manager.getPwd() + " > " + manager.getPwd());
            case "cd" -> manager.cd(parametros(interaccion));
            case "ls" -> manager.ls();
            case "ll" -> manager.ll();
            case "mkdir" -> manager.mkdir(parametros(interaccion));
            case "rm" -> manager.rm(parametros(interaccion));
            case "mv" -> manager.mv(parametros(interaccion));
            case "help" -> manager.help();
        }
    }

    private static String parametros(String interaccion) {
        return interaccion.substring(interaccion.indexOf(" "));
    }

}
