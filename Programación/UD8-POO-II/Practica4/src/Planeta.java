import java.util.Arrays;
import java.util.Objects;

public class Planeta extends Astro {
    private float distanciaAlSol;
    private float orbitaAlSol;
    private boolean tieneSatelites;
    private Satelite[] satelites;
    private int numSatelites;

    public Planeta(float radioEcuatorial, float rotacionSobreSuEje, float masa, float temperaturaMedia, float gravedad, float distanciaAlSol, float orbitaAlSol) {
        super(radioEcuatorial, rotacionSobreSuEje, masa, temperaturaMedia, gravedad);
        this.distanciaAlSol = distanciaAlSol;
        this.orbitaAlSol = orbitaAlSol;
        this.tieneSatelites = false;
        this.satelites = new Satelite[0];
    }

    public Planeta(float radioEcuatorial, float rotacionSobreSuEje, float masa, float temperaturaMedia, float gravedad, float distanciaAlSol, float orbitaAlSol, Satelite[] satelites) {
        super(radioEcuatorial, rotacionSobreSuEje, masa, temperaturaMedia, gravedad);
        this.distanciaAlSol = distanciaAlSol;
        this.orbitaAlSol = orbitaAlSol;
        copySatelites(satelites);
        this.tieneSatelites = true;
    }

    public void copySatelites(Satelite[] satelites) {
        this.satelites = new Satelite[satelites.length];

        for (int i = 0; i < satelites.length; i++) {
            if (satelites[i] != null) {
                this.satelites[i] = new Satelite(
                        satelites[i].getRadioEcuatorial(),
                        satelites[i].getRotacionSobreSuEje(),
                        satelites[i].getMasa(),
                        satelites[i].getTemperaturaMedia(),
                        satelites[i].getGravedad(),
                        satelites[i].getDistanciaAlPlaneta(),
                        satelites[i].getOrbitaPlanetaria(),
                        satelites[i].getPlanetaAlQuePertenece()
                );
            }
        }
    }

    public float getDistanciaAlSol() {
        return distanciaAlSol;
    }

    public void setDistanciaAlSol(float distanciaAlSol) {
        this.distanciaAlSol = distanciaAlSol;
    }

    public float getOrbitaAlSol() {
        return orbitaAlSol;
    }

    public void setOrbitaAlSol(float orbitaAlSol) {
        this.orbitaAlSol = orbitaAlSol;
    }

    public boolean isTieneSatelites() {
        return tieneSatelites;
    }

    public Satelite[] getSatelites() {
        return satelites;
    }

    public void setSatelites(Satelite[] satelites) {
        this.tieneSatelites = true;
        copySatelites(satelites);
    }

    @Override
    public String toString() {
        return "Planeta{" +
                "distanciaAlSol=" + distanciaAlSol +
                ", orbitaAlSol=" + orbitaAlSol +
                ", tieneSatelites=" + tieneSatelites +
                ", satelites=" + Arrays.toString(satelites) +
                ", numSatelites=" + numSatelites +
                '}';
    }

    public void muestra() {
        System.out.print("Planeta{");
        super.muestra();
        System.out.println(
                ", " +
                "distanciaAlSol=" + distanciaAlSol +
                ", orbitaAlSol=" + orbitaAlSol +
                ", tieneSatelites=" + tieneSatelites +
                ", satelites=" + Arrays.toString(satelites) +
                ", numSatelites=" + numSatelites +
                '}');
    }

    public void anyadirSatelite(Satelite satelite) {
        Satelite[] temp = new Satelite[this.satelites.length + 1];

        for (int i = 0; i < satelites.length; i++) {
            temp[i] = new Satelite(
                    satelites[i].getRadioEcuatorial(),
                    satelites[i].getRotacionSobreSuEje(),
                    satelites[i].getMasa(),
                    satelites[i].getTemperaturaMedia(),
                    satelites[i].getGravedad(),
                    satelites[i].getDistanciaAlPlaneta(),
                    satelites[i].getOrbitaPlanetaria(),
                    satelites[i].getPlanetaAlQuePertenece()
            );
        }

        satelites = new Satelite[temp.length + 1];

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != null) {
                satelites[i] = new Satelite(
                        temp[i].getRadioEcuatorial(),
                        temp[i].getRotacionSobreSuEje(),
                        temp[i].getMasa(),
                        temp[i].getTemperaturaMedia(),
                        temp[i].getGravedad(),
                        temp[i].getDistanciaAlPlaneta(),
                        temp[i].getOrbitaPlanetaria(),
                        temp[i].getPlanetaAlQuePertenece()
                );
            }
        }

        satelites[numSatelites] = new Satelite(
                satelite.getRadioEcuatorial(),
                satelite.getRotacionSobreSuEje(),
                satelite.getMasa(),
                satelite.getTemperaturaMedia(),
                satelite.getGravedad(),
                satelite.getDistanciaAlPlaneta(),
                satelite.getOrbitaPlanetaria(),
                thisPlaneta()
        );
        numSatelites++;
        this.tieneSatelites = true;
    }

    public Planeta thisPlaneta() {
        Planeta thisPlaneta = new Planeta(
                this.getRadioEcuatorial(),
                this.getRotacionSobreSuEje(),
                this.getMasa(),
                this.getTemperaturaMedia(),
                this.getGravedad(),
                this.getDistanciaAlSol(),
                this.getOrbitaAlSol()
        );
        return thisPlaneta;
    }
}
