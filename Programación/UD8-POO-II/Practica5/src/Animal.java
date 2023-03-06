import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Animal {
    private String nombre;
    private LocalDate fechaNac;
    private String estado;
    private String tipoAnimal;

    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public Animal(String nombre, LocalDate fechaNac, String estado, String tipoAnimal) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.estado = estado;
        this.tipoAnimal = tipoAnimal;
    }

    public Animal(String nombre, LocalDate fechaNac, String estado) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.estado = estado;
    }

    public String toStringLimitado() {
        return "Tipo: " + tipoAnimal + ", nombre: " + nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public DateTimeFormatter getFormat() {
        return format;
    }

    public String getEstado() {
        return estado;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

}
