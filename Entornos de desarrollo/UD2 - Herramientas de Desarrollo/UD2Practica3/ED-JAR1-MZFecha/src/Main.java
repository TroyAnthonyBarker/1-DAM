public class Main {
    public static void main(String[] args) {
        MZFecha m = new MZFecha();
        MZFecha n = new MZFecha(2, 1, 1970);
        m.imprime();
        m.diferenciaDias(n);
    }
}