import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Reparacion[] reparacions = new Reparacion[6];

        Reparacion r0 = new Reparacion("Rueda pinchada", 200);
        Reparacion r1 = new Reparacion("Rueda pinchada", 150);

        reparacions[0] = r0;
        reparacions[1] = r1;

        Coche[] coches = new Coche[5];
        coches[0] = new Coche("1234ert", "Mi casa", reparacions);
        coches[1] = new Coche("7894hjk", "Mi casa", reparacions);
        coches[2] = new Coche("1594hyg", "Mi casa", reparacions);
        coches[3] = new Coche("1978srf", "Mi casa", reparacions);
        coches[4] = new Coche("7894hjk", "Mi casa", reparacions);

        Garaje g = new Garaje();

        for (int i = 0; i < coches.length; i++) {
            g.anyadeCoche(coches[i]);
        }

        Reparacion r2 = new Reparacion("Cambio aceite", 300);
        Reparacion r3 = new Reparacion("Cambio filtro", 500);
        Reparacion r4 = new Reparacion("Cambio filtro", 600);


        g.getCoches()[0].anyadeReparacion(r3);
        g.getCoches()[0].anyadeReparacion(r2);
        g.getCoches()[0].anyadeReparacion(r4);
        g.getCoches()[0].anyadeReparacion(r4);
        g.getCoches()[0].anyadeReparacion(r4);



        System.out.println("Coches buscados");
        System.out.println(g.buscaCoche("1594hyg").toString());
        System.out.println(g.buscaCoche("1234ert").toString());

        System.out.println();

        Reparacion[] busca = g.getCoches()[0].buscaReparaciones("rueda");

        System.out.println("Reparaciones del coche 1 que contenga Rueda");
        for (int i = 0; i < busca.length; i++) {
            System.out.println(busca[i].toString());
        }

        System.out.println();

        System.out.println("Última reparación del coche 1");
        System.out.println(g.getCoches()[0].ultimaReparacion().toString());

    }
}