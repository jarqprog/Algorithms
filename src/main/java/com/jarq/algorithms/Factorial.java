package com.jarq.algorithms;

import java.math.BigInteger;

import static java.lang.Math.abs;

public class Factorial extends AbsAlgorithm {

    public Factorial() {
        name = "Factorial";
    }

    public BigInteger executeAlgorithm(int num) {
        num = abs(num);
        if(num == 0) {
            return BigInteger.valueOf(0);
        } else {
            BigInteger result = BigInteger.valueOf(1);

            for (int i=1; i <= num; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;
        }
    }
}
