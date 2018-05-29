package com.jarq.algorithms.greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumInArrayTest {

    private ISumInArray sum = new SumInArray();

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

    // sum of two in array

    @Test(expected = IllegalArgumentException.class)
    public void checkSumOfTwoInArray_with_invalid_array() throws IllegalArgumentException {
        sum.checkSumOfTwoInArray(new int[2]);
    }

    @Test
    public void checkSumOfTwoInArray_positive_numbers_small_array() {

        int[] numbers = {3, 2, 5, 1};

        assertTrue(sum.checkSumOfTwoInArray(numbers));
    }

    @Test
    public void checkSumOfTwoInArray_positive_numbers_small_array_1() {

        int[] numbers = {4, 2, 5, 2};

        assertTrue(sum.checkSumOfTwoInArray(numbers));
    }

    @Test
    public void checkSumOfTwoInArray_positive_numbers_small_array_not_contains() {

        int[] numbers = {8, 2, 15, 1};

        assertFalse(sum.checkSumOfTwoInArray(numbers));
    }

    @Test
    public void checkSumOfTwoInArray_mixed_numbers() {

        int[] numbers = {-20, 1, -2, 0, 20};

        assertTrue(sum.checkSumOfTwoInArray(numbers));
    }

    @Test
    public void checkSumOfTwoInArray_mixed_numbers_1() {

        int[] numbers = {-20, 0, -2, -1, 20};

        assertTrue(sum.checkSumOfTwoInArray(numbers));
    }

    @Test
    public void checkSumOfTwoInArray_mixed_numbers_2() {

        int[] numbers = {10, 0, -2, -1, -10};

        assertTrue(sum.checkSumOfTwoInArray(numbers));
    }

    @Test
    public void checkSumOfTwoInArray_mixed_numbers_3() {

        int[] numbers = {1, 0, -2, -1, 1};

        assertTrue(sum.checkSumOfTwoInArray(numbers));
    }

    @Test
    public void checkSumOfTwoInArray_mixed_numbers_not_contains() {

        int[] numbers = {-20, 5, -2, -1, 20};

        assertFalse(sum.checkSumOfTwoInArray(numbers));
    }

    @Test
    public void checkSumOfTwoInArray_mixed_numbers_not_contains_1() {

        int[] numbers = {0, 5, -2, -1, 0, 10, -23};

        assertFalse(sum.checkSumOfTwoInArray(numbers));
    }

    @Test
    public void checkSumOfTwoInArray_mixed_numbers_not_contains_2() {

        int[] numbers = {-10, 2, -9, 13, 0};

        assertFalse(sum.checkSumOfTwoInArray(numbers));
    }

    @Test
    public void checkSumOfTwoInArray_negative_numbers() {

        int[] numbers = {-20, -11, -2, -8, -2, -15, -4};

        assertTrue(sum.checkSumOfTwoInArray(numbers));
    }

    @Test
    public void checkSumOfTwoInArray_negative_numbers_1() {

        int[] numbers = {-20, -1, -2, -8, -2, -15, -1};

        assertTrue(sum.checkSumOfTwoInArray(numbers));
    }

    @Test
    public void checkSumOfTwoInArray_negative_numbers_2() {

        int[] numbers = {-1, -1, -2, -8, -1};

        assertTrue(sum.checkSumOfTwoInArray(numbers));
    }

    @Test
    public void checkSumOfTwoInArray_negative_numbers_if_not_contains() {

        int[] numbers = {-1, -1, -3, -8, -1};

        assertFalse(sum.checkSumOfTwoInArray(numbers));
    }

    @Test
    public void checkSumOfTwoInArray_negative_numbers_if_not_contains_1() {

        int[] numbers = {-20, -1, -3, -1, -100};

        assertFalse(sum.checkSumOfTwoInArray(numbers));
    }
}