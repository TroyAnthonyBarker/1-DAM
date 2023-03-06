public class Rectangulo {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int lado1;
    private int lado2;

    public Rectangulo(){}

    public void printRectangulo() {
        System.out.println("\tLas coordenadas son: " + getCoordenadas());
        System.out.println("\tEl perimetro es: " + perimetro());
        System.out.println("\tEl área es: " + area());
        System.out.println();
    }

    public String getCoordenadas() {
        return "(" + x1 + ", " + y1 + ") (" + x2 + ", " + y2 + ")";
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public int getLado1() {
        generateLados();
        return lado1;
    }

    public int getLado2() {
        generateLados();
        return lado2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public Rectangulo(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void generateLados() {
        lado1 = x1 - x2;

        if (lado1 < 0) {
            lado1 = lado1 * -1;
        }

        lado2 = y1 - y2;

        if (lado2 < 0) {
            lado2 = lado2 * -1;
        }
    }

    public int perimetro() {
        generateLados();
        return lado1*2 + lado2*2;
    }

    public int area() {
        generateLados();
        return lado1 * lado2;
    }
}
