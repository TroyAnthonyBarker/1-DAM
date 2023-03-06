
import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {

    private final String iban;
    private final String titular;
    private double saldo;
    private List<String> movimiento;

    private final double avisarAcienda;
    private final double invalidSaldo;
    private final int tamanyoMaximoArray;

    private boolean validaIBAN(String iban){
        return iban.matches("[A-Z]{2}\\d{22}");
    }

    private boolean validaTitular(String titular){
        String[] nombreCompleto= titular.split(" ");
        return nombreCompleto.length == 3;
    }

    private void actualizarMovimientos(String movimiento){
        if (this.movimiento.size() < tamanyoMaximoArray){
            this.movimiento.add(0,"Saldo: " + saldo + "€ Movimiento: " + movimiento + "€");
        } else {
            this.movimiento.add(0,"Saldo: " + saldo + "€ Movimiento: " + movimiento + "€");
            this.movimiento.remove(tamanyoMaximoArray);
        }
    }

    public CuentaBancaria(String iban, String titular) throws InvalidIBANException, InvalidTitularException {
        if (!validaIBAN(iban)) throw new InvalidIBANException("IBAN no válido");
        if (!validaTitular(titular)) throw new InvalidTitularException("Titular no válido");

        this.iban = iban;
        this.titular = titular;
        this.saldo = 0;
        movimiento = new ArrayList<>();
        movimiento.add("Saldo: " + saldo + "€");
        this.avisarAcienda = 3000;
        this.invalidSaldo = -50;
        this.tamanyoMaximoArray = 100;
    }

    public void ingresos(double ingreso) throws InvalidIngresoException, AvisoException{
        if (ingreso < 0) throw new InvalidIngresoException("No se puede ingresar número negativos, intenta retirar");
        if (ingreso >= avisarAcienda) throw new AvisoException("Notificar a hacienda");

        saldo += ingreso;
        actualizarMovimientos("+" + ingreso);
    }

    public void retirada(double retirada) throws InvalidRetiradaExeption, AvisoException{
        if (retirada < 0) throw new InvalidRetiradaExeption("No se puede retirar número negativos, intenta ingresar");
        if (retirada >= avisarAcienda) throw new AvisoException("Notificar a hacienda");
        if ((saldo-retirada) <= invalidSaldo) throw new InvalidRetiradaExeption("Retirada invalida saldo insuficiente");
        saldo -= retirada;
        actualizarMovimientos("-" + retirada);
    }

    public String movimientos() {
        String movimientos = "";
        for (int i = 0; i < movimiento.size(); i++) {
            movimientos += (i+1) + "- " + movimiento.get(i) + '\n';
        }
        return movimientos;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "iban='" + iban.toUpperCase() + '\'' +
                ", titular='" + getTitular() + '\'' +
                ", saldo=" + saldo + "€" +
                '}';
    }

    public String getSaldo() {
        return saldo + "€";
    }

    public String getIban() {
        return iban.toUpperCase();
    }

    public String getTitular() {
        String[] primeraMayuscula = titular.split(" ");
        String nombre = primeraMayuscula[0];
        String apellido1 = primeraMayuscula[1];
        String apellido2 = primeraMayuscula[2];
        nombre = nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
        apellido1 = apellido1.substring(0,1).toUpperCase() + apellido1.substring(1).toLowerCase();
        apellido2 = apellido2.substring(0,1).toUpperCase() + apellido2.substring(1).toLowerCase();
        String titular = nombre + " " + apellido1 + " " + apellido2;
        return titular;
    }
}
