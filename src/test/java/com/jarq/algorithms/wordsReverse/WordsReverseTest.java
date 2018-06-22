package com.jarq.algorithms.wordsReverse;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class WordsReverseTest {

    private WordsReverse wordsReverse;

    protected void setWordsReverse(WordsReverse wordsReverse) {
        this.wordsReverse = wordsReverse;
    }

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
