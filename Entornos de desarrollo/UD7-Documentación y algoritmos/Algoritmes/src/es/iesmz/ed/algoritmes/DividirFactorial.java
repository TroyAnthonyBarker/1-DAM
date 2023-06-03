package es.iesmz.ed.algoritmes;

public class DividirFactorial {

    private int numerador;
    private int denominador;

    /**
     * Constructor de DividirFactorial
     *
     * @param numerador guarda el numerador de la división
     * @param denominador guarda el denominador de la división
     */
    public DividirFactorial(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    /**
     * Metodo que divide el factorial del numerador entre el factorial del denominador
     *
     * @return int resultado de la división
     */
    public int divisio(){
        int numera = factorial(numerador);
        int deno = factorial(denominador);
        return numera/deno;
    }

    /**
     * Método que devuelve el factorial de un número.
     *
     * @param num número que se le pasa para sacar el factorial.
     *
     * @return int devuelve el factorial del número pasado.
     */
    public int factorial(int num){
        int factorial=1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
