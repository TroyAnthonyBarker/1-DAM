public class Gato {
    private String nombre;
    private int edad;

    public Gato(String nombre, int edad) throws InvalidNameException, InvalidAgeException {
        if (!checkName(nombre)) throw new InvalidNameException("Debe tener al menos 3 caracteres");
        if (!checkAge(edad)) throw new InvalidAgeException("Edad no pude ser un valor negativo");

        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws InvalidNameException {
        if (!checkName(nombre)) throw new InvalidNameException("Debe tener al menos 3 caracteres");
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws InvalidAgeException {
        if (!checkAge(edad)) throw new InvalidAgeException("Edad no pude ser un valor negativo");
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    public void imprimir(){
        System.out.println(this);
    }

    private boolean checkName(String name) {
        return name.length() >= 3;
    }

    private boolean checkAge(int age){
        return age >= 0;
    }
}
