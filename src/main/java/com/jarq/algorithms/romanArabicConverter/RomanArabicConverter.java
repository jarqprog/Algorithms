package com.jarq.algorithms.romanArabicConverter;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanArabicConverter implements IRomanArabicConverter {

    private Map<String,Integer> romanWithArabic = generateRomanWithArabic();

    @Override
    public int toArabic(String roman) {

        int length = roman.length();
        int result = 0;
        String matcher;

        for(int i=0; i<length; i++) {
            matcher = "";
            if(i+1 < length) {
                matcher = roman.substring(i, i+2);
                if(romanWithArabic.containsKey(matcher)) {
                    result += romanWithArabic.get(matcher);
                    i++;
                } else {
                    matcher = "";
                }
            }

            if(matcher.length() == 0) {
                matcher = roman.substring(i, i+1);
                if(romanWithArabic.containsKey(matcher)) {
                    result += romanWithArabic.get(matcher);
                }
            }
        }
        return result;
    }


    @Override
    public String toRoman(int arabicNumber) {
        if(arabicNumber < 1 || arabicNumber > 3999) {
            throw new IllegalArgumentException("Invalid argument!");
        }

        boolean isReady;
        StringBuilder stringBuilder = new StringBuilder();

        for(Map.Entry<String,Integer> romanWithArabic : romanWithArabic.entrySet()) {
            isReady = false;
            while(! isReady) {
                if(arabicNumber - romanWithArabic.getValue() < 0) {
                    isReady = true;
                } else {
                    arabicNumber -= romanWithArabic.getValue();
                    stringBuilder.append(romanWithArabic.getKey());
                }
            }
        }
        return stringBuilder.toString();
    }

    private Map<String,Integer> generateRomanWithArabic() {
        Map<String, Integer> romanWithArabic = new LinkedHashMap<>();
        romanWithArabic.put("M", 1000);
        romanWithArabic.put("CM", 900);
        romanWithArabic.put("D", 500);
        romanWithArabic.put("CD", 400);
        romanWithArabic.put("C", 100);
        romanWithArabic.put("XC", 90);
        romanWithArabic.put("L", 50);
        romanWithArabic.put("XL", 40);
        romanWithArabic.put("X", 10);
        romanWithArabic.put("IX", 9);
        romanWithArabic.put("V", 5);
        romanWithArabic.put("IV", 4);
        romanWithArabic.put("I", 1);

        return romanWithArabic;
    }
}