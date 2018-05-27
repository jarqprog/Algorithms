package com.jarq.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    private IFibonacci fib = new Fibonacci();

    @Test
    public void perform_for_0() {

        assertEquals(0, fib.perform(0));
    }

    @Test
    public void perform_for_1() {

        assertEquals(1, fib.perform(1));
    }

    @Test
    public void perform_for_5() {
        assertEquals(5, fib.perform(5));
    }

    @Test
    public void perform_for_10() {
        assertEquals(55, fib.perform(10));
    }


    @Test
    public void performRec_for_0() {

        assertEquals(0, fib.performRec(0));
    }

    @Test
    public void performRec_for_1() {

        assertEquals(1, fib.performRec(1));
    }

    @Test
    public void performRec_for_5() {
        assertEquals(5, fib.performRec(5));
    }

    @Test
    public void performRec_for_10() {
        assertEquals(55, fib.performRec(10));
    }
}
