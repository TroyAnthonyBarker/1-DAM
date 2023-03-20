package es.iesmz.tests;


import static org.junit.jupiter.api.Assertions.assertEquals;

class CompteTest {

    @org.junit.jupiter.api.Test
    public void testcompruebaIBAN1() {
        Compte x = new Compte("ES6621000418401234567891");
        Boolean resultadoReal = x.compruebaIBAN("ES6621000418401234567891");
        Boolean resultadoEsperado = true;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    public void testcompruebaIBAN2() {
        Compte x = new Compte("ES6000491500051234567892");
        Boolean resultadoReal = x.compruebaIBAN("ES6000491500051234567892");
        Boolean resultadoEsperado = true;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    public void testcompruebaIBAN3() {
        Compte x = new Compte("ES9420805801101234567891");
        Boolean resultadoReal = x.compruebaIBAN("ES9420805801101234567891");
        Boolean resultadoEsperado = true;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    public void testcompruebaIBAN4() {
        Compte x = new Compte("ES7600246912501234567891");
        Boolean resultadoReal = x.compruebaIBAN("ES7600246912501234567891");
        Boolean resultadoEsperado = false;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    public void testcompruebaIBAN5() {
        Compte x = new Compte("ES4721000418401234567891");
        Boolean resultadoReal = x.compruebaIBAN("ES4721000418401234567891");
        Boolean resultadoEsperado = false;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    public void testcompruebaIBAN6() {
        Compte x = new Compte("ES8200491500051234567892");
        Boolean resultadoReal = x.compruebaIBAN("ES8200491500051234567892");
        Boolean resultadoEsperado = false;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    public void testgeneraIBAN1() {
        Compte x = new Compte(null);
        String resultadoReal = x.generaIBAN("0030", "2053", "09", "1234567895");
        String resultadoEsperado = "ES7100302053091234567895";
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    public void testgeneraIBAN2() {
        Compte x = new Compte(null);
        String resultadoReal = x.generaIBAN("0049", "2352", "08", "2414205416");
        String resultadoEsperado = "ES1000492352082414205416";
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    public void testgeneraIBAN3() {
        Compte x = new Compte(null);
        String resultadoReal = x.generaIBAN("2085", "2066", "62", "3456789011");
        String resultadoEsperado = "ES1720852066623456789011";
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    public void testgeneraIBAN4() {
        Compte x = new Compte(null);
        String resultadoReal = x.generaIBAN("2085","2066","62","3456AE9011");
        String resultadoEsperado = null;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    public void testgeneraIBAN5() {
        Compte x = new Compte(null);
        String resultadoReal = x.generaIBAN("208","2066","62","3456789011");
        String resultadoEsperado = null;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    public void testgeneraIBAN6() {
        Compte x = new Compte(null);
        String resultadoReal = x.generaIBAN("2080","20A6","62","3456789011");
        String resultadoEsperado = null;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    public void testgeneraIBAN7() {
        Compte x = new Compte(null);
        String resultadoReal = x.generaIBAN("2080","2086","6","3456789011");
        String resultadoEsperado = null;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    public void testgeneraIBAN8() {
        Compte x = new Compte(null);
        String resultadoReal = x.generaIBAN("2080","2086","63","345678911");
        String resultadoEsperado = null;
        assertEquals(resultadoEsperado, resultadoReal);
    }
}