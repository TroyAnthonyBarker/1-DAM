package es.iesmz.ed.algoritmes;

public class Hyperpar {
    private long numero;

    /**
     * Constructor de Hyperpar.
     *
     * @param numero número que se guarda.
     */
    public Hyperpar(long numero) {
        this.numero = numero;
    }


    /**
     * esHyperpar es un metodo que comprueba si el número guardado es hyperpar.
     *
     * @return boolean true si el número guardado es hyperpar.
     */
    public boolean esHyperPar(){
        return String.valueOf(numero).matches("[02468]+");
    }

}
