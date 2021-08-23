package com.exploringcn.streams;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
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

    // 8 - generate & print integers from 1 to 50 (exclusive),  separated by commas
    public void generateAndDisplay(int start, int end) {
        IntStream
                .range(start, end)
                .forEach((e) -> System.out.print(e + ", "));
    }

    // 9 - generate a stream of integers from 1 to 20 (inclusive), and print the sum, min, max and average
    public void findNumericAggregates(int start, int end){
        int sum = IntStream
                .rangeClosed(start, end)
                .sum();

        OptionalInt optionalMinimum = IntStream
                .rangeClosed(start, end)
                .min();

        OptionalInt optionalMaximum = IntStream
                .rangeClosed(start, end)
                .max();

        OptionalDouble optionalAverage = IntStream
                .rangeClosed(start, end)
                .average();

        System.out.println("Displaying numeric aggregates for numbers from " + start + " to " + end);
        System.out.printf("Sum: %s%n", sum);
        System.out.printf("Minimum: %s%n", (optionalMinimum.isPresent() ? optionalMinimum.getAsInt() : 0));
        System.out.printf("Maximum: %s%n", (optionalMaximum.isPresent() ? optionalMaximum.getAsInt() : 0));
        System.out.printf("Average: %s%n", optionalAverage.isPresent() ? optionalAverage.getAsDouble() : 0.0);
    }

}
