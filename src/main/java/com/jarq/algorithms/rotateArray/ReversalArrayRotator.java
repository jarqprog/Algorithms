package com.jarq.algorithms.rotateArray;

public class ReversalArrayRotator implements IntArrayRotator {

    @Override
    public int[] rotate(int[] array, int k) {
        int length = array.length;
        if (length < 2) {
            return array;
        }
        if (k > length) {
            k = k % length;
        }

        int border = length-k-1;
        array = reverseNumbersWithinRange(array, 0, border);
        array = reverseNumbersWithinRange(array, border+1, length-1);
        return reverseNumbersWithinRange(array, 0, length-1);
    }

    private int[] reverseNumbersWithinRange(int[] numbers, int startIndex, int finalIndex) {
        while (startIndex < finalIndex) {
            int aux = numbers[startIndex];
            numbers[startIndex] = numbers[finalIndex];
            numbers[finalIndex] = aux;
            startIndex++;
            finalIndex--;
        }
        return numbers;
    }
}
