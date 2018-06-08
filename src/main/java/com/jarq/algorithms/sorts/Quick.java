package com.jarq.algorithms.sorts;

import java.util.List;

public class Quick implements Sorting {

    private int[] array;

    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> elements) {
        return null;
    }

    @Override
    public int[] sort(int[] numbers) {
        if(numbers.length < 2) {
            throw new IllegalStateException();
        }

        this.array = numbers;
        int left = 0;
        int right = array.length-1;
        handleSort(left, right);
        return array;
    }

    private void handleSort(int left, int right) {
        if(left < right) {
            int index = partition(left, right);

            if (left < index - 1) {
                handleSort(left, index-1);
            }
            if (index < right) {
                handleSort(index, right);
            }
        }
    }

    private int partition(int left, int right) {
        int i = left;
        int j = right;
        int value = getValueToCompare(left, right);

        while(i <= j) {
            while(array[i] < value) {
                i++;
            }
            while(array[j] > value) {
                j--;
            }
            if(i<=j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private int getValueToCompare(int left, int right) {
        return array[(left + right) / 2];
    }
}
