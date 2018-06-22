package com.jarq.algorithms.wordsReverse;

public class SmartWordsReverse implements WordsReverse {

    @Override
    public String reverse(String words) {

        if (words.length() == 0) {
            return words;
        }

        char[] array = words.toCharArray();
        array = reverseInArray(array, 0, array.length-1);
        return gatherOrderedWords(array);
    }


    private char[] reverseInArray(char[] array, int startIndex, int finalIndex) {

        if (startIndex >= finalIndex) {
            return array;
        }

        while (startIndex < finalIndex) {
            char aux = array[startIndex];
            array[startIndex] = array[finalIndex];
            array[finalIndex] = aux;
            startIndex++;
            finalIndex--;
        }
        return array;
    }

    private String gatherOrderedWords(char[] array) {

        int spaceIdx = 0;
        for (int i=0; i< array.length; i++) {
            if (array[i] == 32) {  // char is space
                array = reverseInArray(array, spaceIdx, i-1);
                spaceIdx = i+1;
            }
        }

        array = reverseInArray(array, spaceIdx, array.length-1);  // reverse last word
        return String.valueOf(array);
    }
}
