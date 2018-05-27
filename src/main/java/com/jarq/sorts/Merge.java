package com.jarq.sorts;

import java.util.*;

public class Merge implements Sorting {

    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> elements) {
        int size = elements.size();
        if(size < 2) {
            return elements;
        }

        int middle = size/ 2;
        List<T> left = sort(elements.subList(0, middle));
        List<T> right = sort(elements.subList(middle, size));
        return merge(left, right);
    }

    @Override
    public int[] sort(int[] elements) {
        int size = elements.length;
        if(size < 2) {
            return elements;
        }

        int middle = size/ 2;
        int[] left = sort(Arrays.copyOfRange(elements,0, middle));
        int[] right = sort(Arrays.copyOfRange(elements,middle, size));
        return merge(left, right);
    }


    private int[] merge(int[] left, int[] right) {

        int leftIndex = 0;
        int leftSize = left.length;

        int rightIndex = 0;
        int rightSize = right.length;

        int[] result = new int[leftSize + rightSize];
        int resultIndex = 0;

        while(leftIndex < leftSize && rightIndex < rightSize) {

            if(left[leftIndex] < right[rightIndex]) {
                result[resultIndex] = left[leftIndex];
                leftIndex++;
            } else {
                result[resultIndex] = right[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        while(leftIndex < leftSize) {
            result[resultIndex] = left[leftIndex];
            leftIndex++;
            resultIndex++;
        }

        while(rightIndex < rightSize) {
            result[resultIndex] = right[rightIndex];
            rightIndex++;
            resultIndex++;
        }
        return result;
    }

    private <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {

        int leftIndex = 0;
        int leftSize = left.size();

        int rightIndex = 0;
        int rightSize = right.size();

        List<T> result = new LinkedList<>();

        while(leftIndex < leftSize && rightIndex < rightSize) {

            T currentLeft = left.get(leftIndex);
            T currentRight = right.get(rightIndex);

            if(currentLeft.compareTo(currentRight) < 0) {
                result.add(currentLeft);
                leftIndex++;
            } else {
                result.add(currentRight);
                rightIndex++;
            }
        }

        while(leftIndex < leftSize) {
            result.add(left.get(leftIndex));
            leftIndex++;
        }

        while(rightIndex < rightSize) {
            result.add(right.get(rightIndex));
            rightIndex++;
        }
        return result;
    }
}
