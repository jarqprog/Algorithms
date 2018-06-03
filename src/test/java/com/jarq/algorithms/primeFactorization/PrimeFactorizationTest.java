package com.jarq.algorithms.primeFactorization;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class PrimeFactorizationTest {

    private IPrimeFactorization primeFactorization = new PrimeFactorization();

    @Test(expected = IllegalArgumentException.class)
    public void getFactors_using_negative_number() throws IllegalArgumentException {
        primeFactorization.getFactors(-11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFactors_using_zero() throws IllegalArgumentException {
        primeFactorization.getFactors(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFactors_using_one() throws IllegalArgumentException {
        primeFactorization.getFactors(1);
    }

    @Test
    public void getFactors_for_2(){

        Set<Integer> expected = Collections.singleton(2);

        Set<Integer> result = primeFactorization.getFactors(2);

        assertEquals(expected, result);
    }

    @Test
    public void getFactors_for_11(){

        Set<Integer> expected = Collections.singleton(11);

        Set<Integer> result = primeFactorization.getFactors(11);

        assertEquals(expected, result);
    }

    @Test
    public void getFactors_for_50(){

        Set<Integer> expected = new TreeSet<>(Arrays.asList(2, 5));

        Set<Integer> result = primeFactorization.getFactors(50);

        assertEquals(expected, result);
    }

    @Test
    public void getFactors_for_105(){

        Set<Integer> expected = new TreeSet<>(Arrays.asList(3, 5, 7));

        Set<Integer> result = primeFactorization.getFactors(105);

        assertEquals(expected, result);
    }
}