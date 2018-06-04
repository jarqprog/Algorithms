package com.jarq.algorithms.binarySearch;

import java.util.Arrays;
import java.util.List;

public class IntBinarySearch implements BinarySearch<Integer> {

    @Override
    public boolean contains(List<Integer> elements, Integer element) {
        if(elements.size() == 0 || elements.get(0) == null) {
            return false;
        }

        int[] primitives = transformListToArray(elements);  // it's more efficient to operate on primitives (checked)
        Arrays.sort(primitives);

        int leftBorder = 0;
        int rightBorder = primitives.length - 1;

        return containsRec(primitives, element, leftBorder, rightBorder);
    }

    @Override
    public int countRotationsInArray(Integer[] elements) {

        int length = elements.length;
        int middle;
        int left = 0;
        int right = length-1;

        if(length < 2) {
            throw new IllegalArgumentException("table must contain at least 2 elements!");
        }

        if(elements[0] <= elements[right]) {  // there was no table rotation
            return 0;
        }

        while(left < right) {
            middle = (left + right) / 2;
            if (elements[middle] < elements[middle - 1]) {
                return middle;
            }

            if (elements[middle] < elements[middle + 1]) {
                return middle + 1;
            }

            // in case of repeating elements:
            if(
                    elements[middle].equals(elements[middle-1]) ||
                    elements[middle].equals(elements[middle+1])) {
                int counter = middle;
                while (counter > left) {  // check to the left
                    if (elements[counter] < elements[counter - 1]) {
                        return counter;
                    } else if (elements[counter] > elements[counter - 1]) {
                        break;
                    }
                    counter--;
                }
                counter = middle;
                while (counter < right) {  // check to the right
                    if (elements[counter] > elements[counter + 1]) {
                        return counter + 1;
                    } else if (elements[counter] < elements[counter - 1]) {
                        break;
                    }
                    counter++;
                }
            }
            // end block devoted to repeating elements

            if (elements[middle] > elements[right]) {
                left = middle;
            } else if (elements[middle] < elements[right]) {
                right = middle;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Integer[] elements, Integer element) {
        if(elements.length == 0 || elements[0] == null) {
            return false;
        }

        int[] primitives = transformArrayToPrimitivesArray(elements);
        Arrays.sort(primitives);

        int leftBorder = 0;
        int rightBorder = elements.length - 1;

        return containsRec(primitives, element, leftBorder, rightBorder);
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
