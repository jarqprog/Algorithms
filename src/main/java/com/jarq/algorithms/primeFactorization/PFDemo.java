package com.jarq.algorithms.primeFactorization;

import java.util.Arrays;

public class PFDemo {

    public static void main(String[] args) {
        IPrimeFactorization primeFactorization = new PrimeFactorization();
        int[] numbers = {3, 10, 15, 22, 31, 55, 103, 200};
        Arrays.stream(numbers).forEach(primeFactorization::display);
    }
}
