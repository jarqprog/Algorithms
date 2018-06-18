package com.jarq.algorithms.flatteningList;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FlatteningListTest {

    private FlatteningList algo = new FlatteningList();

    @Test
    public void flatten() {

        Object[] input = {1, 2, 3, new String []{"My", "You", "Wrr"}, 3, 5,
                new Object[] {7, 800, new Object[] {"Mom", "Dad", "Son", 100, new Object[] {9}}}};
        Object[] expected = {1, 2, 3, "My", "You", "Wrr", 3, 5, 7, 800, "Mom", "Dad", "Son", 100, 9};
        Object[] output = algo.flatten(input);

        assertArrayEquals(expected, output);
    }
}