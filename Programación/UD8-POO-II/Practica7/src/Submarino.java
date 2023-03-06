public class Submarino extends Acuatico{
    private double profundidadMaxima;

    public Submarino(String matricula, String modelo, double eslora, double profundidadMaxima) {
        super(matricula, modelo, eslora);
        this.profundidadMaxima = profundidadMaxima;
    }

    @Override
    public String toString() {
        return "Vehículo tipo: Acuático" +
                " Matricula: " + super.getMatricula() +
                " Modelo: " + super.getModelo() +
                " Eslora: " + super.getEslora() +
                " Profundidad máxima: " + this.profundidadMaxima;
    }
}
