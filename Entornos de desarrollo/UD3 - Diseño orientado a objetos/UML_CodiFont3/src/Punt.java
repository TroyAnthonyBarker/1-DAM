public class Punt {
    private int id;
    private static int countPunts;
    private int x;
    private int y;

    public Punt(int x, int y) {
        this.id = countPunts;
        countPunts++;
        this.x = x;
        this.y = y;
    }
}