package es.iesmz.ed.algoritmes;

public class SumaDescendent {
    private int numero;

    public SumaDescendent(int numero) {
        this.numero = numero;
    }

    public int sumaDescendiente(){
        int suma = 0;
        String num = String.valueOf(numero);
        for (int i = 0; i < num.length(); i++) {
            suma += Integer.parseInt(num.substring(i));
        }
        return suma;
    }
}
