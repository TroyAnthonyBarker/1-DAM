/**
 * Esta clase representa un objeto de tipo Producto.
 * Contiene información sobre el nombre, precio y cantidad disponible del producto.
 *
 * @deprecated Esta clase está obsoleta. Se recomienda utilizar la clase ProductoNuevo.
 * @see ProductoNuevo
 * @version 1.0
 * @author John Doe
 */
public class Producto {

    private String nombre;
    private double precio;
    private int cantidadDisponible;

    /**
     * Constructor de la clase Producto.
     *
     * @param nombre El nombre del producto.
     * @param precio El precio del producto.
     * @param cantidadDisponible La cantidad disponible del producto.
     */
    public Producto(String nombre, double precio, int cantidadDisponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *tiene el precio del Ob producto.
     *
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad disponible del producto.
     *
     * @return La cantidad disponible del producto.
     */
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    /**
     * Establece la cantidad disponible del producto.
     *
     * @param cantidadDisponible La nueva cantidad disponible del producto.
     */
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    /**
     * Calcula el valor total del inventario de este producto.
     *
     * @param cantidad La cantidad de productos en el inventario.
     * @return El valor total del inventario.
     */
    public double calcularValorInventario(int cantidad) {
        return precio * cantidad;
    }
}