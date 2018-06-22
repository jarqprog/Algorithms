package com.jarq.algorithms.wordsReverse;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyWordsReverseTest {

    private WordsReverse wordsReverse = new MyWordsReverse();

    @Test
    public void reverse_if_empty() {

        String input = "";

        String output = wordsReverse.reverse(input);

        assertEquals(input, output);
    }

    @Test
    public void reverse_if_one_world() {

        String input = "Jack";

        String output = wordsReverse.reverse(input);

        assertEquals(input, output);
    }


    @Test
    public void reverse() {

        String input = "the sky is blue";
        String expected = "blue is sky the";


        String output = wordsReverse.reverse(input);

        assertEquals(expected, output);
    }
}