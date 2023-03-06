import java.time.DateTimeException;
import java.time.LocalDate;

public class Persona {
    private String dni, nombreCompleto, fNacimiento, telefono, ciudad;

    public Persona() {
    }

    public Persona(String dni, String nombreCompleto, String fNacimiento, String telefono, String ciudad)
            throws InvalidDNIException, InvalidNameException, InvalidFNacimientoException, InvalidAgeException {

        if (!validaDNI(dni)) throw new InvalidDNIException("EL DNI no es válido");
        if (!validaNombreCompleto(nombreCompleto)) throw new InvalidNameException("Nombre no valido debes introducir nombre apellido y segundo apellido");
        if (!validaFNacimiento(fNacimiento)) throw new InvalidFNacimientoException("El formato de la fecha de nacimiento no es correcto");
        if (!validaEdad(fNacimiento)) throw new InvalidAgeException("No tiene 18 años");

        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.fNacimiento = fNacimiento;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    private boolean validaDNI(String dni){
        return dni.matches("[A-Za-z]?\\d{7,8}[A-Za-z]");
    }

    private boolean validaNombreCompleto(String nombreCompleto) {
        String[] nombre = nombreCompleto.split(" ");
        return nombre.length == 3;
    }

    private boolean validaFNacimiento(String fNacimiento){
        return fNacimiento.matches("\\d{2}+/+\\d{2}+/+\\d{4}");
    }

    private boolean validaEdad(String fNacimiento){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.now();
        String[] fechaNac = fNacimiento.split("/");
        try {
            fechaNacimiento = LocalDate.of(Integer.parseInt(fechaNac[2]), Integer.parseInt(fechaNac[1]), Integer.parseInt(fechaNac[0]));
        } catch (DateTimeException e){
            e.printStackTrace();
        }
        return fechaActual.compareTo(fechaNacimiento) >= 18;
    }
}
