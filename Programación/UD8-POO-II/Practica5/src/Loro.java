import java.time.LocalDate;

public class Loro extends Animal{
    private Boolean longPico;
    private String origen;


    public Loro(String nombre, LocalDate fechaNac, String estado, Boolean longPico, String origen) {
        super(nombre, fechaNac, estado, "Loro");
        this.longPico = longPico;
        this.origen = origen;
    }

    private String longPicoToString(){
        if (longPico){
            return "largo";
        }else {
            return "corto";
        }
    }

    public Boolean getLongPico() {
        return longPico;
    }

    public String getOrigen() {
        return origen;
    }

    @Override
    public String toString() {
        return "Tipo: " + super.getTipoAnimal() +
                ", nombre: " + super.getNombre() +
                ", estado del animal: " + super.getEstado() +
                ", fecha de nacimiento: " + super.getFechaNac().format(super.getFormat()) +
                ", longitud del pico: " + longPicoToString() +
                ", origen: " + origen;
    }
}
