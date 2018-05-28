package com.jarq.algorithms.fizzBuzz;

import java.util.Arrays;
import java.util.Map;

public class FizzBuzz implements IFizzBuzz {

    @Override
    public void display(int maxNumToDisplay, Map<Integer,String> numberWord) {
        Arrays.stream(toArray(maxNumToDisplay, numberWord)).forEach(System.out::println);
    }

    @Override
    public String[] toArray(int maxNumToDisplay, Map<Integer, String> dividersAndWords) {

        if(maxNumToDisplay < 1 || dividersAndWords.size() == 0) {
            throw new IllegalArgumentException("Invalid arguments!");
        }

        String[] result = new String[maxNumToDisplay];
        StringBuilder stringBuilder;
        for(int i=1; i<=maxNumToDisplay; i++) {

            stringBuilder = new StringBuilder(String.valueOf(i));

            for(Map.Entry<Integer,String> dividerWord : dividersAndWords.entrySet()) {
                if(isDividedBy(i, dividerWord.getKey())) {
                    stringBuilder.append(" ");
                    stringBuilder.append(dividerWord.getValue());

                }
            }
            result[i-1] = stringBuilder.toString();
        }
        return result;
    }

    private boolean isDividedBy(int number, int divider) {

        return number % divider == 0;
    }
}
