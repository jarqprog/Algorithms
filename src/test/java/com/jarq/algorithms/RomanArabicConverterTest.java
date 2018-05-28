package com.jarq.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanArabicConverterTest {

    private IRomanArabicConverter converter = new RomanArabicConverter();

    @Test
    public void toRoman() {

        int number = 1982;

        String expected = "MCMLXXXII";

        assertEquals(expected, converter.toRoman(number));
    }

    @Test
    public void toArabic() {
        String roman = "MCMLXXXII";
        int arabic = 1982;
        assertEquals(arabic, converter.toArabic(roman));
    }
}