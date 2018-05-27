package com.jarq.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactorialTest {

    private IFactorial fact = new Factorial();

    @Test
    public void perform_for_0() {

        assertEquals(1, fact.perform(0));
    }

    @Test
    public void perform_for_1() {

        assertEquals(1, fact.perform(1));
    }

    @Test
    public void perform_for_5() {
        assertEquals(120, fact.perform(5));
    }

    @Test
    public void perform_for_10() {
        assertEquals(3628800, fact.perform(10));
    }


    @Test
    public void performRec_for_0() {

        assertEquals(1, fact.performRec(0));
    }

    @Test
    public void performRec_for_1() {

        assertEquals(1, fact.performRec(1));
    }

    @Test
    public void performRec_for_5() {
        assertEquals(120, fact.performRec(5));
    }

    @Test
    public void performRec_for_10() {
        assertEquals(3628800, fact.performRec(10));
    }
}