package com.jarq.algorithms.nearbyElements;

public interface NearbyElements<T> {

    T[] nearby(int rowIndex, int columnIndex, int range);

}
