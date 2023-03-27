import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Persona {
    private final static int maxPagos = 10;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;

    private Sexo sexo;
    private List<Double> pagos;

    public Persona(String nombre, String apellido1, String apellido2, int edad, Sexo sexo, List<Double> pagos) throws FileMalformed {
        if (!validaEdad(edad)) throw new FileMalformed("Edad inválida (valor negativo)");
        if (!validaPagos(pagos)) throw new FileMalformed("Pagos inválidos (valor/es negativo/s)");
        if (pagos.size() > maxPagos) throw new FileMalformed("Pagos sobrepasa el limite permitido (" + maxPagos + ")");

        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.sexo = sexo;
        this.pagos = pagos;
    }

    public Persona(String nombre, String apellido1, int edad, Sexo sexo, List<Double> pagos) throws FileMalformed {
        if (!validaEdad(edad)) throw new FileMalformed("Edad inválida (valor negativo)");
        if (!validaPagos(pagos)) throw new FileMalformed("Pagos inválidos (valor/es negativo/s)");
        if (pagos.size() > maxPagos) throw new FileMalformed("Pagos sobrepasa el limite permitido (" + maxPagos + ")");

        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.edad = edad;
        this.sexo = sexo;
        this.pagos = pagos;
    }

    public Persona(String nombre, String apellido1, String apellido2, int edad, String sexo, String pagos) throws FileMalformed {
        if (!validaEdad(edad)) throw new FileMalformed("Edad inválida (valor negativo)");
        List<Double> pago = stringToArrayListDouble(pagos);
        if (!validaPagos(pago)) throw new FileMalformed("Pagos inválidos (valor/es negativo/s)");
        if (pago.size() > maxPagos) throw new FileMalformed("Pagos sobrepasa el limite permitido (" + maxPagos + ")");

        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        try{
            this.sexo = Sexo.valueOf(sexo);
        } catch (IllegalArgumentException e){
            throw new FileMalformed("Sexo no válido");
        }
        this.pagos = pago;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Persona(String nombre, String apellido1, int edad, String sexo, String pagos) throws FileMalformed {
        if (!validaEdad(edad)) throw new FileMalformed("Edad inválida (valor negativo)");
        List<Double> pago = stringToArrayListDouble(pagos);
        if (!validaPagos(pago)) throw new FileMalformed("Pagos inválidos (valor/es negativo/s)");
        if (pago.size() > maxPagos) throw new FileMalformed("Pagos sobrepasa el limite permitido (" + maxPagos + ")");

        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.edad = edad;
        try{
            this.sexo = Sexo.valueOf(sexo);
        } catch (IllegalArgumentException e){
            throw new FileMalformed("Sexo no válido");
        }
        this.pagos = pago;
    }

    private boolean validaEdad(int edad){
        return edad > 0;
    }

    private List<Double> stringToArrayListDouble(String pagos) throws NumberFormatException{
        List<Double> pago = new ArrayList<>();
        String[] pagos2 = pagos.split(" ");
        for (String p : pagos2) {
            pago.add(Double.parseDouble(p));
        }
        return pago;
    }

    private boolean validaPagos(List<Double> pagos){
        for (double pago : pagos){
            if (pago < 0) return false;
        }
        return true;
    }

    public double mediaPagos(){
        double sum = 0;
        for (double pago : pagos){
            sum += pago;
        }
        return sum / ((double) (pagos.size()));
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        String apellidos = apellido1;
        if (apellido2 != null) apellidos += " " + apellido2;
        return  nombre + " " + apellidos + " " + edad + " " + sexo + " " + df.format(mediaPagos());
    }
}
