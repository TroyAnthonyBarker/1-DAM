package es.iesmz.test;

import es.iesmz.clases.Cuenta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCartera {
    @Test
    public void creacionDeCuentas(){
        Cuenta c1 = new Cuenta();
        double resultadoEsperado = 0;
        double resultadoReal = c1.getSaldo();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void ingresos1(){
        Cuenta c1 = new Cuenta();
        c1.ingresar(100);
        c1.ingresar(100);
        double resultadoEsperado = 200;
        double resultadoReal = c1.getSaldo();
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @Test
    public void ingresos2_1(){
        Cuenta c1 = new Cuenta();
        c1.ingresar(100);
        double resultadoEsperado = 100;
        double resultadoReal = c1.getSaldo();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void ingresos2_2(){
        Cuenta c1 = new Cuenta();
        c1.ingresar(3000);
        double resultadoEsperado = 3000;
        double resultadoReal = c1.getSaldo();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void ingresos2_3(){
        Cuenta c1 = new Cuenta();
        c1.ingresar(100);
        c1.ingresar(3000);
        double resultadoEsperado = 3100;
        double resultadoReal = c1.getSaldo();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void ingresos3(){
        Cuenta c1 = new Cuenta();
        c1.ingresar(-100);
        double resultadoEsperado = 0;
        double resultadoReal = c1.getSaldo();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void ingresos4(){
        Cuenta c1 = new Cuenta();
        c1.ingresar(100.45);
        double resultadoEsperado = 100.45;
        double resultadoReal = c1.getSaldo();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void ingresos5_1(){
        Cuenta c1 = new Cuenta();
        c1.ingresar(6000);
        double resultadoEsperado = 6000;
        double resultadoReal = c1.getSaldo();
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @Test
    public void ingresos5_2(){
        Cuenta c1 = new Cuenta();
        c1.ingresar(6000.01);
        double resultadoEsperado = 0;
        double resultadoReal = c1.getSaldo();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void retiradas1(){
        Cuenta c1 = new Cuenta();
        c1.ingresar(100);
        c1.retirar(100);
        double resultadoEsperado = 0;
        double resultadoReal = c1.getSaldo();
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @Test
    public void retiradas2(){
        Cuenta c1 = new Cuenta();
        c1.ingresar(500);
        c1.retirar(100);
        double resultadoEsperado = 400;
        double resultadoReal = c1.getSaldo();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void retiradas3(){
        Cuenta c1 = new Cuenta();
        c1.ingresar(200);
        c1.retirar(500);
        double resultadoEsperado = 200;
        double resultadoReal = c1.getSaldo();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void retiradas4(){
        Cuenta c1 = new Cuenta();
        c1.ingresar(500);
        c1.retirar(-100);
        double resultadoEsperado = 500;
        double resultadoReal = c1.getSaldo();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void retiradas5(){
        Cuenta c1 = new Cuenta();
        c1.ingresar(500);
        c1.retirar(100.45);
        double resultadoEsperado = 399.55;
        double resultadoReal = c1.getSaldo();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void retiradas6_1(){
        Cuenta c1 = new Cuenta();
        c1.ingresar(6000);
        c1.ingresar(1000);
        c1.retirar(6000);
        double resultadoEsperado = 1000;
        double resultadoReal = c1.getSaldo();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void retiradas6_2(){
        Cuenta c1 = new Cuenta();
        c1.ingresar(6000);
        c1.ingresar(1000);
        c1.retirar(7000);
        double resultadoEsperado = 7000;
        double resultadoReal = c1.getSaldo();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void transferencias1(){
        Cuenta c1 = new Cuenta();
        Cuenta c2 = new Cuenta();
        c1.ingresar(500);
        c2.ingresar(50);
        c1.transpasar(100, c2);
        boolean resultadoEsperado = true;
        boolean resultadoReal = c1.getSaldo() == 400 && c2.getSaldo() == 150;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void transferencias2(){
        Cuenta c1 = new Cuenta();
        Cuenta c2 = new Cuenta();
        c1.ingresar(500);
        c2.ingresar(50);
        c1.transpasar(-100, c2);
        boolean resultadoEsperado = true;
        boolean resultadoReal = (c1.getSaldo() == 500 && c2.getSaldo() == 50);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void transferencias3_1(){
        Cuenta c1 = new Cuenta();
        Cuenta c2 = new Cuenta();
        c1.ingresar(3500);
        c2.ingresar(50);
        c1.transpasar(3000, c2);
        boolean resultadoEsperado = true;
        boolean resultadoReal = (c1.getSaldo() == 500 && c2.getSaldo() == 3050);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void transferencias3_2(){
        Cuenta c1 = new Cuenta();
        Cuenta c2 = new Cuenta();
        c1.ingresar(3500);
        c2.ingresar(50);
        c1.transpasar(3000.01, c2);
        boolean resultadoEsperado = true;
        boolean resultadoReal = (c1.getSaldo() == 3500 && c2.getSaldo() == 50);
        assertEquals(resultadoEsperado, resultadoReal);
    }
}
