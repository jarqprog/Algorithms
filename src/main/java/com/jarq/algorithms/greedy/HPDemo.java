package com.jarq.algorithms.greedy;

public class HPDemo {

    public static void main(String[] args) {

        HighestProduct hp = new HighestProductImpl();

        int[] numbers = {-10, 2, 20, 30, 10, 2, 1};

        System.out.println(hp.calculate(numbers));


        int[] numbers1 = {5, 1, 8, 7, 2, 30, 10, 10, 20, 1, 1, 2, 4, 5, 6, 7, 1, 2, 3, 4, 5,
                6, 7, 8, 9, 0, 30, -40, -20};

        long start, stop;
        start = System.nanoTime();
        System.out.println(hp.calculate(numbers1));
        stop = System.nanoTime() - start;
        System.out.println("Exe time calculate(): " + stop);

        start = System.nanoTime();
        System.out.println(hp.calculateForThree(numbers1));
        stop = System.nanoTime() - start;
        System.out.println("Exe time calculateForThree(): " + stop);

        start = System.nanoTime();
        System.out.println(hp.calculateForThreeWithLoops(numbers1));
        stop = System.nanoTime() - start;
        System.out.println("Exe time calculateForThreeWithLoops(): " + stop);
    }
}
