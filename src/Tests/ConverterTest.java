package Tests;

import com.asteof.convertSystem.Converter;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    Converter c = new Converter();

    @org.junit.jupiter.api.Test
    void convertToBase1() {
        assertEquals(Integer.toString(21330), c.ConvertToBase("1465", 10, 5));
    }

    @org.junit.jupiter.api.Test
    void convertToBase2() {
        assertEquals(Integer.toString(1490), c.ConvertToBase("21430", 5, 10));
    }

    @org.junit.jupiter.api.Test
    void convertToBase3() {
        assertEquals(Integer.toString(236532623), c.ConvertToBase("5700XT", 34, 10));
    }

    @org.junit.jupiter.api.Test
    void convertToBase4() {
        assertEquals(Integer.toString(6249), c.ConvertToBase("144444", 5, 10));
    }
}