public class Articulo {
    private String nombre;
    private double precio;
    private int iva;
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

    public Articulo(String nombre, double precio, int iva, int cuantosQuedan) {
        if (nombre.equals("") || precio < 0 || iva != 21 || cuantosQuedan < 0){
            System.err.println("ERROR al instanciar");
        } else {
            this.nombre = nombre;
            this.precio = precio;
            this.iva = iva;
            this.cuantosQuedan = cuantosQuedan;
        }
    }
}
