package com.jarq.algorithms.wordsReverse;

public class SimpleWordsReverse implements WordsReverse {

    @Override
    public String reverse(String words) {

        if (words.length() == 0) {
            return words;
        }

        String[] array = words.split(" ");
        int len = array.length;

        if (len == 1) {
            return words;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0; i<len; i++) {

            stringBuilder.append(array[len-1-i]);

            if (i < len-1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
