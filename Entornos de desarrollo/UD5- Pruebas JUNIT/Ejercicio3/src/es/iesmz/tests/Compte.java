package es.iesmz.tests;

import java.math.BigInteger;

public class Compte {
    private String iban;

    public Compte(String iban) {
        this.iban = iban;
    }

    public boolean compruebaIBAN(String anaven){
        if (!anaven.matches("[ES]{2}+\\d{22}")) return false;
        String es00 = "142800";
        String xx = anaven.substring(2, 4);
        String ccc = anaven.substring(4);
        String numAComprobar = ccc + es00;
        return new BigInteger(xx).equals(BigInteger.valueOf(98).subtract(new BigInteger(numAComprobar).remainder(BigInteger.valueOf(97))));
    }

    public String generaIBAN(String entitat, String oficina, String dc, String compte){
        if (!entitat.matches("\\d*") ||
        !oficina.matches("\\d*") ||
        !dc.matches("\\d*") ||
        !compte.matches("\\d*")) return null;
        String es00 = "142800";
        String ccc = entitat + oficina + dc + compte;
        BigInteger numAComprobar = new BigInteger(ccc + es00);
        int xx = BigInteger.valueOf(98).subtract(numAComprobar.remainder(BigInteger.valueOf(97))).intValue();
        String iban = "ES" + xx + entitat + oficina + dc + compte;
        if (iban.length() == 24) return iban;
        else return null;
    }
}
