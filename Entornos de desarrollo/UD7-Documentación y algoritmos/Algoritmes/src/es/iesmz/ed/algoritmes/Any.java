package es.iesmz.ed.algoritmes;

public class Any {

    private long any;


    /**
     * Constructor en el cual le pasamos el valor del any
     * @param any número de any
     */
    public Any(long any) {
        this.any = any;
    }


    /**
     * Método que cuenta los distintos dígitos en el any
     *
     * @return int de la cantidad de dígitos distintos
     */
    public int digitsDiferents(){
        char[] anyDigit = String.valueOf(any).toCharArray();
        int count = 1;
        for (int i = 1; i < anyDigit.length; i++) {
            if (anyDigit[0] != anyDigit[i]){
                count++;
            }
        }
        return count;
    }
}
