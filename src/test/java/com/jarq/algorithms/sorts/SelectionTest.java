package com.jarq.algorithms.sorts;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SelectionTest {

    private Sorting sorting = new Selection();

    @Test
    public void sort_list() {

        List<Integer> unsorted = Arrays.asList(4, -11, 8, 2000, -3, 1, 0);
        List<Integer> sorted = Arrays.asList(-11, -3, 0, 1, 4, 8, 2000);

        assertEquals(sorted, sorting.sort(unsorted));
    }

    @Test
    public void sort_array() {

        int[] unsorted = {4, -11, 8, 2000, -3, 1, 2};
        int[] sorted = {-11, -3, 1, 2, 4, 8, 2000};

        assertArrayEquals(sorted, sorting.sort(unsorted));
    }
}