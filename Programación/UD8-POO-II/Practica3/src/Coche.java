import java.util.Arrays;

public class Coche {
    private String matricula;
    private String direccionDuenyo;
    private Reparacion[] reparaciones;

    public Reparacion[] getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(Reparacion[] reparaciones) {
        this.reparaciones = new Reparacion[reparaciones.length];
        for (int i = 0; i < reparaciones.length; i++) {
            this.reparaciones[i] = new Reparacion(reparaciones[i].getDescripcion(), reparaciones[i].getKms());
        }
    }

    public Coche(String matricula, String direccionDuenyo, Reparacion[] reparaciones) {
        this.matricula = matricula.toUpperCase();
        this.direccionDuenyo = direccionDuenyo;
        this.reparaciones = new Reparacion[reparaciones.length];
        for (int i = 0; i < reparaciones.length; i++) {
            if (reparaciones[i] != null) {
                this.reparaciones[i] = new Reparacion(reparaciones[i].getDescripcion(), reparaciones[i].getKms());
            } else {
                break;
            }
        }

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula.toUpperCase();
    }

    public String getDireccionDuenyo() {
        return direccionDuenyo;
    }

    public void setDireccionDuenyo(String direccionDuenyo) {
        this.direccionDuenyo = direccionDuenyo;
    }

    public Reparacion[] buscaReparaciones(String palabraClave) {
        int count1 = 0, count2 = 0;
        Reparacion[] busca;
        palabraClave = palabraClave.toLowerCase();
        for (int i = 0; i < reparaciones.length; i++) {
            if (reparaciones[i] != null) {
                if (reparaciones[i].getDescripcion().contains(palabraClave)){
                    count1++;
                }
            } else {
                break;
            }
        }

        busca = new Reparacion[count1];

        for (int i = 0; i < reparaciones.length; i++) {
            if (reparaciones[i] != null) {
                if (reparaciones[i].getDescripcion().contains(palabraClave)){
                    busca[count2] = new Reparacion(reparaciones[i].getDescripcion(), reparaciones[i].getKms());
                    count2++;
                }
            } else {
                break;
            }
        }

        return busca;
    }

    public Reparacion ultimaReparacion() {
        if (reparaciones[0] == null) {
            System.out.println("No hay previas reparaciones");
        } else {
            for (int i = 1; i < reparaciones.length; i++) {
                if (reparaciones[i] == null) {
                    return reparaciones[i - 1];
                } else if (i == reparaciones.length - 1) {
                    return reparaciones[i];
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", direccionDuenyo='" + direccionDuenyo + '\'' +
                ", reparaciones=" + Arrays.toString(reparaciones) +
                '}';
    }

    public void anyadeReparacion(Reparacion r) {
        if (r.getKms() < ultimaReparacion().getKms()) {
            System.err.println("Kilometraje inferior a la anterior");
        } else {
            for (int i = 0; i < reparaciones.length; i++) {
                if (reparaciones[i] == null) {
                    reparaciones[i] = new Reparacion(r.getDescripcion(), r.getKms());
                    break;
                } else if (reparaciones.length - 2 == i) {
                    System.err.println("No se pueden hacer más reparaciones");
                }
            }
        }
    }
}
