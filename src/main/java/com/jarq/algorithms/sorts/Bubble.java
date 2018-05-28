package com.jarq.algorithms.sorts;

import java.util.List;

public class Bubble implements Sorting {

    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> elements) {
        int len = elements.size();
        T temp;

        for(int i=0; i<len; i++) {
            for(int j=1; j<len; j++) {

                T current = elements.get(j);
                T prev = elements.get(j-1);

                if(current.compareTo(prev) < 0) {
                    temp = prev;
                    elements.set(j-1, current);
                    elements.set(j, temp);
                }
            }
        }
        return elements;
    }

    @Override
    public int[] sort(int[] elements) {
        int len = elements.length;
        int temp;

        for(int i=0; i<len; i++) {
            for(int j=1; j<len; j++) {

                int current = elements[j];
                int prev = elements[j-1];

                if(current < prev) {
                    temp = prev;
                    elements[j-1] = current;
                    elements[j] = temp;
                }
            }
        }
        return elements;
    }
}