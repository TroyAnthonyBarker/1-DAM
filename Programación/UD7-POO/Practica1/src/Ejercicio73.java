public class Ejercicio73 {
    public static void main(String[] args) {
        Rectangulo r1 = new Rectangulo(0,0, 5,5);
        Rectangulo r2 = new Rectangulo(7,9, 2, 3);

        System.out.println("Primer rectangulo:");
        r1.printRectangulo();

        System.out.println("Segundo rectangulo:");
        r2.printRectangulo();

        r1.setX1(2);
        r1.setY1(5);
        r1.setX2(9);
        r1.setY2(10);

        r2.setX1(0);
        r2.setY1(2);
        r2.setX2(5);
        r2.setY2(7);

        System.out.println("Primer rectangulo:");
        r1.printRectangulo();

        System.out.println("Segundo rectangulo:");
        r2.printRectangulo();
    }
}
