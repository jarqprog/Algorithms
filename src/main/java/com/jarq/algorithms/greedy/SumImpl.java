package com.jarq.algorithms.greedy;

import java.util.Arrays;

public class SumImpl implements Sum {


    @Override
    public boolean checkSumOfTwo(int[] numbers, int sum) {

        int len = numbers.length;

        if(len < 2) {
            throw new IllegalArgumentException();
        }

        if(len == 2) {
            return numbers[0] + numbers[1] == sum;
        }

        Arrays.sort(numbers);

        int right = len-1;
        int left = 0;

        while(left < right) {

            if(numbers[left] + numbers[right] == sum) {
                return true;
            }

            if(numbers[left] + numbers[right] > sum) {
                right--;
            } else {
                left++;
            }
        }
        return false;
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

        for(int left=0; left<len-2; left++) {

            int middle = left+1;
            int right = len-1;

            while(middle<right) {
                if (numbers[left] + numbers[middle] + numbers[right] == sum) {
                    return true;
                }

                if (numbers[left] + numbers[middle] + numbers[right] > sum) {
                    right--;
                } else {
                    middle++;
                }
            }
        }
        return false;
    }

    @Override
    public boolean checkSumOfTwoInArray(int[] numbers) {
        int len = numbers.length;

        if(len < 3) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(numbers);

        for(int middle=0; middle<len; middle++) {

            int left = 0;
            int right = len-1;

            while(left<right) {
                if (left != middle && middle != right && (
                        numbers[left] + numbers[middle] == numbers[right] ||
                        numbers[left] == numbers[middle] + numbers[right] ||
                        numbers[middle] == numbers[left] + numbers[right])

                    ) {
                    return true;
                }

                if (numbers[left] + numbers[middle] > numbers[right]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return false;
    }
}
