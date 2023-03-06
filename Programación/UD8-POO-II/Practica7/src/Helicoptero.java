public class Helicoptero extends Aereo{
    private int numHelices;

    public Helicoptero(String matricula, String modelo, int numAsientos, int numHelices) {
        super(matricula, modelo, numAsientos);
        this.numHelices = numHelices;
    }

    @Override
    public String toString() {
        return "Vehículo tipo: Aéreo" +
                " Matricula: " + super.getMatricula() +
                " Modelo: " + super.getModelo() +
                " Número de asientos: " + super.getNumAsientos() +
                " Número de hélices: " + this.numHelices;
    }
}
