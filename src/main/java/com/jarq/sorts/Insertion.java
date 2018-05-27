package com.jarq.sorts;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Insertion implements Sorting {

    public List<Integer> executeSort(List<Integer> elements) {
        long startTime = System.currentTimeMillis();
        elements = new LinkedList<>(elements);
        Integer[] numbers = elements.toArray(new Integer[0]);
        int length = elements.size();
        for(int i=0; i<length - 1; i++) {
            if(numbers[i] > numbers[i+1]) {
                for(int j=i+1; j>0; --j) {
                    if(numbers[j] > numbers[j-1]) {
                        break;
                    }
                    int tmp = numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("\nElapsed time  using Insertion Sort: " + estimatedTime);
        return new LinkedList<>(Arrays.asList(numbers));
    }
}