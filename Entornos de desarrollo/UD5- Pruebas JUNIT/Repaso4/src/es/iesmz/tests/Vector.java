package es.iesmz.tests;
public class Vector {
    public static int[] reverso(int[] v){
        int [] reverso = new int[v.length];
        for (int i = 0; i < reverso.length; i++) {
                reverso[i] = v[v.length-i-1];
        }
        return reverso;
    }

}
