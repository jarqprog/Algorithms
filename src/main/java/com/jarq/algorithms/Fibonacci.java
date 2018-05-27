package com.jarq.algorithms;

public class Fibonacci implements IFibonacci {


    @Override
    public long perform(int num) {

        if(num <= 0) {
            return 0;
        }

        if(num == 1) {
            return 1;
        }

        long tmp, current, prev;
        current = 1;
        prev = 0;

        for(int i=1; i<num; i++) {
            tmp = current;
            current = current + prev;
            prev = tmp;
        }

        return current;
    }

    @Override
    public long performRec(int n) {
        Long[] memo = new Long[n+1];
        return handleRec(n, memo);
    }

    private long handleRec(int num, Long[] memo) {
        if(memo[num] != null) {
            return memo[num];
        }

        if(num <= 0) {
            return 0;
        }
        if(num == 1) {
            return 1;
        }

        long result = handleRec(num-2, memo) + handleRec(num-1, memo);
        memo[num] = result;
        return result;
    }
}
