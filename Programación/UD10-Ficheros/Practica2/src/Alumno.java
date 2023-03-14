import java.util.List;

public class Alumno {
    private String nombre;

    private String apellido;
    private List<Double> notas;

    public Alumno(String nombre, String apellido, List<Double> notas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.notas = notas;
    }

    public double mediaNotas(){
        double sum = 0;
        for (double nota : notas) {
            sum += nota;
        }
        return sum/notas.size();
    }

    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }
}
