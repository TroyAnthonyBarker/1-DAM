import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Gato extends Animal{
    private String color;

    private String pelo;

    public Gato(String nombre, LocalDate fechaNac, String estado, String color, String pelo) {
        super(nombre, fechaNac, estado, "Gato");
        this.color = color;
        validaPelo(pelo);
    }

    private void validaPelo(String pelo) {
        switch (pelo.toLowerCase()){
            case "largo" -> this.pelo = "largo";
            case "medio" -> this.pelo = "medio";
            case "corto" -> this.pelo = "corto";
            default ->{
                System.err.println("Pelo introducido no valido (Pelo asignado a corto)");
                this.pelo = "corto";
            }
        }
    }

    @Override
    public String toString() {
        return "Tipo: " + super.getTipoAnimal() +
                ", nombre: " + super.getNombre() +
                ", estado del animal: " + super.getEstado() +
                ", fecha de nacimiento: " + super.getFechaNac().format(super.getFormat()) +
                ", color: " + color +
                ", longitud del pelo: " + pelo;
    }
}
