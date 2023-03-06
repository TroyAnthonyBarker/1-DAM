public class Ejercicio74 {
    public static void main(String[] args) {
        Articulo a1 = new Articulo("Sudadera", 15, 21, 23);
        Articulo a2 = new Articulo("", 0, 0, 0);
        Articulo a3 = new Articulo("Camiseta", -16, 21, 15);
        Articulo a4 = new Articulo("Chaqueta", 49.99, 15, 16);
        Articulo a5 = new Articulo("Zapatillas", 75, 21, -15);

        a1.printArticulo();
        a2.printArticulo();
        a3.printArticulo();
        a4.printArticulo();
        a5.printArticulo();
    }
}
