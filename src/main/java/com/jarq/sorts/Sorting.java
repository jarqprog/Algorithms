package com.jarq.sorts;

import java.util.List;

public interface Sorting {

    <T extends Comparable<T>> List<T> sort(List<T> elements);
    int[] sort(int[] elements);
}
