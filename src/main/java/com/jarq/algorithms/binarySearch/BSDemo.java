package com.jarq.algorithms.binarySearch;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BSDemo {
    public static void main(String[] args) {

        BinarySearch<Integer> search = new IntBinarySearch();
        int range = 1000;
        int size = 100000;
        int valueThatSurelyIs = 999;
        int valueThatIsNotIn = range + 101;

        List<Integer> numbers = createRandomList(range, size);
        numbers.add(valueThatSurelyIs);
        System.out.println("created list with size: " + size);
        System.out.println("let's start benchmark: list contains() vs jq binary search:");

        long start;
        double time;
        boolean containsNumber;
        boolean notContainsNumber;
        boolean notContainsNegativeNumber;

        start = System.nanoTime();
        containsNumber = numbers.contains(valueThatSurelyIs);
        notContainsNumber = numbers.contains(valueThatIsNotIn);
        notContainsNegativeNumber = numbers.contains(valueThatIsNotIn*-1);
        time = getExecutionTimeInMilliseconds(start);

        System.out.println(String.format("java's list contains() executed in %f (ms) with result: %s",
                time, containsNumber && !notContainsNumber && !notContainsNegativeNumber));

        start = System.nanoTime();
        containsNumber = search.contains(numbers, valueThatSurelyIs);
        notContainsNumber = search.contains(numbers, valueThatIsNotIn);
        notContainsNegativeNumber = search.contains(numbers, valueThatIsNotIn*-1);
        time = getExecutionTimeInMilliseconds(start);

        System.out.println(String.format("binary search contains() with list executed in %f (ms) with result: %s",
                time, containsNumber && !notContainsNumber && !notContainsNegativeNumber));
        System.out.println("Let's do this with binary search using array: ");

        Integer[] array = createRandomIntArray(range, size, valueThatSurelyIs);

        start = System.nanoTime();
        containsNumber = search.contains(array, valueThatSurelyIs);
        notContainsNumber = search.contains(array, valueThatIsNotIn);
        notContainsNegativeNumber = search.contains(array, valueThatIsNotIn*-1);
        time = getExecutionTimeInMilliseconds(start);

        System.out.println(String.format("binary search contains() with array executed in %f (ms) with result: %s",
                time, containsNumber && !notContainsNumber && !notContainsNegativeNumber));

    }

    private static double getExecutionTimeInMilliseconds(long startInNanos) {
        double nanoToMillisDivider = 100000;
        return (System.nanoTime() - startInNanos) / nanoToMillisDivider;
    }

    private static List<Integer> createRandomList(int valueRange, int size) {
        Random chaos = new Random();
        int num;
        List<Integer> numbers = new ArrayList<>(size);
        for(int i=0; i<size-1; i++) {
            num = chaos.nextInt(valueRange);
            if(chaos.nextBoolean()) {
                num *= -1;
            }
            numbers.add(num);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    private static Integer[] createRandomIntArray(int valueRange, int size, int valueThatSurelyIs) {
        Random chaos = new Random();
        int num;
        Integer[] numbers = new Integer[size];
        numbers[0] = valueThatSurelyIs;
        for(int i=1; i<size; i++) {
            num = chaos.nextInt(valueRange);
            if(chaos.nextBoolean()) {
                num *= -1;
            }
            numbers[i] = num;
        }
        numbers = shuffleArray(numbers);
        return numbers;
    }

    private static Integer[] shuffleArray(Integer[] toShuffle) {
        // from: https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
        Random rnd = ThreadLocalRandom.current();
        for (int i = toShuffle.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = toShuffle[index];
            toShuffle[index] = toShuffle[i];
            toShuffle[i] = a;
        }
        return toShuffle;
    }
}
