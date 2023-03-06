public class Terrestre extends Vehiculo{

    private final int numRuedas;
    private static final String formato = "\\d{4}+[a-zA-Z]{3}";


    public Terrestre(String matricula, String modelo, int numRuedas) {
        super(matricula, modelo, formato);
        this.numRuedas = numRuedas;
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    @Override
    public String toString() {
        return "Vehículo tipo: Terrestre" +
                " Matricula: " + super.getMatricula() +
                " Modelo: " + super.getModelo() +
                " Número de ruedas: " + this.numRuedas;
    }
}
