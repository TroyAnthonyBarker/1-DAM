public class Acuatico extends Vehiculo{

    private final double eslora;
    private static final String formato = "[a-zA-Z]{3,10}";

    public Acuatico(String matricula, String modelo, double eslora) {
        super(matricula, modelo, formato);
        this.eslora = eslora;
    }

    public double getEslora() {
        return eslora;
    }

    @Override
    public String toString() {
        return "Vehículo tipo: Acuático" +
                " Matricula: " + super.getMatricula() +
                " Modelo: " + super.getModelo() +
                " Eslora: " + this.eslora;
    }
}
