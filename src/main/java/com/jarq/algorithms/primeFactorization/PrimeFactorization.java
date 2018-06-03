package com.jarq.algorithms.primeFactorization;

import java.util.Set;
import java.util.TreeSet;

public class PrimeFactorization implements IPrimeFactorization {


    @Override
    public void display(int num) {
        System.out.println(String.format("Prime factorization for %s: ", num));
        for(int factor : getFactors(num)) {
            System.out.print(factor + " ");
        }
        System.out.println();
    }

    @Override
    public Set<Integer> getFactors(int num) { // by trial division
        if(num < 2) {
            throw new IllegalArgumentException("Argument should be positive integer number greater than 1");
        }

        Set<Integer> results = new TreeSet<>();

        int factor = 2;

        while(num > 1) {
            if(num % factor == 0) {
                results.add(factor);
                num /= factor;
            } else {
                factor++;
            }
        }

        return results;
    }
}
