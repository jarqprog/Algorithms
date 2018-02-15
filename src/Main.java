import algorithms.Algorithm;
import algorithms.Factorial;
import algorithms.Fibonacci;
import sorts.Bubble;
import sorts.Insertion;
import sorts.Sorting;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        executeAlgorithms();
        executeSorting();
    }


    private static void executeSorting() {

        int elementsInList = getNumberFromUser();
        // bubble sort:
        List<Integer> list = createFilledIntegerList(elementsInList);
        list = shuffleList(list);
        displayListElements(list);
        Sorting bubble = new Bubble();
        list = bubble.executeSort(list);
        displayListElements(list);

        // insertion:
        list = createFilledIntegerList(elementsInList);
        list = shuffleList(list);
        displayListElements(list);
        Sorting insertion = new Insertion();
        list = insertion.executeSort(list);
        displayListElements(list);

    }

    private static void executeAlgorithms() {
        int userInput = getNumberFromUser();
        Algorithm fibo = new Fibonacci();
        Algorithm facto = new Factorial();
        BigInteger resultFibo = fibo.executeAlgorithm(userInput);
        System.out.println(fibo + " result for (" + userInput + "): " + resultFibo);
        BigInteger resultFacto = facto.executeAlgorithm(userInput);
        System.out.println(facto + " result for (" + userInput + "): " + resultFacto);
    }

    private static List<Integer> createFilledIntegerList(int length) {
        List<Integer> list = new LinkedList<>();

        for(int i=0; i<length; i++) {
            list.add(i);
        }
        return list;
    }

    private static <T extends Comparable> List<T> shuffleList(List<T> list) {
        Collections.shuffle(list);
        return list;
    }

    private static <T extends Comparable> void displayListElements(List<T> list) {
        System.out.println("Output:");
        list.forEach(element -> System.out.print(element.toString() + ", "));
    }

    private static int getNumberFromUser() {
        int userInput = 0;
        Scanner sc = new Scanner(System.in);
        boolean isReady = false;
        while (! isReady) {
            System.out.println("Please type an integer positive number ---> ");
            try {
                userInput = sc.nextInt();
                if(userInput > 0) {
                    isReady = true;
                }
            } catch (Exception ex) {
                System.out.println("Wrong input");
            }
        }
        return userInput;
    }
}