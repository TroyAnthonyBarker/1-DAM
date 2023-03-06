public class Barco extends Acuatico{
    private boolean tieneMotor;

    public Barco(String matricula, String modelo, double eslora, boolean tieneMotor) {
        super(matricula, modelo, eslora);
        this.tieneMotor = tieneMotor;
    }

    @Override
    public String toString() {
        String motor = "No";
        if (tieneMotor) motor = "Sí";
        return "Vehículo tipo: Acuático" +
                " Matricula: " + super.getMatricula() +
                " Modelo: " + super.getModelo() +
                " Eslora: " + super.getEslora() +
                " Tiene motor: " + motor;
    }
}
