public class ReproductorDiscos {
    private boolean estado;
    private Cancion cancionactual;
    private int numcancion;
    private Disco disco;
    public boolean reproducir(int numCancion){
        cancionactual = new Cancion(disco.obtenerCancion(numCancion).getTitulo(), disco.obtenerCancion(numCancion).getDuracion());
        numcancion = numCancion;
        estado = true;
        return true;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Cancion getCancionactual() {
        return cancionactual;
    }

    public void setCancionactual(Cancion cancionactual) {
        this.cancionactual = new Cancion(cancionactual.getTitulo(), cancionactual.getDuracion());
    }

    public ReproductorDiscos(Disco disco) {
        this.estado = false;
        this.cancionactual = new Cancion(disco.obtenerCancion(0).getTitulo(), disco.obtenerCancion(0).getDuracion());
        this.numcancion = 0;
        this.disco = new Disco(disco.getTitulo(), disco.getFechaEdicion(), disco.getCanciones());
    }

    public int getNumcancion() {
        return numcancion;
    }

    public void setNumcancion(int numcancion) {
        this.numcancion = numcancion;
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = new Disco(disco.getTitulo(), disco.getFechaEdicion(), disco.getCanciones());
    }

    public boolean detener(){
        estado = false;
        return false;
    }
    public void siguiente(){
        if (numcancion+1 <= disco.getCanciones().length-1) {
            cancionactual = new Cancion(disco.obtenerCancion(numcancion+1).getTitulo(), disco.obtenerCancion(numcancion+1).getDuracion());
            numcancion++;
        } else {
            cancionactual = new Cancion(disco.obtenerCancion(0).getTitulo(), disco.obtenerCancion(0).getDuracion());
            numcancion = 0;
        }
    }
    public void anterior(){
        if (numcancion-1 >= 0) {
            System.out.println(numcancion);
            cancionactual = new Cancion(disco.obtenerCancion(numcancion-1).getTitulo(), disco.obtenerCancion(numcancion-1).getDuracion());
            numcancion--;
        } else {
            numcancion = disco.getCanciones().length -1;
            System.out.println(numcancion);
            cancionactual = new Cancion(disco.obtenerCancion(numcancion).getTitulo(), disco.obtenerCancion(numcancion).getDuracion());
        }

    }
    public void cargarCD(Disco newDisc){
        this.disco = newDisc;
    }
}
