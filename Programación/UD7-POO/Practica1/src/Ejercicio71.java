public class Ejercicio71 {

    public static void main(String[] args) {
	    Punto primerPunto = new Punto(5, 0);
	    Punto segundoPunto = new Punto(10, 10);
        Punto tercerPunto = new Punto(-3, 7);

        primerPunto.printPunto();
        segundoPunto.printPunto();
        tercerPunto.printPunto();

        // Suma 3 a las coordenadas del primer punto
        System.out.println((primerPunto.getX()+3) + "," + (primerPunto.getY()+3));

        // Resta 2 al doble del segundo punto
        System.out.println((segundoPunto.getX()*2-2) + "," + (segundoPunto.getY()*2-2));

        // Divide entre dos el quintuple del tercer punto
        System.out.println((tercerPunto.getX()*5/2) + "," + (tercerPunto.getY())*5/2);
    }
}
