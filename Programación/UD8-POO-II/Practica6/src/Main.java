import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Articulo1", 10);
        Producto producto2 = new Producto("Articulo2", 10);
        Producto producto3 = new Producto("Articulo3", 10);
        Producto producto4 = new Producto("Articulo4", 10);
        Producto producto5 = new Producto("Articulo1", 10);
        List<Producto> arrayListProducto = new ArrayList<>();

        arrayListProducto.add(producto1);
        arrayListProducto.add(producto2);
        arrayListProducto.add(producto3);
        arrayListProducto.add(producto4);
        arrayListProducto.add(producto5);

        muestraProductos(arrayListProducto);

        arrayListProducto.remove(3);
        arrayListProducto.remove(producto2);
        arrayListProducto.add(3, producto5);

        muestraProductos(arrayListProducto);

        arrayListProducto.clear();
    }

    public static void muestraProductos(List lista) {
        for(Iterator it = lista.iterator(); it.hasNext();) {
             Producto p = (Producto) it.next();
            System.out.println(p);
        }
        System.out.println();
    }
}
