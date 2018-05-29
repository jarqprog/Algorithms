package com.jarq.algorithms.greedy;

import java.util.Arrays;

public class SumImpl implements Sum {


    @Override
    public boolean checkSumOfTwo(int[] numbers, int sum) {
//
//        int len = numbers.length;
//
//        if(len < 2) {
//            throw new IllegalArgumentException();
//        }
//
//        if(len == 2) {
//            return numbers[0] + numbers[1] == sum;
//        }
//
//        Arrays.sort(numbers);
//
//        int right = len-1;
//
//        for(int left = 0; left<right; left++) {
//
//            if(numbers[left] + numbers[right] == sum) {
//                return true;
//            }
//
//            if(numbers[left] + numbers[right] > sum) {
//                right--;
//            }
//        }
//        return false;
    }

    @Override
    public boolean checkSumOfThree(int[] numbers, int sum) {
        int len = numbers.length;

        if(len < 3) {
            throw new IllegalArgumentException();
        }

        if(len == 3) {
            return numbers[0] + numbers[1] + numbers[2] == sum;
        }

        Arrays.sort(numbers);

        int right = len-1;

        for(int left = 0; left<right; left++) {

            if(numbers[left] + numbers[right] == sum) {
                return true;
            }

            if(numbers[left] + numbers[right] > sum) {
                right--;
            }
        }
        return false;
    }
}
