public class Ejercicio74 {
    public static void main(String[] args) {
        Articulo a1 = new Articulo("Sudadera", 15, 21, 23);
        Articulo a2 = new Articulo("", 0, 0, 0);
        Articulo a3 = new Articulo("Camiseta", -16, 21, 15);
        Articulo a4 = new Articulo(), a5 = new Articulo();

        /*Articulo a4 = new Articulo("Chaqueta", 49.99, 15, 16);
        Articulo a5 = new Articulo("Zapatillas", 75, 21, -15);*/

        a4.setNombre("Chaqueta");
        a4.setPrecio(49.99);
        a4.setIva(15);
        a4.setCuantosQuedan(16);

        a5.setNombre("Zapatillas");
        a5.setPrecio(75);
        a5.setIva(21);
        a5.setCuantosQuedan(-15);

        a1.printArticulo();
        a2.printArticulo();
        a3.printArticulo();
        a4.printArticulo();
        a5.printArticulo();
    }
}
