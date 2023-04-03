package es.iesmz.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vocales2Test {
    @Test
    void sinvocales1() {
        String real = Vocales2.sinvocales("Hola Mundo");
        String expected = "Hl Mnd";
        assertEquals(expected, real);
    }

    @Test
    void sinvocales2() {
        String real = Vocales2.sinvocales("Esto Es una cadenA");
        String expected = "st s n cdn";
        assertEquals(expected, real);
    }

    @Test
    void sinvocales3() {
        String real = Vocales2.sinvocales("Java mola MogollOn");
        String expected = "Jv ml Mglln";
        assertEquals(expected, real);
    }

    @Test
    void sinvocales4() {
        String real = Vocales2.sinvocales("4h0r4 s0n num3r0s");
        String expected = "4h0r4 s0n nm3r0s";
        assertEquals(expected, real);
    }

    @Test
    void sinvocales5() {
        String real = Vocales2.sinvocales("Cadena Sin Vocales");
        String expected = "Cdn Sn Vcls";
        assertEquals(expected, real);
    }

}