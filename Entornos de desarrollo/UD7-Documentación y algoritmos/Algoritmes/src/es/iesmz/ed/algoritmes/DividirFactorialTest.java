package es.iesmz.ed.algoritmes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DividirFactorialTest {

    @Test
    void divisio() {
        DividirFactorial divisio = new DividirFactorial(5, 3);
        assertEquals(20, divisio.divisio());
    }
}