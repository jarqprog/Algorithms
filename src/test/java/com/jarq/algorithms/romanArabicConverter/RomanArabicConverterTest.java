package com.jarq.algorithms.romanArabicConverter;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanArabicConverterTest {

    private IRomanArabicConverter converter = new RomanArabicConverter();

    @Test
    public void toRoman_1982() {

        int number = 1982;

        String expected = "MCMLXXXII";

        assertEquals(expected, converter.toRoman(number));
    }

    @Test
    public void toRoman_2000() {

        int number = 2000;

        String expected = "MM";

        assertEquals(expected, converter.toRoman(number));
    }

    @Test
    public void toRoman_1410() {

        int number = 1410;

        String expected = "MCDX";

        assertEquals(expected, converter.toRoman(number));
    }

    @Test
    public void toArabic_XXII() {
        String roman = "XXII";
        int arabic = 22;
        assertEquals(arabic, converter.toArabic(roman));
    }

    @Test
    public void toArabic_MCDX() {
        String roman = "MCDX";
        int arabic = 1410;
        assertEquals(arabic, converter.toArabic(roman));
    }

    @Test
    public void toArabic_MCMLXXXII() {
        String roman = "MCMLXXXII";
        int arabic = 1982;
        assertEquals(arabic, converter.toArabic(roman));
    }
}