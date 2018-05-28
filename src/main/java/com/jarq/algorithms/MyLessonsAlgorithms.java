package com.jarq.algorithms;

public class MyLessonsAlgorithms implements LessonsAlgorithms {

    @Override
    public String reverseString(String toReverse) {

        int length = toReverse.length();

        if(length < 2) {
            return toReverse;
        }

        char[] letters = new char[length];
        int counter = 0;

        for(int i=length-1; i>=0; i--) {
            letters[counter] = toReverse.charAt(i);
            counter++;
        }
        return String.valueOf(letters);
    }

    @Override
    public long factorial(int num) {

        if(num < 2) {
            return 1;
        }

        int result = 1;

        for(int i=1; i<=num; i++) {

            result *= i;
        }
        return result;
    }

    @Override
    public boolean isPalindrom(String toCheck) {

        String alphaNumeric = toCheck.replaceAll("[^A-Za-z0-9]", "");
        char[] alphaNumericArray = alphaNumeric.toCharArray();

        int length = alphaNumericArray.length;
        char[] reversed = new char[length];

        int index = length-1;
        for(int i=0; i<length; i++) {
            reversed[i] = alphaNumericArray[index];
            index--;
        }

        for(int j=0; j<length; j++) {
            if(Character.toLowerCase(reversed[j]) != Character.toLowerCase(alphaNumericArray[j])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String findLongestWord(String sentence) {

        String filtered = sentence.replaceAll("[^A-Za-z0-9\\s]", "");
        String[] words = filtered.split(" ");

        if(words.length == 0) {
            return "";
        }

        if(words.length <2) {
            return words[0];
        }

        int indexOfLongest = 0;
        for(int i=1; i<words.length; i++) {
            if(words[i].length() > words[indexOfLongest].length()) {
                indexOfLongest = i;
            }
        }

        return words[indexOfLongest];
    }

    @Override
    public String titleCase(String sentence) {

        if(sentence.length() < 1) {
            return sentence;
        }

        String[] words = sentence.split(" ");
        char[] lettersOfWord;

        for(int i=0; i<words.length; i++) {
            String word = words[i];
            char firstLetter = word.charAt(0);
            lettersOfWord = word.toCharArray();
            lettersOfWord[0] = Character.toUpperCase(firstLetter);
            for(int j=1; j<lettersOfWord.length; j++) {
                lettersOfWord[j] = Character.toLowerCase(lettersOfWord[j]);
            }

            words[i] = String.valueOf(lettersOfWord);
        }
        return String.join(" ", words);
    }

    @Override
    public void FizzBuzz() {

    }
}
