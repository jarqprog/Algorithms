package com.jarq.algorithms.binarySearch;

import java.util.Arrays;
import java.util.List;

public class IntBinarySearch implements BinarySearch<Integer> {

    @Override
    public boolean contains(List<Integer> numbers, Integer number) {
        if(numbers.size() == 0 || numbers.get(0) == null) {
            return false;
        }

        int[] primitives = transformListToArray(numbers);  // it's more efficient to operate on primitives (checked)
        Arrays.sort(primitives);

        int leftBorder = 0;
        int rightBorder = primitives.length - 1;

        return containsRec(primitives, number, leftBorder, rightBorder);
    }

    @Override
    public boolean contains(Integer[] numbers, Integer number) {
        if(numbers.length == 0 || numbers[0] == null) {
            return false;
        }

        int[] primitives = transformArrayToPrimitivesArray(numbers);
        Arrays.sort(primitives);

        int leftBorder = 0;
        int rightBorder = numbers.length - 1;

        return containsRec(primitives, number, leftBorder, rightBorder);
    }

    /**
     * new version - without arrays copy
     */
    private boolean containsRec(int[] numbers, int number, int leftBorder, int rightBorder) {

        if(leftBorder == rightBorder) {
            return false;
        }

        if(rightBorder - leftBorder == 1) {
            return numbers[leftBorder] == number;
        }

        if(numbers[leftBorder] > number || numbers[rightBorder] < number) {
            return false;
        }

        int middleIndex = (rightBorder + leftBorder) / 2;
        int middle = numbers[middleIndex];
        if(middle == number) {
            return true;
        }

        if(middle > number) {
            rightBorder = middleIndex;
        } else {
            leftBorder = middleIndex;
        }

        return containsRec(numbers, number, leftBorder, rightBorder);
    }

    /**
     * old version - using arrays copy
     */
    private boolean containsRec(int[] numbers, int number) {

        int size = numbers.length;
        if(size == 0) {
            return false;
        }

        if(size == 1) {
            return numbers[0] == number;
        }

        if(numbers[0] > number || numbers[size-1] < number) {
            return false;
        }

        int middleIndex = size / 2;

        int middle = numbers[middleIndex];

        if(middle == number) {
            return true;
        }

        if(middle > number) {
            numbers = Arrays.copyOfRange(numbers, 0, middleIndex);
        } else {
            numbers = Arrays.copyOfRange(numbers, middleIndex, numbers.length);
        }

        return containsRec(numbers, number);
    }

    private int[] transformListToArray(List<Integer> list) {
        int[] copy = new int[list.size()];
        for(int i=0; i<copy.length; i++) {
            copy[i] = list.get(i);
        }
        return copy;
    }

    private int[] transformArrayToPrimitivesArray(Integer[] objects) {
        int[] copy = new int[objects.length];
        for(int i=0; i<copy.length; i++) {
            copy[i] = objects[i];
        }
        return copy;
    }

}
