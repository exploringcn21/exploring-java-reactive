package com.exploringcn.streams;

import java.util.stream.Stream;

public class StreamsExample {

    // 1 - Generate stream using known elements
    public void demoStreamOf(){
        Stream<String> stream = Stream.of("Adam", "Ben", "Claire", "Dan");
        stream.forEach(System.out::println);
    }


    public static void main(String[] args) {

    }

}
