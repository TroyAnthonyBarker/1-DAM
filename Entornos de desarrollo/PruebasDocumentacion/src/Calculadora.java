/**
 * Esta es una clase que representa una calculadora básica.
 * Puede realizar operaciones de suma, resta, multiplicación y división.
 */
public class Calculadora {

    /**
     * Este método realiza una operación de suma entre dos números enteros.
     *
     * @param a El primer número.
     * @param b El segundo número.
     * @return El resultado de la suma.
     */
    public int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Este método realiza una operación de resta entre dos números enteros.
     *
     * @param a El número del cual se resta.
     * @param b El número a restar.
     * @return El resultado de la resta.
     */
    public int restar(int a, int b) {
        return a - b;
    }

    /**
     * Este método realiza una operación de multiplicación entre dos números enteros.
     *
     * @param a El primer número.
     * @param b El segundo número.
     * @return El resultado de la multiplicación.
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Este método realiza una operación de división entre dos números enteros.
     *
     * @param a El número dividendo.
     * @param b El número divisor.
     * @return El resultado de la división.
     * @throws ArithmeticException Si se intenta dividir por cero.
     */
    public int dividir(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return a / b;
    }
}