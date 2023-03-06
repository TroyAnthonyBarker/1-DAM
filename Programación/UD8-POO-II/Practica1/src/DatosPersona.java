
public class DatosPersona {
    private String nombre;
    private String tlf;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public DatosPersona(String nombre, String tlf) {
        this.nombre = nombre;
        this.tlf = tlf;
    }
}