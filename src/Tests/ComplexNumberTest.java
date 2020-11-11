package Tests;

import com.asteof.complex.ComplexNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexNumberTest {
    ComplexNumber cn = new ComplexNumber(420, 69);
    ComplexNumber cn2 = new ComplexNumber(88, 200);

    @Test
    void getReal() {
        assertEquals(420, cn.getReal());
    }

    @Test
    void getImaginary() {
        assertEquals(69, cn.getImaginary());
    }

    @Test
    void testToString() {
        assertEquals("420.0 + 69.0i", cn.toString());
    }

    @Test
    void add() {
        assertEquals("508.0 + 269.0i", ComplexNumber.Add(cn, cn2).toString());
    }

    @Test
    void subtract() {
        assertEquals("332.0 - 131.0i", ComplexNumber.Subtract(cn, cn2).toString());
    }

    @Test
    void scale() {
        assertEquals("1680.0 + 276.0i", ComplexNumber.Scale(4, cn).toString());
    }
}