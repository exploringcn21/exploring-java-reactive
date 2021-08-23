package com.exploringcn.streams;

import java.util.List;

public class NumericStreamsExample {


    // 5 - perform sum of N numbers
    public int findSum(List<Integer> listOfIntegers){
        return listOfIntegers
                .stream()
                .reduce(0, Integer::sum);
    }

}
