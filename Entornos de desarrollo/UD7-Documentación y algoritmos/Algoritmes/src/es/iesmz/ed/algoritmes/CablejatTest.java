package es.iesmz.ed.algoritmes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CablejatTest {

    @Test
    void esPotConnectar1() {
        Cablejat cablejat = new Cablejat(new String[]{"MH"});
        assertTrue(cablejat.esPotConnectar());
    }

    @Test
    void esPotConnectar2() {
        Cablejat cablejat = new Cablejat(new String[]{"HM"});
        assertTrue(cablejat.esPotConnectar());
    }

    @Test
    void esPotConnectar3() {
        Cablejat cablejat = new Cablejat(new String[]{"HH"});
        assertFalse(cablejat.esPotConnectar());
    }

    @Test
    void esPotConnectar4() {
        Cablejat cablejat = new Cablejat(new String[]{"MM"});
        assertFalse(cablejat.esPotConnectar());
    }

    @Test
    void esPotConnectar5() {
        Cablejat cablejat = new Cablejat(new String[]{"MH", "HH", "MM"});
        assertTrue(cablejat.esPotConnectar());
    }

    @Test
    void esPotConnectar6() {
        Cablejat cablejat = new Cablejat(new String[]{"MH", "HH", "HH"});
        assertFalse(cablejat.esPotConnectar());
    }
}