public abstract class Vehiculo {
    private final String matricula;
    private final String modelo;

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public Vehiculo(String matricula, String modelo, String formato) {
        if (!matricula.matches(formato)){
            this.matricula= null;
            System.err.println("Matrícula no válida");
        } else {
            this.matricula = matricula;
        }
        this.modelo = modelo;
    }
    @Override
    public abstract String toString();

}
