public class Coche extends Terrestre{
    private boolean aire;

    public Coche(String matricula, String modelo, boolean aire) {
        super(matricula, modelo, 4);
        this.aire = aire;
    }

    @Override
    public String toString() {
        String aire = "No";

        if (this.aire)aire = "Sí";

        return "Vehículo tipo: Terrestre" +
                " Matricula: " + super.getMatricula() +
                " Modelo: " + super.getModelo() +
                " Número de ruedas: " + super.getNumRuedas() +
                " Aire Acondicionado: " + aire
                ;
    }
}
