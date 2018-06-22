package com.jarq.algorithms.wordsReverse;

public class QuickWordsReverse implements WordsReverse {

    private char[] array;

    @Override
    public String reverse(String words) {

        if (words.length() == 0) {
            return words;
        }

        array = words.toCharArray();
        int len = array.length;

        int nextStart = 0;
        for (int end=0; end<len; end++) {
            if (array[end] == 32) {  // is space
                reverse(nextStart, end-1);  // matched word, reverse
                nextStart = end+1;
            }
        }

        reverse(nextStart, len-1);  // reverse last word
        reverse(0, len-1);  // clean up - reverse all

        return String.valueOf(array);
    }

    private void reverse(int startIdx, int finalIdx){
        char aux;
        while(startIdx < finalIdx) {
            aux = array[finalIdx];
            array[finalIdx] = array[startIdx];
            array[startIdx] = aux;
            startIdx++;
            finalIdx--;
        }
    }
}
