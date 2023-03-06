abstract class Astro {
    private float radioEcuatorial;
    private float rotacionSobreSuEje;
    private float masa;
    private float temperaturaMedia;
    private float gravedad;

    public Astro(float radioEcuatorial, float rotacionSobreSuEje, float masa, float temperaturaMedia, float gravedad) {
        this.radioEcuatorial = radioEcuatorial;
        this.rotacionSobreSuEje = rotacionSobreSuEje;
        this.masa = masa;
        this.temperaturaMedia = temperaturaMedia;
        this.gravedad = gravedad;
    }

    public void muestra() {
        System.out.print("RadioEcuatorial=" + radioEcuatorial +
                ", rotacionSobreSuEje=" + rotacionSobreSuEje +
                ", masa=" + masa +
                ", temperaturaMedia=" + temperaturaMedia +
                ", gravedad=" + gravedad);
    }

    public float getRadioEcuatorial() {
        return radioEcuatorial;
    }

    public void setRadioEcuatorial(float radioEcuatorial) {
        this.radioEcuatorial = radioEcuatorial;
    }

    public float getRotacionSobreSuEje() {
        return rotacionSobreSuEje;
    }

    public void setRotacionSobreSuEje(float rotacionSobreSuEje) {
        this.rotacionSobreSuEje = rotacionSobreSuEje;
    }

    public float getMasa() {
        return masa;
    }

    public void setMasa(float masa) {
        this.masa = masa;
    }

    public float getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(float temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public float getGravedad() {
        return gravedad;
    }

    public void setGravedad(float gravedad) {
        this.gravedad = gravedad;
    }
}
