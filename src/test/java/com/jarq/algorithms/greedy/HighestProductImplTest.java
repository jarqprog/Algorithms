package com.jarq.algorithms.greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class HighestProductImplTest {

    private HighestProduct hp = new HighestProductImpl();

    @Test
    public void calculate() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateForThree_using_invalid_array() throws IllegalArgumentException {

        hp.calculateForThree(new int[2]);
    }

    @Test
    public void calculateForThree_using_zeros_array() {

        int[] numbers = new int[10];
        Integer expected = 0;

        assertEquals(expected, hp.calculateForThree(numbers));
    }

    @Test
    public void calculateForThree_using_positive_numbers() {

        int[] numbers = {4, 5, 1, 2, 9, 8, 100, 10};
        Integer expected = 9000;

        assertEquals(expected, hp.calculateForThree(numbers));
    }

    @Test
    public void calculateForThree_using_mixed_numbers() {

        int[] numbers = {4, 5, 1, 2, 9, 8, 20, 10, -20, -40};
        Integer expected = 16000;

        assertEquals(expected, hp.calculateForThree(numbers));
    }


    @Test
    public void calculateForThree_using_negative_numbers() {

        int[] numbers = {-1, -2, -3, -20, -40};
        Integer expected = -6;

        assertEquals(expected, hp.calculateForThree(numbers));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateForThreeWithLoops_using_invalid_array() throws IllegalArgumentException {

        hp.calculateForThreeWithLoops(new int[2]);
    }

    @Test
    public void calculateForThreeWithLoops_easy() {

        int[] numbers = {4, 5, 1, 2};
        int expected = 40;

        assertEquals(expected, hp.calculateForThreeWithLoops(numbers));
    }

    @Test
    public void calculateForThreeWithLoops_using_positive_numbers() {

        int[] numbers = {4, 5, 1, 2, 9, 8, 100, 10};
        int expected = 9000;

        assertEquals(expected, hp.calculateForThreeWithLoops(numbers));
    }


    @Test
    public void calculateForThreeWithLoops_using_mixed_numbers() {

        int[] numbers = {4, 5, 1, 2, 9, 8, 20, 10, -20, -40};
        int expected = 16000;

        assertEquals(expected, hp.calculateForThreeWithLoops(numbers));
    }

    @Test
    public void calculateForThreeWithLoops_using_negative_numbers() {

        int[] numbers = {-1, -2, -3, -20, -40};
        int expected = -6;

        assertEquals(expected, hp.calculateForThreeWithLoops(numbers));
    }
}