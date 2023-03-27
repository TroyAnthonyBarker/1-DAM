package es.iesmz.clases;

public class Cuenta {
    private double saldo;

    public Cuenta() {
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void ingresar(double saldo) {
        if (saldo >= 0 && saldo <= 6000) this.saldo += saldo;
    }

    public void retirar(double saldo) {
        if (saldo <= this.saldo && saldo >= 0 && saldo <= 6000) this.saldo -= saldo;
    }

    public void transpasar(double cantidad, Cuenta c2) {
        if (cantidad <= 3000) {
            c2.ingresar(cantidad);
            retirar(cantidad);
        }
    }
}
