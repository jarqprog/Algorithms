package com.jarq.algorithms;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

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
    public int findKMax(int[] numbers, int k) {  // using stack

        if (numbers.length == 0 || k > numbers.length || k < 1) {
            throw new IllegalArgumentException("invalid arguments!");
        }

        if (numbers.length == 1) {
            return numbers[0];
        }

        Stack<Integer> usedIndexes = new Stack<>();

        int length = numbers.length;
        int currentMax;
        int currentMaxIndex;
        for(int i=0; i<k; i++) {
            currentMax = Integer.MIN_VALUE;
            currentMaxIndex = -1;
            for(int j=0; j<length; j++) {
                if(numbers[j] > currentMax && !usedIndexes.contains(j)) {
                    currentMax = numbers[j];
                    currentMaxIndex = j;
                }
            }
            if(currentMaxIndex != -1) {
                usedIndexes.push(currentMaxIndex);
            }
        }
        return numbers[usedIndexes.peek()];  // return correct k max value (last added index to stack)
    }

    @Override
    public int findKMaxWithTransform(int[] numbers, int k) {  // transforms given array

        if (numbers.length == 0 || k > numbers.length || k < 1) {
            throw new IllegalArgumentException("invalid arguments!");
        }

        if (numbers.length == 1) {
            return numbers[0];
        }

        int counter = 0;
        int currentMaxIndex = 0;

        while(counter <= k) {
            for(int i=counter+1; i<numbers.length; i++) {  // i=counter+1 (to start iterating from second element)
                if (numbers[i] > numbers[currentMaxIndex]) {
                    currentMaxIndex = i;
                }
            }

            if(counter != currentMaxIndex) {  // new max was matched
                int temp = numbers[counter];  // swap in place
                numbers[counter] = numbers[currentMaxIndex];
                numbers[currentMaxIndex] = temp;
            }
            counter++;
        }
        return numbers[k-1];  // return correct k max value
    }



}
