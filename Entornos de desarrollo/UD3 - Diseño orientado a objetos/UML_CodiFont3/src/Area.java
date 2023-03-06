import java.util.ArrayList;

public class Area {
    private int id;
    private static int countAreas;
    private Punt[] punts = new Punt[3];

    public Area(Punt punt1, Punt punt2, Punt punt3) {
        this.id = countAreas;
        countAreas++;
        this.punts[0] = punt1;
        this.punts[1] = punt2;
        this.punts[2] = punt3;
    }
}
