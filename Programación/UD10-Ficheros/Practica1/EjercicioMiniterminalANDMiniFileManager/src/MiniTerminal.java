import java.util.Scanner;

public class MiniTerminal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bien venido a la terminal, si necesitas ayuda escriba help");
        String interaccion = "";
        MiniFileManager manager = new MiniFileManager("C:/");
        do {
            System.out.print(manager.getPwd() + "> ");
            try {
                interaccion = sc.nextLine();
                manager.interaccion(interaccion);
            }catch (StringIndexOutOfBoundsException e){
                System.out.println("Parámetros no válidos");
            }
        } while (!interaccion.equals("exit"));
    }
}
