package com.jarq.algorithms.rotateArray;

public class SimpleArrayRotator implements IntArrayRotator {

    @Override
    public int[] rotate(int[] array, int k) {

        int length = array.length;
        if (length < 2) {
            return array;
        }
        if (k > length) {
            k = k % length;
        }

        int[] result = new int[length];

        for (int i=0; i<k; i++) {
            result[i] = array[length-k+i];
        }

        int arrayIndex = 0;
        for (int j=k; j<length; j++) {
            result[j] = array[arrayIndex];
            arrayIndex++;
        }
        return result;
    }
}
