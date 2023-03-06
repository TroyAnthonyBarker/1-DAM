public class Main {
    public static void main(String[] args) {
        Planeta planeta1 = new Planeta(
                78,
                98,
                54,
                21,
                23,
                12,
                45
        );

        Satelite satelite1 = new Satelite(
                12,
                13,
                150,
                89,
                45,
                48,
                89
        );

        planeta1.muestra();

        planeta1.anyadirSatelite(satelite1);

        planeta1.muestra();

        satelite1.muestra();

    }
}
