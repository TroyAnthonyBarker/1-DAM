public class Articulo {
    private String nombre;
    private double precio;
    private int iva = 21;
    private int cuantosQuedan;
    private double pvp;

    public String getNombre() {
        return nombre;
    }

    public void printArticulo() {
        generatePvp();
        System.out.println(nombre + " - Precio: " + precio + "€ - IVA: " + iva + "% - PVP: " + pvp + "€");
    }

    public int getIva() {
        return iva;
    }

    public void generatePvp() {
        pvp = precio * iva / 100 + precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCuantosQuedan() {
        return cuantosQuedan;
    }

    public void setCuantosQuedan(int cuantosQuedan) {
        this.cuantosQuedan = cuantosQuedan;
    }

    public Articulo(){}

    public Articulo(String nombre, int precio, int cuantosQuedan) {
        this.nombre = nombre;
        this.precio = precio;
        this.cuantosQuedan = cuantosQuedan;
    }
}
