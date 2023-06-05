package es.iesmz.ed.algoritmes;

public class Polidivisible {
    private long numero;

    /**
     * Constructor al cual le pasamos el número.
     *
     * @param numero que deseas utilizar
     */
    public Polidivisible(long numero) {
        this.numero = numero;
    }

    /**
     * Función que comprueba si el número es divisible por su longitud.
     *
     * @param num número que desea comprobar.
     * @return boolean True si es divisible por su longitud y false en caso contrario.
     */
    public boolean comprovarCeroFinsLenghtMenosUno(String num){
        return Long.parseLong(num) % num.length() == 0;
    }

    /**
     * Función que comprueba si el número es un número Polidivisible.
     *
     * @return boolean True si es un número Polidivisible y False en caso contrario.
     */
    public boolean esPolidivisible(){
        String num = String.valueOf(numero);
        while (num.length() > 0){
            if (!comprovarCeroFinsLenghtMenosUno(num)){
                return false;
            }
            num = num.substring(0, num.length()-1);
        }
        return true;
    }
}
