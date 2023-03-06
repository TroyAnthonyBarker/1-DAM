import java.util.ArrayList;

public class Linia {
    private int id;
    private static int countLinias;
    private Punt[] punts = new Punt[2];

    public Linia(Punt punt1, Punt punt2) {
        this.id = countLinias;
        countLinias++;
        this.punts[0] = punt1;
        this.punts[1] = punt2;
    }
}
