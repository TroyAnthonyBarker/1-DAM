package es.iesmz.ed.algoritmes;

public class SumaDescendent {
    private long numero;

    /**
     * Constructor.
     *
     * @param numero long.
     */
    public SumaDescendent(long numero) {
        this.numero = numero;
    }

    /**
     * Función que hace una suma descendiente.
     *
     * @return long con el resultado.
     */
    public long suma(){
        long suma = 0;
        String num = String.valueOf(numero);
        for (int i = 0; i < num.length(); i++) {
            suma += Integer.parseInt(num.substring(i));
        }
        return suma;
    }
}
