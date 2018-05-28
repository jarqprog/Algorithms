package com.jarq.algorithms.fizzBuzz;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FizzBuzzTest {

    private IFizzBuzz fizzBuzz = new FizzBuzz();

    @Test(expected = IllegalArgumentException.class)
    public void fizzBuzzToArray_using_empty_map() throws IllegalArgumentException {

        fizzBuzz.toArray(10, new LinkedHashMap<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void fizzBuzzToArray_using_invalid_number() throws IllegalArgumentException {

        fizzBuzz.toArray(-1, generateDividersWithWords());
    }

    @Test
    public void fizzBuzzToArray() {

        String[] expected = {   "1", "2", "3 Fizz", "4", "5 Buzz", "6 Fizz", "7", "8", "9 Fizz", "10 Buzz",
                                "11", "12 Fizz", "13", "14", "15 Fizz Buzz Bum!"};

        String[] result = fizzBuzz.toArray(15, generateDividersWithWords());

        assertArrayEquals(expected, result);
    }

    private Map<Integer,String> generateDividersWithWords() {
        Map<Integer,String> dividersWithWords = new LinkedHashMap<>(2);
        dividersWithWords.put(3, "Fizz");
        dividersWithWords.put(5, "Buzz");
        dividersWithWords.put(15, "Bum!");
        return dividersWithWords;
    }

}