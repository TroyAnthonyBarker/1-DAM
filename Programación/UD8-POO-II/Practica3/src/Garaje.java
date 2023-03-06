import java.util.Arrays;

public class Garaje {
    private Coche[] coches;

    public Garaje() {
        this.coches = new Coche[100];
    }

    public Coche[] getCoches() {
        return coches;
    }

    public void setCoches(Coche[] coches) {
        this.coches = coches;
    }

    public void anyadeCoche(Coche coche) {
        boolean mIgual = false;
        for (Coche c : coches) {
            if (c != null) {
                if (c.getMatricula().equals(coche.getMatricula())) {
                    mIgual = true;
                    break;
                }
            }
        }
        if (!mIgual) {
            for (int i = 0; i < coches.length; i++) {
                if (coches[i] == null) {
                    if (coche.getReparaciones() != null) {
                        coches[i] = new Coche(coche.getMatricula(), coche.getDireccionDuenyo(), coche.getReparaciones());
                        break;
                    } else {
                        coches[i] = new Coche(coche.getMatricula(), coche.getDireccionDuenyo(), null);
                        break;
                    }
                } else if (coches.length - 1 == i) {
                    System.err.println("No se pueden añadir más coches");
                }
            }
        } else {
            System.err.println("Matrícula ya registrada");
        }
    }

    @Override
    public String toString() {
        return "Garaje{" +
                "coches=" + Arrays.toString(coches) +
                '}';
    }

    public Coche buscaCoche(String matricula) {
        for (int i = 0; i < coches.length; i++) {
            if (coches[i] != null){
                if (coches[i].getMatricula().equals(matricula.toUpperCase())) {
                    return coches[i];
                } else if (coches.length - 1 == i) {
                    System.err.println("Coche no existe");
                }
            } else {
                System.err.println("Coche no existe");
                break;
            }
        }
        return null;
    }
}
