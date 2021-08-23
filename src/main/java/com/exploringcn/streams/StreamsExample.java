package com.exploringcn.streams;

import java.util.stream.Stream;

public class StreamsExample {

    // 1 - Generate stream using known elements
    public void demoStreamOf(){
        Stream<String> stream = Stream.of("Adam", "Ben", "Claire", "Dan");
        stream.forEach(System.out::println);
    }

    // 2 - Generate stream using iterator
    public void demoStreamIterator(){
        Stream.iterate(1, i -> i * 2) // create stream of integers starting with 1 and incrementing infinitely by 2 times
                .limit(20) // prevent infinite stream. Limit size to 20 elements
                .forEach(System.out::println); // terminate stream by looping each element and printing their values
    }


    public static void main(String[] args) {

    }

}
