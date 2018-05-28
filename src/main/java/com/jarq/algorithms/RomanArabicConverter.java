package com.jarq.algorithms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class RomanArabicConverter implements IRomanArabicConverter {

    @Override
    public int toArabic(String roman) {

        int result = 0;

        for(Map.Entry<String,Integer> element : generateThousandths().entrySet()) {
            if(roman.contains(element.getKey())) {
                result += element.getValue()*1000;
                roman = roman.replaceFirst(element.getKey(), "");
            }
        }

        for(Map.Entry<String,Integer> element : generateHundredths().entrySet()) {
            if(roman.contains(element.getKey())) {
                result += element.getValue()*100;
                roman = roman.replaceFirst(element.getKey(), "");
            }
        }

        for(Map.Entry<String,Integer> element : generateDecimals().entrySet()) {
            if(roman.contains(element.getKey())) {
                result += element.getValue()*10;
                roman = roman.replaceFirst(element.getKey(), "");
            }
        }

        for(Map.Entry<String,Integer> element : generateUnits().entrySet()) {
            if(roman.contains(element.getKey())) {
                result += element.getValue();
                roman = roman.replaceFirst(element.getKey(), "");
            }
        }
        return result;
    }


    @Override
    public String toRoman(int arabicNumber) {
        if(arabicNumber < 1 || arabicNumber > 3999) {
            throw new IllegalArgumentException("Invalid argument!");
        }

        StringBuilder result = new StringBuilder();

        int decimals, hundredth, thousandth;

        thousandth = arabicNumber / 1000;


        if(thousandth > 0) {
            result.append(getRomanByArabic(generateThousandths(), thousandth));
        }

        arabicNumber -= 1000*thousandth;

        hundredth = arabicNumber / 100;
        if(hundredth > 0) {
            result.append(getRomanByArabic(generateHundredths(), hundredth));
        }

        arabicNumber -= 100*hundredth;
        decimals = arabicNumber / 10;
        if(decimals > 0) {
            result.append(getRomanByArabic(generateDecimals(), decimals));
        }

        arabicNumber -= 10*decimals;
        result.append(getRomanByArabic(generateUnits(), arabicNumber));

        return result.toString();
    }

    private Map<String,Integer> generateThousandths() {
        Map<String, Integer> thousandths = new LinkedHashMap<>();

        thousandths.put("MMM", 3);
        thousandths.put("MM", 2);
        thousandths.put("M", 1);

        return thousandths;
    }

    private Map<String,Integer> generateHundredths() {
        Map<String, Integer> hundredths = new LinkedHashMap<>();

        hundredths.put("CM", 9);
        hundredths.put("DCCC", 8);
        hundredths.put("DCC", 7);
        hundredths.put("DC", 6);
        hundredths.put("D", 5);
        hundredths.put("CD", 4);
        hundredths.put("CCC", 3);
        hundredths.put("CC", 2);
        hundredths.put("C", 1);

        return hundredths;
    }

    private Map<String,Integer> generateDecimals() {
        Map<String, Integer> decimals = new LinkedHashMap<>();
        decimals.put("XC", 9);
        decimals.put("LXXX", 8);
        decimals.put("LXX", 7);
        decimals.put("LX", 6);
        decimals.put("L", 5);
        decimals.put("XL", 4);
        decimals.put("XXX", 3);
        decimals.put("XX", 2);
        decimals.put("X", 1);

        return decimals;
    }

    private Map<String,Integer> generateUnits() {
        Map<String, Integer> units = new LinkedHashMap<>();

        units.put("IX", 9);
        units.put("VIII", 8);
        units.put("VII", 7);
        units.put("VI", 6);
        units.put("V", 5);
        units.put("IV", 4);
        units.put("III", 3);
        units.put("II", 2);
        units.put("I", 1);

        return units;
    }

    private String getRomanByArabic(Map<String,Integer> romanAndArabic, Integer value) {
        for (Map.Entry<String, Integer> entry : romanAndArabic.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return "";
    }
}