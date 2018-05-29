package com.jarq.algorithms.greedy;

public class HighestProductImpl implements HighestProduct {

    @Override
    public int calculate(int[] numbers) {
        if(numbers.length < 2) {
            throw new IllegalArgumentException();
        }

        int max = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;

        for(int num : numbers) {

            if(num > max) {
                max1 = max;
                max = num;
            }

            else if(num > max1) {
                max1 = num;
            }

            else if(num < min) {
                min1 = min;
                min = num;
            }

            else if(num < min1){
                min1 = num;
            }
        }

        int res1, res2;

        res1 = max * max1;
        res2 = min * min1;

        return res1 > res2 ? res1 : res2;
    }

    @Override
    public Integer calculateForThree(int[] numbers) {
        if(numbers.length < 3) {
            throw new IllegalArgumentException();
        }

        Integer max = null;
        Integer max1 = null;
        Integer max2 = null;
        Integer min = null;
        Integer min1 = null;

        Integer res1 = null;
        Integer res2 = null;

        for(int num : numbers) {

            // assign max & min
            if(max == null || num > max ) {
                max2 = max1;
                max1 = max;
                max = num;
            }

            else if(max1 == null || num > max1) {
                max2 = max1;
                max1 = num;
            }

            else if(max2 == null || num > max2) {
                max2 = num;
            }

            else if(min == null || num < min) {
                min1 = min;
                min = num;
            }

            else if(min1 == null || num < min1) {
                min1 = num;
            }
        }

        // calculate both results
        if(max1 != null && max2 != null) {
            res1 = max * max1 * max2;
        }

        if(min != null && min1 != null) {
            res2 = min * min1 * max;
        }

        if(res1 != null && res2 != null) {
            return res1 > res2 ? res1 : res2;
        }

        else if(res1 != null) {
            return res1;
        }
        return null;
    }

    @Override
    public int calculateForThreeWithLoops(int[] numbers) {
        if(numbers.length < 3) {
            throw new IllegalArgumentException();
        }

        int max = Integer.MIN_VALUE;

        for(int i=0; i<numbers.length; i++) {
            for(int j=0; j<numbers.length; j++) {
                for(int k=0; k<numbers.length; k++) {
                    if(i != j && j != k && i != k) {
                        if(numbers[i] * numbers[j] * numbers[k] > max) {
                            max = numbers[i] * numbers[j] * numbers[k];
                        }
                    }

                }
            }
        }

        return max;
    }


}
