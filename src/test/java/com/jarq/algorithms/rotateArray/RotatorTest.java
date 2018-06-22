package com.jarq.algorithms.rotateArray;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public abstract class RotatorTest {

    private IntArrayRotator rotator;

    @Test
    public void rotate_using_one_elements() {
        int[] numbers = createNumbers(1);
        int k = 1;

        int[] result = rotator.rotate(numbers, k);

        assertArrayEquals(result, result);
    }

    @Test
    public void rotate_using_three_elements() {
        int[] numbers = createNumbers(3);
        int k = 1;
        int[] expected = {3, 1, 2};

        int[] result = rotator.rotate(numbers, k);

        assertArrayEquals(expected, result);
    }

    @Test
    public void rotate_using_five_elements() {
        int[] numbers = createNumbers(5);
        int k = 2;
        int[] expected = {4, 5, 1, 2, 3};

        int[] result = rotator.rotate(numbers, k);

        assertArrayEquals(expected, result);
    }


    @Test
    public void rotate_using_if_rotation_number_greater_than_array_length() {
        int[] numbers = createNumbers(4);
        int k = 5;
        int[] expected = {4, 1, 2, 3};

        int[] result = rotator.rotate(numbers, k);

        assertArrayEquals(expected, result);
    }

    private int[] createNumbers(int size) {
        int[] result = new int[size];
        for (int i=0; i<size; i++) {
            result[i] = i+1;
        }
        return result;
    }

    protected void setRotator(IntArrayRotator rotator) {
        this.rotator = rotator;
    }
}
