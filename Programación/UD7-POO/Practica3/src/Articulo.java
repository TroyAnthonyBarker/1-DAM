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
        if (nombre.equals("")){
            System.err.println("ERROR al instanciar");
        } else {
            this.nombre = nombre;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0){
            System.err.println("ERROR al instanciar");
            this.precio = 0;
        } else {
            this.precio = precio;
        }
    }

    public int getCuantosQuedan() {
        return cuantosQuedan;
    }

    public void setCuantosQuedan(int cuantosQuedan) {
        if (cuantosQuedan < 0){
            System.err.println("ERROR al instanciar");
        } else {
            this.cuantosQuedan = cuantosQuedan;
        }
    }

    public void setIva(int iva) {
        if (iva != 21){
            System.err.println("ERROR al instanciar");
        } else {
            this.iva = iva;
        }
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
