package com.jarq.algorithms.binarySearch;

import java.util.List;

public interface BinarySearch<T extends Number> {

    boolean contains(T[] elements, T element);
    boolean contains(List<T> elements, T element);
    int countRotationsInArray(T[] elements);
}
