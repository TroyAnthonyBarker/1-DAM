public class Avion extends Aereo{
    private double timepoDeVuelo;

    public Avion(String matricula, String modelo, int numAsientos, double timepoDeVuelo) {
        super(matricula, modelo, numAsientos);
        this.timepoDeVuelo = timepoDeVuelo;
    }

    @Override
    public String toString() {
        return "Vehículo tipo: Aéreo" +
                " Matricula: " + super.getMatricula() +
                " Modelo: " + super.getModelo() +
                " Número de asientos: " + super.getNumAsientos() +
                " Tiempo de vuelo: " + this.timepoDeVuelo;
    }
}
