public class Reparacion {
    private String descripcion;
    private int kms;

    public Reparacion(String descripcion, int kms) {
        this.descripcion = descripcion.toLowerCase();
        this.kms = kms;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Reparacion{" +
                "descripcion='" + descripcion + '\'' +
                ", kms=" + kms +
                '}';
    }

    public int getKms() {
        return kms;
    }
}
