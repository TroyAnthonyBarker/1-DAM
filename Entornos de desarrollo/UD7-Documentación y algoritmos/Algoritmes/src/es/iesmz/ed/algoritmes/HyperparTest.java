package es.iesmz.ed.algoritmes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HyperparTest {

    @Test
    void hyperpar(){
        Hyperpar hyper = new Hyperpar(24680);
        assertTrue(hyper.esHyperPar());
    }

    @Test
    void noHyperpar(){
        Hyperpar hyper = new Hyperpar(2568);
        assertFalse(hyper.esHyperPar());
    }
}