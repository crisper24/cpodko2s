package org.hbrs.se1.ws23.uebung1.test;

import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    @Test
    void aPositiveTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(4);
        assertEquals(value, "vier");
    }

    @Test
    void aNegativeTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(0);
        assertEquals(value, "Übersetzung der Zahl 0 nicht möglich (Version: 1.0)");
    }

    @Test
    void bNegativeTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(100);
        assertEquals(value, "Übersetzung der Zahl 100 nicht möglich (Version: 1.0)");
    }
}