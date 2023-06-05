package es.iesmz.ed.algoritmes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolidivisibleTest {

    @Test
    void esPolidivisible1() {
        Polidivisible polidivisible = new Polidivisible(381654729);
        assertTrue(polidivisible.esPolidivisible());
    }

    @Test
    void esPolidivisible2() {
        Polidivisible polidivisible = new Polidivisible(102);
        assertTrue(polidivisible.esPolidivisible());
    }

    @Test
    void esPolidivisible3() {
        Polidivisible polidivisible = new Polidivisible(9876);
        assertTrue(polidivisible.esPolidivisible());
    }
}