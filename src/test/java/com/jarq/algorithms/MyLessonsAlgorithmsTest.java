package com.jarq.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyLessonsAlgorithmsTest {

    private LessonsAlgorithms algorithms = new MyLessonsAlgorithms();

    @Test
    public void reverseString() {

        String toReverse = "Alba baobab!";

        String expected = "!baboab ablA";

        assertEquals(expected, algorithms.reverseString(toReverse));
    }

    @Test
    public void factorial_with_1() {

        long expected = 1;

        assertEquals(expected, algorithms.factorial(1));
    }

    @Test
    public void factorial_with_5() {

        long expected = 120;

        assertEquals(expected, algorithms.factorial(5));
    }

    @Test
    public void factorial_with_10() {

        long expected = 3628800;

        assertEquals(expected, algorithms.factorial(10));
    }

    @Test
    public void isPalindrom_not_palindrom() {

        String toCheck = "An nak!";

        assertFalse(algorithms.isPalindrom(toCheck));
    }

    @Test
    public void isPalindrom_easy_case_insensitive() {

        String toCheck = "Ana";

        assertTrue(algorithms.isPalindrom(toCheck));
    }

    @Test
    public void isPalindrom_hard_case_insensitive() {

        String toCheck = "A man, a plan, a canal. Panama";

        assertTrue(algorithms.isPalindrom(toCheck));
    }

    @Test
    public void findLongest_on_empty() {

        String toCheck = "";

        assertEquals("", algorithms.findLongestWord(toCheck));
    }

    @Test
    public void findLongest_if_one_word() {

        String toCheck = "Justinian ";

        assertEquals("Justinian", algorithms.findLongestWord(toCheck));
    }

    @Test
    public void findLongest_normal_difficulty() {

        String toCheck = "What is the average airspeed velocity of an unladen swallow";

        assertEquals("airspeed", algorithms.findLongestWord(toCheck));
    }


    @Test
    public void titleCase_with_empty_string() {
        assertEquals("", algorithms.findLongestWord(""));
    }


    @Test
    public void titleCase() {

        String toCapitalize = "I'm a little tea pot";
        String expected  = "I'm A Little Tea Pot";

        assertEquals(expected, algorithms.titleCase(toCapitalize));
    }


    @Test
    public void titleCase_all_uppercase() {

        String toCapitalize = "HERE IS MY HANDLE HERE IS MY SPOUT";
        String expected  = "Here Is My Handle Here Is My Spout";

        assertEquals(expected, algorithms.titleCase(toCapitalize));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findKMax_using_invalid_array() throws IllegalArgumentException {

        int[] numbers = new int[0];
        algorithms.findKMax(numbers, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findKMax_using_invalid_k() throws IllegalArgumentException {

        int[] numbers = {1, 5, 4, 10, 12, 3, 8};
        algorithms.findKMax(numbers, 11);
        algorithms.findKMax(numbers, 0);
    }

    @Test
    public void findKMax() {

        int[] numbers = {1, 5, 4, 10, 12, 3, 8};
        int kMax = 3;

        assertEquals(8, algorithms.findKMax(numbers, kMax));
    }

    @Test
    public void findKMax_with_negative_numbers() {

        int[] numbers = {10, 11, 13, 1, 5, 4, 10, 12, 3, 8, -1, -30, 21, 100};
        int kMax = 2;

        assertEquals(21, algorithms.findKMax(numbers, kMax));
    }

    @Test
    public void findKMax_if_k_equals_1() {

        int[] numbers = {15, 5, 4, 10, 12, 3, 8};
        int kMax = 1;

        assertEquals(15, algorithms.findKMax(numbers, kMax));
    }

    @Test
    public void findKMax_with_repeated_numbers() {

        int[] numbers = {1, 5, 4, 10, 10, 3, 8, 10, 10};
        int kMax = 4;

        assertEquals(10, algorithms.findKMax(numbers, kMax));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findKMaxWithTransform_using_invalid_array() throws IllegalArgumentException {

        int[] numbers = new int[0];
        algorithms.findKMaxWithTransform(numbers, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findKMaxWithTransform_using_invalid_k() throws IllegalArgumentException {

        int[] numbers = {1, 5, 4, 10, 12, 3, 8};
        algorithms.findKMaxWithTransform(numbers, 11);
        algorithms.findKMaxWithTransform(numbers, 0);
    }

    @Test
    public void findKMaxWithTransform() {

        int[] numbers = {1, 5, 4, 10, 12, 3, 8};
        int kMax = 3;

        assertEquals(8, algorithms.findKMaxWithTransform(numbers, kMax));
    }

    @Test
    public void findKMaxWithTransform_with_repeated_numbers() {

        int[] numbers = {1, 5, 4, 10, 10, 3, 8, 10, 10};
        int kMax = 4;

        assertEquals(10, algorithms.findKMaxWithTransform(numbers, kMax));
    }
}