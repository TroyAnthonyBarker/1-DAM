package es.iesmz.ed.algoritmes;

public class Cablejat {
    private String[] conectores;

    /**
     * Constructor al que le pasamos los cables.
     *
     * @param conectores String[] con los conectores de cada cable.
     */
    public Cablejat(String[] conectores) {
        this.conectores = conectores;
    }

    /**
     * Función que dice si se pueden conectar todos los cables.
     *
     * @return boolean. True si se puede y False si no se puede.
     */
    public boolean esPotConnectar(){
        int cantidadH = 0;
        int cantidadM = 0;
        for (String conector : conectores) {
            for (int j = 0; j < conector.length(); j++) {
                if (conector.toLowerCase().charAt(j) == 'm') {
                    cantidadM++;
                } else if (conector.toLowerCase().charAt(j) == 'h') {
                    cantidadH++;
                }
            }
        }
        return cantidadM == cantidadH;
    }
}
