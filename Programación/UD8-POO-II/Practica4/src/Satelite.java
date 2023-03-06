import java.util.Objects;

public class Satelite extends Astro {
    private float distanciaAlPlaneta;
    private float orbitaPlanetaria;
    private Planeta planetaAlQuePertenece;

    public float getDistanciaAlPlaneta() {
        return distanciaAlPlaneta;
    }

    @Override
    public String toString() {
        return "Satelite{" +
                "distanciaAlPlaneta=" + distanciaAlPlaneta +
                ", orbitaPlanetaria=" + orbitaPlanetaria +
                ", planetaAlQuePertenece=" + planetaAlQuePertenece +
                '}';
    }

    public void setDistanciaAlPlaneta(float distanciaAlPlaneta) {
        this.distanciaAlPlaneta = distanciaAlPlaneta;
    }

    public float getOrbitaPlanetaria() {
        return orbitaPlanetaria;
    }

    public void setOrbitaPlanetaria(float orbitaPlanetaria) {
        this.orbitaPlanetaria = orbitaPlanetaria;
    }

    public Planeta getPlanetaAlQuePertenece() {
        return planetaAlQuePertenece;
    }

    public void setPlanetaAlQuePertenece(Planeta planetaAlQuePertenece) {
        copyPlaneta(planetaAlQuePertenece);
    }

    public void muestra() {
        System.out.print("Satelite{");
        super.muestra();
        System.out.println("distanciaAlPlaneta=" + distanciaAlPlaneta +
                ", orbitaPlanetaria=" + orbitaPlanetaria +
                ", planetaAlQuePertenece=" + planetaAlQuePertenece +
                '}');
    }

    public Satelite(float radioEcuatorial, float rotacionSobreSuEje, float masa, float temperaturaMedia, float gravedad, float distanciaAlPlaneta, float orbitaPlanetaria, Planeta planetaAlQuePertenece) {
        super(radioEcuatorial, rotacionSobreSuEje, masa, temperaturaMedia, gravedad);
        this.distanciaAlPlaneta = distanciaAlPlaneta;
        this.orbitaPlanetaria = orbitaPlanetaria;
        copyPlaneta(planetaAlQuePertenece);
    }

    public Satelite(float radioEcuatorial, float rotacionSobreSuEje, float masa, float temperaturaMedia, float gravedad, float distanciaAlPlaneta, float orbitaPlanetaria) {
        super(radioEcuatorial, rotacionSobreSuEje, masa, temperaturaMedia, gravedad);
        this.distanciaAlPlaneta = distanciaAlPlaneta;
        this.orbitaPlanetaria = orbitaPlanetaria;
    }

    public void copyPlaneta(Planeta planeta) {
        if (planeta.isTieneSatelites()) {
            this.planetaAlQuePertenece = new Planeta(
                    planeta.getRadioEcuatorial(),
                    planeta.getRotacionSobreSuEje(),
                    planeta.getMasa(),
                    planeta.getTemperaturaMedia(),
                    planeta.getGravedad(),
                    planeta.getDistanciaAlSol(),
                    planeta.getOrbitaAlSol(),
                    planeta.getSatelites()
            );
        } else {
            this.planetaAlQuePertenece = new Planeta(
                    planeta.getRadioEcuatorial(),
                    planeta.getRotacionSobreSuEje(),
                    planeta.getMasa(),
                    planeta.getTemperaturaMedia(),
                    planeta.getGravedad(),
                    planeta.getDistanciaAlSol(),
                    planeta.getOrbitaAlSol()
            );
        }
    }
}
