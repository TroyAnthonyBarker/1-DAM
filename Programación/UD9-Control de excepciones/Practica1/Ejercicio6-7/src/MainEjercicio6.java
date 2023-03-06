public class MainEjercicio6 {
    public static void main(String[] args) {
        try {
            Gato gato1 = new Gato("Hola", 23);
            // Gato gato2 = new Gato("Ho", 23);
            // Gato gato3 = new Gato("Hola", -1);
            gato1.imprimir();
            gato1.setNombre("Juan");
            //gato1.setNombre("Ho");
            gato1.setEdad(15);
            //gato1.setEdad(-1);
            gato1.imprimir();
        } catch (InvalidAgeException | InvalidNameException e) {
            e.printStackTrace();
        }

    }
}
