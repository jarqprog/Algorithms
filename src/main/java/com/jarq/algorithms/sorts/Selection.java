package com.jarq.algorithms.sorts;

import java.util.List;

public class Selection implements Sorting {

    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> elements) {

        int len = elements.size();
        int min;

        for (int i=0; i<len-1; i++) {
            min = i;

            for (int j=i+1; j<len; j++) {
                if (elements.get(j).compareTo(elements.get(min)) < 0 ) {
                    min = j;
                }
            }

            if (i != min) {
                T temp = elements.get(i);
                elements.set(i, elements.get(min));
                elements.set(min, temp);
            }
        }
        return elements;
    }

    @Override
    public int[] sort(int[] elements) {

        int len = elements.length;
        int min;

        for (int i=0; i<len-1; i++) {
            min = i;

            for (int j=i+1; j<len; j++) {
                if (elements[j] < elements[min]) {
                    min = j;
                }
            }

            if (i != min) {
                int temp = elements[i];
                elements[i] = elements[min];
                elements[min] = temp;
            }
        }
        return elements;
    }
}
