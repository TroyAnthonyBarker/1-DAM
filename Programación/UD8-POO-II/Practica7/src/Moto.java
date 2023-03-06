public class Moto extends Terrestre{
    private String color;

    public Moto(String matricula, String modelo, String color) {
        super(matricula, modelo, 2);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehículo tipo: Terrestre" +
                " Matricula: " + super.getMatricula() +
                " Modelo: " + super.getModelo() +
                " Número de ruedas: " + super.getNumRuedas() +
                " Color: " + this.color;
    }
}
