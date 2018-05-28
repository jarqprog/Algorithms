package com.jarq.algorithms.romanArabicConverter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class RomanArabicConverter implements IRomanArabicConverter {

    private Map<String,Integer> romanWithArabic = generateRomanWithArabic();

    @Override
    public int toArabic(String roman) {
        
        return 0;
    }


    @Override
    public String toRoman(int arabicNumber) {
        if(arabicNumber < 1 || arabicNumber > 3999) {
            throw new IllegalArgumentException("Invalid argument!");
        }

        boolean isReady;
        StringBuilder stringBuilder = new StringBuilder();

        for(Map.Entry<String,Integer> romanAndArabic : romanWithArabic.entrySet()) {
            isReady = false;
            while(! isReady) {
                if(arabicNumber - romanAndArabic.getValue() < 0) {
                    isReady = true;
                } else {
                    arabicNumber -= romanAndArabic.getValue();
                    stringBuilder.append(romanAndArabic.getKey());
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
        romanWithArabic.put("L", 50);
        romanWithArabic.put("XL", 40);
        romanWithArabic.put("X", 10);
        romanWithArabic.put("IX", 9);
        romanWithArabic.put("V", 5);
        romanWithArabic.put("IV", 4);
        romanWithArabic.put("I", 1);

        return romanWithArabic;
    }

    private String getRomanByArabic(Integer arabic) {
        for (Map.Entry<String, Integer> entry : romanWithArabic.entrySet()) {
            if (Objects.equals(arabic, entry.getValue())) {
                return entry.getKey();
            }
        }
        return "";
    }
}