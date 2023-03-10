package es.iesmz.test;

public class DiasLluvia {
    private boolean[][] lluvia;

    public DiasLluvia() {
        lluvia = new boolean[12][30];
    }

    public boolean registroDia(int dia, int mes, boolean lluvia){
        this.lluvia[mes-1][dia-1] = lluvia;
        return true;
    }

    public boolean consultarDia(int dia, int mes){
        return lluvia[mes-1][dia-1];
    }

    public int contarDiasLluviosos(){
        int count = 0;
        for (int i = 0; i < lluvia.length; i++) {
            for (int j = 0; j < lluvia[i].length; j++) {
                if (lluvia[i][j]) count++;
            }
        }
        return count;
    }

    public int trimestreLluvioso(){
        int t1 = 0, t2 = 0, t3 = 0, t4 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < lluvia[i].length; j++) {
                if (lluvia[i][j]) t1++;
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < lluvia[i].length; j++) {
                if (lluvia[i][j]) t2++;
            }
        }
        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < lluvia[i].length; j++) {
                if (lluvia[i][j]) t3++;
            }
        }
        for (int i = 9; i < 12; i++) {
            for (int j = 0; j < lluvia[i].length; j++) {
                if (lluvia[i][j]) t4++;
            }
        }

        if (t1 > t2 && t1 > t3 && t1 > t4) return 1;
        else if (t2 > t1 && t2 > t3 && t2 > t4) return 2;
        else if (t3 > t1 && t3 > t2 && t3 > t4) return 3;
        else return 4;
    }

    public int primerDiaLluvia(){
        int diaLluvia = 0;
        for (int i = 0; i < lluvia.length; i++) {
            for (int j = 0; j < lluvia[i].length; j++) {
                if (lluvia[i][j]) return  (i*30)+j+1;
            }
        }
        return diaLluvia;
    }
}
