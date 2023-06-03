package es.iesmz.ed.algoritmes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnyTest {

    @Test
    void digitsDiferents() {
        Any any = new Any(2023);
        assertEquals(3, any.digitsDiferents());
    }

    @Test
    void digitsDiferents2() {
        Any any = new Any(2013);
        assertEquals(4, any.digitsDiferents());
    }

    @Test
    void digitsDiferents3() {
        Any any = new Any(2022);
        assertEquals(2, any.digitsDiferents());
    }
}