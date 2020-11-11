package Tests;

import com.asteof.Regexps;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexpsTest {
    Regexps r = new Regexps();

    @Test
    void regT() {
        assertTrue(r.Reg("5"));
    }

    @Test
    void regF() {
        assertFalse(r.Reg("5.0"));
    }

    @Test
    void regNumberT() {
        assertTrue(r.RegNumber("5700XT"));
    }

    @Test
    void regNumberF() {
        assertFalse(r.RegNumber("5700XT.69"));
    }

    @Test
    void regBase() {
        assertFalse(r.RegBase("-1"));
    }

    @Test
    void regComplex() {
        assertTrue(r.RegComplex("-57.0085"));
    }

    @Test
    void regEquation() {
        assertFalse(r.RegEquation("55555555555555"));
    }
}