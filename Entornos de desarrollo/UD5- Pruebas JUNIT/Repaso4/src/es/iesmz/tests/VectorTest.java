package es.iesmz.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VectorTest {

    @Test
    void reverso1(){
        int[] v = {1,2,3,4,5,6};
        int[] real = Vector.reverso(v);
        int[] expected = {6,5,4,3,2,1};
        Assertions.assertArrayEquals(expected, real);
    }

    @Test
    void reverso2(){
        int[] v = {10,12,5,221,6,7};
        int[] real = Vector.reverso(v);
        int[] expected = {7,6,221,5,12,10};
        Assertions.assertArrayEquals(expected, real);
    }

    @Test
    void reverso3(){
        int[] v = {5};
        int[] real = Vector.reverso(v);
        int[] expected = {5};
        Assertions.assertArrayEquals(expected, real);
    }

    @Test
    void reverso4(){
        int[] v = {5,10,20};
        int[] real = Vector.reverso(v);
        int[] expected = {20,10,5};
        Assertions.assertArrayEquals(expected, real);
    }

}