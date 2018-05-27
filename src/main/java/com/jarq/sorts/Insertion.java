package com.jarq.sorts;


import java.util.List;

public class Insertion implements Sorting {


    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> elements) {
        int len = elements.size();
        T temp, current, previous;

        for(int i=1; i<len; i++) {
            current = elements.get(i);
            previous = elements.get(i-1);
            if(current.compareTo(previous) < 0) {
                for(int j=i; j>0; j--) {
                    current = elements.get(j);
                    previous = elements.get(j-1);
                    if(current.compareTo(previous) < 0) {
                        temp = previous;
                        elements.set(j-1, current);
                        elements.set(j, temp);
                    }
                }
            }
        }
        return elements;
    }

    @Override
    public int[] sort(int[] elements) {
        int len = elements.length;
        int temp;

        for(int i=1; i<len; i++) {
            if(elements[i] < elements[i-1]) {
                for(int j=i; j>0; j--) {
                    if(elements[j] < elements[j-1]) {
                        temp = elements[j-1];
                        elements[j-1] = elements[j];
                        elements[j] = temp;
                    }
                }
            }
        }
        return elements;
    }
}