package com.jarq.algorithms.romanArabicConverter;

public class ConventerDemo {


    public static void main(String[] args) {

        IRomanArabicConverter converter = new RomanArabicConverter();

        String[] romanNums = {"MCDX", "MCMXIV", "XXIII", "XCIV"};

        for(String roman : romanNums) {
            System.out.println("Roman number: " + roman);
            System.out.println("Arabic equivalent: " + converter.toArabic(roman));
            System.out.println();
        }

        int[] arabicNums = {1918, 1410, 2018, 11, 23, 3000};
        for(int arabic: arabicNums) {
            System.out.println("Arabic number: " + arabic);
            System.out.println("Roman equivalent: " + converter.toRoman(arabic));
            System.out.println();
        }

    }
}
