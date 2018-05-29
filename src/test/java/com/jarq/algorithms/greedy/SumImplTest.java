package com.jarq.algorithms.greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumImplTest {

    private Sum sum = new SumImpl();

    @Test(expected = IllegalArgumentException.class)
    public void checkSumOfTwo_with_invalid_array() throws IllegalArgumentException {

        sum.checkSumOfTwo(new int[0], 2);

    }

    @Test
    public void checkSumOfTwo_positive_numbers_small_array() {

        int[] numbers = {8, 2, 15, 1};

        assertTrue(sum.checkSumOfTwo(numbers, 17));
    }

    @Test
    public void checkSumOfTwo_positive_numbers_small_array_not_contains() {

        int[] numbers = {8, 2, 15, 1};

        assertFalse(sum.checkSumOfTwo(numbers, 100));
    }

    @Test
    public void checkSumOfTwo_mixed_numbers() {

        int[] numbers = {-20, 1, -2, 8, 2, 15, 1, -10, -21, 1000};

        assertTrue(sum.checkSumOfTwo(numbers, 5));
    }

    @Test
    public void checkSumOfTwo_mixed_numbers_not_contains() {

        int[] numbers = {-20, 1, -2, 8, 2, 15, 1, -10, -21, 1000};

        assertFalse(sum.checkSumOfTwo(numbers, 100012));
    }

    @Test
    public void checkSumOfTwo_negative_numbers() {

        int[] numbers = {-20, -11, -2, -8, -2, -15, -1, -10, -21, -100};

        assertTrue(sum.checkSumOfTwo(numbers, -23));
        assertTrue(sum.checkSumOfTwo(numbers, -32));
        assertFalse(sum.checkSumOfTwo(numbers, -103));
        assertFalse(sum.checkSumOfTwo(numbers, -122));
    }


    // sum of three

    @Test(expected = IllegalArgumentException.class)
    public void checkSumOfThree_with_invalid_array() throws IllegalArgumentException {
        sum.checkSumOfThree(new int[2], 1);

    }

    @Test
    public void checkSumOfThree_positive_numbers_small_array() {

        int[] numbers = {8, 2, 15, 1};

        assertTrue(sum.checkSumOfThree(numbers, 11));
        assertTrue(sum.checkSumOfThree(numbers, 24));
    }

    @Test
    public void checkSumOfThree_positive_numbers_small_array_not_contains() {

        int[] numbers = {8, 2, 15, 1};

        assertFalse(sum.checkSumOfThree(numbers, 100));
        assertFalse(sum.checkSumOfThree(numbers, 3));
        assertFalse(sum.checkSumOfThree(numbers, 6));
    }

    @Test
    public void checkSumOfThree_mixed_numbers() {

        int[] numbers = {-20, 1, -2, 8, 2, 15, 1, -10, -21, 1000};

        assertTrue(sum.checkSumOfThree(numbers, 7));
        assertTrue(sum.checkSumOfThree(numbers, 1005));
        assertTrue(sum.checkSumOfThree(numbers, -40));
        assertTrue(sum.checkSumOfThree(numbers, 21));
    }

    @Test
    public void checkSumOfThree_negative_numbers() {

        int[] numbers = {-20, -11, -2, -8, -2, -15, -1, -10, -21, -100};

        assertTrue(sum.checkSumOfThree(numbers, -41));
        assertTrue(sum.checkSumOfThree(numbers, -110));
        assertFalse(sum.checkSumOfThree(numbers, -53));
        assertFalse(sum.checkSumOfThree(numbers, -6));
    }
}