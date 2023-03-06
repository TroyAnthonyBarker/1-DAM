public class Aereo extends Vehiculo{

    private final int numAsientos;

    private static final String formato = "[a-zA-Z]{4}+\\d{6}";

    public Aereo(String matricula, String modelo, int numAsientos) {
        super(matricula, modelo, formato);
        this.numAsientos = numAsientos;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    @Override
    public String toString() {
        return "Vehículo tipo: Aéreo" +
                " Matricula: " + super.getMatricula() +
                " Modelo: " + super.getModelo() +
                " Número de asientos: " + this.numAsientos;
    }
}
