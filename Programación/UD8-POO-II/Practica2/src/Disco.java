public class Disco {
    private String titulo;
    private String fechaEdicion;
    private Cancion[] canciones;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(String fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    public Cancion[] getCanciones() {
        return canciones;
    }

    public Disco(String titulo, String fechaEdicion, Cancion[] canciones) {
        this.titulo = titulo;
        this.fechaEdicion = fechaEdicion;
        this.canciones = new Cancion[canciones.length];
        for (int i = 0; i < canciones.length; i++) {
            this.canciones[i] = new Cancion(canciones[i].getTitulo(), canciones[i].getDuracion());
        }
    }

    public void setCanciones(Cancion[] canciones) {
        this.canciones = new Cancion[canciones.length];
        for (int i = 0; i < canciones.length; i++) {
            this.canciones[i] = new Cancion(canciones[i].getTitulo(), canciones[i].getDuracion());
        }
    }

    public float obtenerDuracionTotal(){
        float duracionTotal = 0;
        for (Cancion cancion : canciones) {
            duracionTotal += cancion.getDuracion();
        }
        return duracionTotal;
    }
    public Cancion obtenerCancion(int numCancion){
        return canciones[numCancion];
    }
}