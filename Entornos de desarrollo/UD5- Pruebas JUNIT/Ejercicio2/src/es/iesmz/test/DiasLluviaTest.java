package es.iesmz.test;

import static org.junit.jupiter.api.Assertions.*;

class DiasLluviaTest {
    DiasLluvia diasLluvia = new DiasLluvia();
    @org.junit.jupiter.api.Test
    void registroDia1() {
        Boolean resultadoEsperado = true;
        Boolean resultadoReal = diasLluvia.registroDia(1, 1, true);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    void registroDia2() {
        Boolean resultadoEsperado = true;
        Boolean resultadoReal = diasLluvia.registroDia(1, 1, false);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    void registroDia3() {
        Boolean resultadoEsperado = false;
        Boolean resultadoReal = diasLluvia.registroDia(1, 13, true);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    void consultarDia1() {
        diasLluvia.registroDia(1, 1, true);
        Boolean resultadoReal = diasLluvia.consultarDia(1, 1);
        Boolean resultadoEsperado = true;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    void consultarDia2() {
        diasLluvia.registroDia(1, 1, false);
        Boolean resultadoReal = diasLluvia.consultarDia(1, 1);
        Boolean resultadoEsperado = false;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    void consultarDia3() {
        diasLluvia.registroDia(1, 12, true);
        Boolean resultadoReal = diasLluvia.consultarDia(1, 12);
        Boolean resultadoEsperado = true;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    void contarDiasLluviosos1() {
        diasLluvia.registroDia(1, 12, true);
        diasLluvia.registroDia(1, 11, true);
        diasLluvia.registroDia(1, 1, true);
        int resultadoReal = diasLluvia.contarDiasLluviosos();
        int resultadoEsperado = 3;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    void contarDiasLluviosos2() {
        diasLluvia.registroDia(1, 12, true);
        diasLluvia.registroDia(1, 11, false);
        diasLluvia.registroDia(1, 1, true);
        int resultadoReal = diasLluvia.contarDiasLluviosos();
        int resultadoEsperado = 2;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    void contarDiasLluviosos3() {
        diasLluvia.registroDia(1, 12, false);
        diasLluvia.registroDia(1, 11, false);
        diasLluvia.registroDia(1, 1, false);
        int resultadoReal = diasLluvia.contarDiasLluviosos();
        int resultadoEsperado = 0;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    void trimestreLluvioso1() {
        diasLluvia.registroDia(1, 1, true);
        diasLluvia.registroDia(1, 4, true);
        diasLluvia.registroDia(1, 5, true);
        int resultadoReal = diasLluvia.trimestreLluvioso();
        int resultadoEsperado = 2;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    void trimestreLluvioso2() {
        diasLluvia.registroDia(1, 1, true);
        diasLluvia.registroDia(1, 4, true);
        diasLluvia.registroDia(1, 5, true);
        diasLluvia.registroDia(1, 12, true);
        diasLluvia.registroDia(1, 11, true);
        diasLluvia.registroDia(1, 10, true);
        int resultadoReal = diasLluvia.trimestreLluvioso();
        int resultadoEsperado = 4;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    void trimestreLluvioso3() {
        diasLluvia.registroDia(1, 1, true);
        diasLluvia.registroDia(1, 2, true);
        diasLluvia.registroDia(1, 3, true);
        diasLluvia.registroDia(1, 12, true);
        diasLluvia.registroDia(1, 11, true);
        diasLluvia.registroDia(1, 10, true);
        int resultadoReal = diasLluvia.trimestreLluvioso();
        int resultadoEsperado = 1;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    void primerDiaLluvia1() {
        diasLluvia.registroDia(1, 1, true);
        diasLluvia.registroDia(1, 4, true);
        diasLluvia.registroDia(1, 5, true);
        int resultadoReal = diasLluvia.primerDiaLluvia();
        int resultadoEsperado = 1;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    void primerDiaLluvia2() {
        diasLluvia.registroDia(1, 1, false);
        diasLluvia.registroDia(1, 2, true);
        diasLluvia.registroDia(1, 5, true);
        int resultadoReal = diasLluvia.primerDiaLluvia();
        int resultadoEsperado = 31;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @org.junit.jupiter.api.Test
    void primerDiaLluvia3() {
        diasLluvia.registroDia(1, 1, false);
        diasLluvia.registroDia(1, 4, false);
        diasLluvia.registroDia(1, 5, true);
        int resultadoReal = diasLluvia.primerDiaLluvia();
        int resultadoEsperado = 121;
        assertEquals(resultadoEsperado, resultadoReal);
    }
}