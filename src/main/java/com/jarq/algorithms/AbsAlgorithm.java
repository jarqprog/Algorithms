package com.jarq.algorithms;

import java.math.BigInteger;

public abstract class AbsAlgorithm implements Algorithm {

    protected String name;

    public abstract BigInteger executeAlgorithm(int num);

    public String toString() {
        return "algorithm: " + name;
    }

}
