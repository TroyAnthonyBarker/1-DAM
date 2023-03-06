import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Perro extends Animal{
    private String color;
    private String raza;

    public Perro(String nombre, LocalDate fechaNac, String estado, String color, String raza) {
        super(nombre, fechaNac, estado, "Perro");
        this.color = color;
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Tipo: " + super.getTipoAnimal() +
                ", nombre: " + super.getNombre() +
                ", estado del animal: " + super.getEstado() +
                ", fecha de nacimiento: " + super.getFechaNac().format(super.getFormat()) +
                ", color: " + color +
                ", raza: " + raza;
    }
}
