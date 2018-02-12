import algorithms.Algorithm;
import algorithms.Fibonacci;

import java.util.Scanner;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Algorithm alg = new Fibonacci();
        boolean shouldContinue = true;
        Scanner sc = new Scanner(System.in);
        while (shouldContinue) {
            try {
                System.out.println("Please type an integer number or 0 to exit ---> ");
                int userInput = sc.nextInt();
                if (userInput == 0) {
                    shouldContinue = false; // exit program
                }
                BigInteger result = alg.executeAlgorithm(userInput);
                System.out.println(alg + " result for (" + userInput + "): " + result);

            } catch (Exception ex) {
                System.out.println("Wrong input");
            }
        }
        try {
            sc.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
