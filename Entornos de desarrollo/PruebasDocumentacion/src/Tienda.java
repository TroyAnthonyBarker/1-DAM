
public class Tienda {

    private List<ProductoNuevo> inventario;


    public Tienda() {
        inventario = new ArrayList<>();
    }

    
    public void agregarProducto(ProductoNuevo producto) {
        inventario.add(producto);
    }

    
    public ProductoNuevo buscarProducto(String nombre) {
        for (ProductoNuevo producto : inventario) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }

  
    public boolean realizarVenta(String nombre, int cantidad) {
        ProductoNuevo producto = buscarProducto(nombre);
        if (producto != null && producto.getCantidadDisponible() >= cantidad) {
            producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidad);
            return true;
        }
        return false;
    }
}