package es.iesmz.ed.algoritmes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumaDescendentTest {

    @Test
    void sumaDescendiente() {
        SumaDescendent sum = new SumaDescendent(4578);
        assertEquals(5242, sum.sumaDescendiente());
    }
}