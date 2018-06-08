package com.jarq.algorithms.sorts;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickTest {

    private Sorting quick = new Quick();

    @Test
    public void sort() {

        int[] numbers = {5, 4, 2, 7, -100, 20, 12, 99, 0, 1, 3};
        int[] expected = {-100, 0, 1, 2, 3, 4, 5, 7, 12, 20, 99};

        assertArrayEquals(expected, quick.sort(numbers));

    }
}