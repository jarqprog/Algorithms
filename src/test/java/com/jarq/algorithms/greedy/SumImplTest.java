package com.jarq.algorithms.greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumImplTest {

    private Sum sum = new SumImpl();

    @Test(expected = IllegalArgumentException.class)
    public void check_with_invalid_array() throws IllegalArgumentException {

        sum.checkSumOfTwo(new int[0], 2);

    }

    @Test
    public void check_positive_numbers_small_array() {

        int[] numbers = {8, 2, 15, 1};

        assertTrue(sum.checkSumOfTwo(numbers, 17));
    }

    @Test
    public void check_positive_numbers_small_array_not_contains() {

        int[] numbers = {8, 2, 15, 1};

        assertFalse(sum.checkSumOfTwo(numbers, 100));
    }

    @Test
    public void check_mixed_numbers() {

        int[] numbers = {-20, 1, -2, 8, 2, 15, 1, -10, -21, 1000};

        assertTrue(sum.checkSumOfTwo(numbers, 5));
    }

    @Test
    public void check_mixed_numbers_not_contains() {

        int[] numbers = {-20, 1, -2, 8, 2, 15, 1, -10, -21, 1000};

        assertFalse(sum.checkSumOfTwo(numbers, 100012));
    }
}