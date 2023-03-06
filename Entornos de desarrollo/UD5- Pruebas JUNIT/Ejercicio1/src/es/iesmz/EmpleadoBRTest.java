package es.iesmz;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoBRTest {
    @org.junit.jupiter.api.Test
    public void testCalculaSalarioNeto1() {
        float resultadoReal = EmpleadoBR.calculaSalarioNeto(2000.0f);
        float resultadoEsperado = 1640.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioNeto2(){
        float resultadoReal = EmpleadoBR.calculaSalarioNeto(1500.0f);
        float resultadoEsperado = 1230.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioNeto3(){
        float resultadoReal = EmpleadoBR.calculaSalarioNeto(1499.99f);
        float resultadoEsperado = 1259.9916f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioNeto4(){
        float resultadoReal = EmpleadoBR.calculaSalarioNeto(1250.0f);
        float resultadoEsperado = 1050.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioNeto5(){
        float resultadoReal = EmpleadoBR.calculaSalarioNeto(1000.0f);
        float resultadoEsperado = 840.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioNeto6(){
        float resultadoReal = EmpleadoBR.calculaSalarioNeto(999.99f);
        float resultadoEsperado = 999.99f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioNeto7(){
        float resultadoReal = EmpleadoBR.calculaSalarioNeto(500.0f);
        float resultadoEsperado = 500.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioNeto8(){
        float resultadoReal = EmpleadoBR.calculaSalarioNeto(0.0f);
        float resultadoEsperado = 0.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioNeto9(){
        float resultadoReal = EmpleadoBR.calculaSalarioNeto(-1.0f);
        float resultadoEsperado = -1.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioBruto1() {
        float resultadoReal = EmpleadoBR.calculaSalarioBruto(
                TipoEmpleado.venedor, 2000.0f, 8.0f);
        float resultadoEsperado = 1360.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioBruto2() {
        float resultadoReal = EmpleadoBR.calculaSalarioBruto(
                TipoEmpleado.venedor, 1500.0f, 3.0f);
        float resultadoEsperado = 1260.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioBruto3() {
        float resultadoReal = EmpleadoBR.calculaSalarioBruto(
                TipoEmpleado.venedor, 1499.99f, 0.0f);
        float resultadoEsperado = 1100.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioBruto4() {
        float resultadoReal = EmpleadoBR.calculaSalarioBruto(
                TipoEmpleado.encarregat, 1250.0f, 8.0f);
        float resultadoEsperado = 1760.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioBruto5() {
        float resultadoReal = EmpleadoBR.calculaSalarioBruto(
                TipoEmpleado.encarregat, 1000.0f, 0.0f);
        float resultadoEsperado = 1600.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioBruto6() {
        float resultadoReal = EmpleadoBR.calculaSalarioBruto(
                TipoEmpleado.encarregat, 999.99f, 3.0f);
        float resultadoEsperado = 1560.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioBruto7() {
        float resultadoReal = EmpleadoBR.calculaSalarioBruto(
                TipoEmpleado.encarregat, 500.0f, 0.0f);
        float resultadoEsperado = 1500.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioBruto8() {
        float resultadoReal = EmpleadoBR.calculaSalarioBruto(
                TipoEmpleado.encarregat, 0.0f, 8.0f);
        float resultadoEsperado = 1660.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioBruto9() {
        float resultadoReal = EmpleadoBR.calculaSalarioBruto(
                TipoEmpleado.venedor, -1.0f, 8.0f);
        float resultadoEsperado = -1.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioBruto10() {
        float resultadoReal = EmpleadoBR.calculaSalarioBruto(
                TipoEmpleado.venedor, 1500.0f, -1.0f);
        float resultadoEsperado = -1.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void testCalculaSalarioBruto11() {
        float resultadoReal = EmpleadoBR.calculaSalarioBruto(
                null, 1500.0f, 8.0f);
        float resultadoEsperado = -1.0f;
        assertEquals(resultadoEsperado, resultadoReal, 0.01);
    }
}