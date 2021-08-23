package com.exploringcn.streams;

import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamsExample {


    // 5 - perform sum of N numbers
    public int findSum(List<Integer> listOfIntegers){
        return listOfIntegers
                .stream()
                .reduce(0, Integer::sum);
    }

    // 6 - perform sum of N numbers using numeric streams for numbers a to b, both inclusive
    public int findSumUsingNumericStreams(int a, int b){
        return IntStream
                .rangeClosed(a, b)
                .sum();
    }

    // 7 - convert an integer stream to a double stream and print it
    public void convertIntToDoubleStream(){
        IntStream
                .rangeClosed(1, 10)
                .asDoubleStream()
                .forEach(System.out::println);
    }

}
