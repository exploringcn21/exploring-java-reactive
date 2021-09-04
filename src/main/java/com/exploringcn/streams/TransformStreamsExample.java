package com.exploringcn.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransformStreamsExample {

    public List<Integer> flatMapDemoOne(List<Integer> numbers){
        return numbers.stream()
                .flatMap(TransformStreamsExample::returnSquareCubePair)
                .collect(Collectors.toList());
    }

    private static Stream<Integer> returnSquareCubePair(int number){
        return Stream.of(number * number, number * number * number);
    }

}
