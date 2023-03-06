import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el dni");
        String dni = sc.nextLine();
        System.out.println("Introduce tu nombre completo (Nombre apellido1 apellido2)");
        String nombreCompleto = sc.nextLine();
        System.out.println("Introduce la fecha de nacimiento(dd/MM/yyyy)");
        String fNacimiento = sc.nextLine();
        System.out.println("Introduce el número de teléfono");
        String telefono = sc.nextLine();
        System.out.println("Introduce tu ciudad");
        String ciudad = sc.nextLine();

        try {
            Persona persona = new Persona(dni, nombreCompleto, fNacimiento, telefono, ciudad);
        } catch (InvalidDNIException | InvalidNameException | InvalidFNacimientoException | InvalidAgeException e) {
            e.printStackTrace();
        }
    }
}
