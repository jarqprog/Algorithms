package com.jarq.algorithms.binarySearch;

import java.util.List;

public interface BinarySearch<T extends Number> {

    boolean contains(T[] numbers, T number);
    boolean contains(List<T> numbers, T number);
}
