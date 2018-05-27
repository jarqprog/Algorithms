package com.jarq.algorithms;

public class Factorial implements IFactorial {

    public long perform(int num) {

        if(num < 1) {
            return 1;
        }

        int result = 1;

        for(int i=1; i<=num; i++) {
            result *= i;
        }
        return result;

    }

    public long performRec(int num) {

        Long[] memo = new Long[num+1];

        return performWithMemo(num, memo);
    }

    private long performWithMemo(int num, Long[] memo) {

        if(memo[num] != null) {
            return memo[num];
        }

        if(num < 2) {
            return 1;
        }

        memo[num] = num * performWithMemo(num-1, memo);
        return memo[num];
    }
}
