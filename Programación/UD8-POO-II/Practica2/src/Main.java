import java.util.Scanner;

public class Main {
    static int opcion;
    static ReproductorDiscos reproductor;
    static Cancion[] canciones;
    static Disco disco;
    public static void main(String[] args) {
        Utilidades.scx = new Scanner(System.in);
        canciones = canciones();
        disco = disco(canciones);
        reproductor = reproductor(disco);
        do {
            menu();
            opcion = Utilidades.pideInt("Opción: ");
            selectOpcion();
            System.out.println();
            System.out.println(reproductor.getCancionactual().getTitulo());
            System.out.println(reproductor.getEstado());
            System.out.println();

        } while (opcion != 0);

    }
    public static void menu() {
        System.out.println("""
                Obciones:
                    1. Reproducir
                    2. Detener
                    3. Siguiente
                    4. Anterior
                    0. Salir
                """);
    }
    public static void selectOpcion(){
        switch (opcion) {
            case 0 -> {
                System.out.println("Adios");
            }
            case 1 -> {
                Cancion[] canciones = new Cancion[reproductor.getDisco().getCanciones().length];
                for (int i = 0; i < canciones.length; i++) {
                    canciones[i] = new Cancion(reproductor.getDisco().obtenerCancion(i).getTitulo(), reproductor.getDisco().obtenerCancion(i).getDuracion());
                }
                for (int i = 0; i < canciones.length; i++) {
                    System.out.println(i+1 + " " + canciones[i].getTitulo());
                }
                reproductor.reproducir(Utilidades.pideIntMinMax(1, canciones.length, "Elige la canción: ")-1);
            }
            case 2 -> {
                reproductor.detener();
            }
            case 3 -> {
                reproductor.siguiente();
            }
            case 4 -> {
                reproductor.anterior();
            }
        }
    }
    public static Cancion[] canciones(){
        Cancion[] canciones = new Cancion[3];
        canciones[0] = new Cancion("Canción 1", 3.45);
        canciones[1] = new Cancion("Canción 2", 3.45);
        canciones[2] = new Cancion("Canción 3", 3.45);
        return canciones;
    }
    public static Disco disco(Cancion[] canciones){
        return new Disco("Disco 1", "01/09/2015", canciones);
    }

    public static ReproductorDiscos reproductor(Disco disco) {
        return new ReproductorDiscos(disco);
    }
}
