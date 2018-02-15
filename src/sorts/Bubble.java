package sorts;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Bubble implements Sorting {

    public List<Integer> executeSort(List<Integer> elements) {

        long startTime = System.currentTimeMillis();
        elements = new LinkedList<>(elements);
        Integer[] numbers = elements.toArray(new Integer[0]);
        int length = elements.size();
        for (int i=0; i < length - 1; i++) {
            for(int j=0; j < length - 1; j++) {
                Integer current = numbers[j];
                Integer next = numbers[j+1];
                Integer tmp;
                if (current > next) {
                    tmp = numbers[j+1];
                    numbers[j+1] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("\nElapsed time  using Bubble Sort: " + estimatedTime);
        return new LinkedList<>(Arrays.asList(numbers));
    }
}