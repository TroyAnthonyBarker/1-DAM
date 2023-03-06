import java.util.Scanner;

public class Ejercicio1 {

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Utilidades.sca = new Scanner(System.in);

        String fullName = Utilidades.pideNombre();
        String dni = Utilidades.pideDNI();

        System.out.println("Tu codigo de usuarios es: " + codigo(fullName, dni));

        int cantidadProductos = Utilidades.pideCantidad();
        double[] preciosProductos = Utilidades.preciosProductos(cantidadProductos);

        showResults(preciosProductos);
    }

    static void showResults (double[] preciosProductos) {
        int descuento = descuento(preciosProductos);
        double subtotal = suma(preciosProductos), descuentoAplicado = descuentoAplicado(descuento, preciosProductos);
        System.out.println("");
        System.out.println("Los precios de los productos son:");
        Utilidades.muestraArrayDoublePrice(preciosProductos);
        System.out.println("El subtotal es: " + subtotal);
        System.out.println("El descuento a aplicar es: " + descuento + "%");
        System.out.println("El descuento a aplicar es: " + descuentoAplicado + "€");
        System.out.println("El precio tota es: " + (subtotal - descuentoAplicado));
    }


    static String codigo(String fullName, String dni) {
        String name = Utilidades.userName(fullName);
        String surname1 = Utilidades.userSurname1(fullName);
        String surname2 = Utilidades.userSurname2(fullName);
        char firstLetterSurname1 = surname1.charAt(0);
        char firstLetterSurname2 = surname2.charAt(0);
        String codigo;
        int numDNI = Utilidades.numDNI(dni);
        codigo = "" + name + firstLetterSurname1 + firstLetterSurname2 + numDNI;
        return codigo.toUpperCase();
    }

    public static double suma(double[] v) {
        int suma = 0;
        for (double j : v) {
            suma += j;
        }
        return suma;
    }

    public static boolean mayores(double[] v, int x) {
        for (double j : v) {
            return j > x;
        }
        return false;
    }

    static double difmaxmin(double[] v) {
        double max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (double j : v) {
            if (j > max && j < min) {
                max = j;
                min = j;
            } else if (j > max) {
                max = j;
            } else if (j < min) {
                min = j;
            }
        }
        return max - min;

    }

    static double descuentoAplicado (int descuento, double[] precios) {
        return (suma(precios)*descuento)/100;
    }

    static int descuento (double[] precios) {
        int descuentoAplicado = 3;
        if (difmaxmin(precios) > 100) {
            descuentoAplicado += 10;
        }
        if (mayores(precios, 99)) {
            descuentoAplicado += 9;
        } else if (mayores(precios, 66)) {
            descuentoAplicado += 6;
        }
        if (suma(precios) > 100) {
            descuentoAplicado += 5;
        }

        return descuentoAplicado;
    }
}
