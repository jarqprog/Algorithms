package com.jarq.algorithms.nearbyElements;

import org.junit.Test;

import static org.junit.Assert.*;

public class NearbyIntegersTest {

    private NearbyElements<Integer> nearbyElements = new NearbyIntegers(getData());

    @Test(expected = IllegalArgumentException.class)
    public void nearby_with_negative_indexes() throws IllegalArgumentException {
        nearbyElements.nearby(-1,-1,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nearby_with_invalid_indexes() throws IllegalArgumentException {
        nearbyElements.nearby(0,20,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nearby_using_zero_range() throws IllegalArgumentException {
        nearbyElements.nearby(0,0,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nearby_using_negative_range() throws IllegalArgumentException {
        nearbyElements.nearby(0,0,-1);
    }

    @Test
    public void nearby1() {

        Integer[] expected = new Integer[]{2, 0, 1241, 12};

        Integer[] result = nearbyElements.nearby(0,2,2);

        assertArrayEquals(expected, result);
    }

    @Test
    public void nearby2() {

        Integer[] expected = new Integer[]{3};

        Integer[] result = nearbyElements.nearby(1, 0, 1);

        assertArrayEquals(expected, result);
    }

    @Test
    public void nearby3() {

        Integer[] expected = new Integer[]{1, 3, 5};

        Integer[] result = nearbyElements.nearby(1, 3, 5);

        assertArrayEquals(expected, result);
    }

    @Test
    public void nearby4() {

        Integer[] expected = new Integer[]{320, 32, 3, 41241, -11};

        Integer[] result = nearbyElements.nearby(2, 0, 5);

        assertArrayEquals(expected, result);
    }

    @Test
    public void nearby5() {

        Integer[] expected = new Integer[]{321, 320, 3, 41241, -11, -12, -13};

        Integer[] result = nearbyElements.nearby(2, 2, 5);

        assertArrayEquals(expected, result);
    }

    private int[][] getData() {

        return new int[][]{
                { 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
                { 1, 3, 5, 7 },
                { 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
        };
    }
}