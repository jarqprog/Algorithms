package com.jarq.algorithms.fizzBuzz;

import java.util.Map;

public interface IFizzBuzz {

    void display(int maxNumToDisplay, Map<Integer,String> numberWord);
    String[] toArray(int maxNumToDisplay, Map<Integer,String> dividersAndWords);
}
