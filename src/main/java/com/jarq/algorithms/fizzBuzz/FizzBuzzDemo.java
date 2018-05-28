package com.jarq.algorithms.fizzBuzz;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FizzBuzzDemo {

    public static void main(String[] args) {

        Map<Integer,String> dividersWithWords = new LinkedHashMap<>(3);
        dividersWithWords.put(3, "Fizz");
        dividersWithWords.put(5, "Buzz");
        dividersWithWords.put(7, "Bum");

        IFizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(Arrays.toString(fizzBuzz.toArray(20, dividersWithWords)));

        fizzBuzz.display(100, dividersWithWords);

    }
}
