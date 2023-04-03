package es.iesmz.tests;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    @org.junit.jupiter.api.Test
    void nextSecond1() {
        assertEquals((new Time(12,14,15)).nextSecond(), (new Time(12,14,16)));
    }
    @org.junit.jupiter.api.Test
    void nextSecond2() {
        assertEquals((new Time(12,59,44)).nextSecond(), (new Time(12,59,45)));
    }
    @org.junit.jupiter.api.Test
    void nextSecond3() {
        assertEquals((new Time(1,9,59)).nextSecond(), (new Time(1,10,0)));
    }
    @org.junit.jupiter.api.Test
    void nextSecond4() {
        assertEquals((new Time(17,59,59)).nextSecond(), (new Time(18,0,0)));
    }
    @org.junit.jupiter.api.Test
    void nextSecond5() {
        assertEquals((new Time(23,59,59)).nextSecond(), (new Time(0,0,0)));
    }
}