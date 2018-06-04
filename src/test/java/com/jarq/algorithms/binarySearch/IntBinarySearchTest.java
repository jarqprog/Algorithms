package com.jarq.algorithms.binarySearch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class IntBinarySearchTest {

    private BinarySearch<Integer> search = new IntBinarySearch();

    // for list
    @Test
    public void contains_with_empty_list() {
        assertFalse(search.contains(new ArrayList<>(), 1));
    }

    @Test
    public void contains_using_number_not_in_list() {
        assertFalse(search.contains(createList(), -100));
    }

    @Test
    public void contains_using_number_not_in_list_1() {
        assertFalse(search.contains(createList(), 8));
    }

    @Test
    public void contains_using_number_in_list() {
        assertTrue(search.contains(createList(),10));
    }

    @Test
    public void contains_using_number_in_list_1() {
        assertTrue(search.contains(createList(),0));
    }

    @Test
    public void contains_using_number_in_list_2() {
        assertTrue(search.contains(createList(),-12));
    }


    // for array
    @Test
    public void contains_with_empty_array() {
        assertFalse(search.contains(new Integer[10], 1));
    }

    @Test
    public void contains_using_number_not_in_array() {
        assertFalse(search.contains(createArray(), -100));
    }

    @Test
    public void contains_using_number_not_in_array_1() {
        assertFalse(search.contains(createArray(), 8));
    }

    @Test
    public void contains_using_number_in_array() {
        assertTrue(search.contains(createArray(),10));
    }

    @Test
    public void contains_using_number_in_array_1() {
        assertTrue(search.contains(createArray(),0));
    }

    @Test
    public void contains_using_number_in_array_2() {
        assertTrue(search.contains(createArray(),-12));
    }

    @Test(expected = IllegalArgumentException.class)
    public void countRotations_with_invalid_array() throws IllegalArgumentException {
        search.countRotationsInArray(new Integer[]{1});
    }

    @Test
    public void countRotations_using_not_rotated() {
        Integer[] numbers = {0, 3, 5, 8, 10};
        int expected = 0;
        assertEquals(expected, search.countRotationsInArray(numbers));
    }

    @Test
    public void countRotations_with_small_array() {
        Integer[] numbers = {4, 5, 6, 1, 2, 3};
        int expected = 3;
        assertEquals(expected, search.countRotationsInArray(numbers));
    }

    @Test
    public void countRotations_using_negative_numbers() {
        Integer[] numbers = {23, 25, 29, 30, -1, 0, 3, 5, 8, 10};
        int expected = 4;
        assertEquals(expected, search.countRotationsInArray(numbers));
    }

    @Test
    public void countRotations_using_array_with_same_elements() {
        Integer[] numbers = {1, 1, 1, 1, 1};
        int expected = 0;  // no rotation
        assertEquals(expected, search.countRotationsInArray(numbers));
    }

    @Test
    public void countRotations_using_array_with_no_rotation_and_repeating_elements() {
        Integer[] numbers = {-2, -2, -1, -1, 1, 1, 2, 2, 3, 3, 3};
        int expected = 0;
        assertEquals(expected, search.countRotationsInArray(numbers));
    }

    @Test
    public void countRotations_using_repeating_elements_small_array() {
        Integer[] numbers = {23, 23, 23, 23, 0, 0, 1, 1, 1};
        int expected = 4;
        assertEquals(expected, search.countRotationsInArray(numbers));
    }

    @Test
    public void countRotations_using_repeating_elements() {
        Integer[] numbers = {23, 23, 23, 25, 25, 29, 30, 30, 30, 30, -1, -1, 0, 3, 3, 3, 3, 5, 8, 10};
        int expected = 10;
        assertEquals(expected, search.countRotationsInArray(numbers));
    }

    private List<Integer> createList() {
        return Arrays.asList(10, 15, 20, -20, 11, 0, 2, 7, 9, -12, 4, 3);
    }

    private Integer[] createArray() {
        return new Integer[] {10, 15, 20, -20, 11, 0, 2, 7, 9, -12, 4, 3};
    }
}