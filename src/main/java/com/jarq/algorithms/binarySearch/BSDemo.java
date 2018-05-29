package com.jarq.algorithms.binarySearch;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BSDemo {

    private final static int numberOfLoops = 7;

    public static void main(String[] args) {

        BinarySearch<Integer> search = new IntBinarySearch();
        Random chaos = new Random();
        int range = 10000;
        int size = 10000;
        int valueThatSurelyIs = 999;
        int valueThatIsNotIn;

        List<List<Integer>> numbersCollection = generateNumbersCollections(range, size, valueThatSurelyIs);
        Integer[] array = createRandomIntArray(range, size, valueThatSurelyIs);
        System.out.println("created list with size: " + size);
        System.out.println("let's start benchmark: list contains() vs jq's binary search:");

        for(int i=1; i<=numberOfLoops; i++) {
            System.out.println("\n****** " + i + ". benchmark:\n");
            valueThatIsNotIn = range + 1 + chaos.nextInt(range);
            if(chaos.nextBoolean()) {
                valueThatIsNotIn *= -1;
            }
            benchmark(search, numbersCollection.get(i-1), array, valueThatSurelyIs, valueThatIsNotIn);
        }
    }

    private static void benchmark(BinarySearch<Integer> search, List<Integer> numbers, Integer[] array,
                                  int valueThatSurelyIs, int valueNotIn) {
        long start;
        double time;
        boolean containsNumber;
        boolean notContainsNumber;
        boolean notContainsNegativeNumber;

        start = System.nanoTime();
        containsNumber = numbers.contains(valueThatSurelyIs);
        notContainsNumber = numbers.contains(valueNotIn);
        notContainsNegativeNumber = numbers.contains(valueNotIn*-1);
        time = getExecutionTimeInMilliseconds(start);

        System.out.println(String.format("java's list contains() executed in %f (ms), is success: %s",
                time, containsNumber && !notContainsNumber && !notContainsNegativeNumber));

        start = System.nanoTime();
        containsNumber = search.contains(numbers, valueThatSurelyIs);
        notContainsNumber = search.contains(numbers, valueNotIn);
        notContainsNegativeNumber = search.contains(numbers, valueNotIn*-1);
        time = getExecutionTimeInMilliseconds(start);

        System.out.println(String.format("binary search contains() with list executed in %f (ms), is success: %s",
                time, containsNumber && !notContainsNumber && !notContainsNegativeNumber));

        start = System.nanoTime();
        containsNumber = search.contains(array, valueThatSurelyIs);
        notContainsNumber = search.contains(array, valueNotIn);
        notContainsNegativeNumber = search.contains(array, valueNotIn*-1);
        time = getExecutionTimeInMilliseconds(start);

        System.out.println(String.format("binary search contains() with array executed in %f (ms), is success: %s",
                time, containsNumber && !notContainsNumber && !notContainsNegativeNumber));
    }

    private static List<List<Integer>> generateNumbersCollections(int valueRange, int size, int valueThatSurelyIs) {
        List<List<Integer>> collections = new ArrayList<>();
        for(int i=0; i<numberOfLoops; i++) {
            collections.add(createRandomList(valueRange, size, valueThatSurelyIs));
        }
        return collections;
    }

    private static double getExecutionTimeInMilliseconds(long startInNanos) {
        double nanoToMillisDivider = 100000;
        return (System.nanoTime() - startInNanos) / nanoToMillisDivider;
    }

    private static List<Integer> createRandomList(int valueRange, int size, int valueThatSurelyIs) {
        Random chaos = new Random();
        int num;
        List<Integer> numbers = new ArrayList<>(size);
        numbers.add(valueThatSurelyIs);
        for(int i=1; i<size-1; i++) {
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
