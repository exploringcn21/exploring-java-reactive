package com.exploringcn.streams;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Data
@Builder
@ToString
class Employee{
    private String name;
    private String location;
}

public class CreatingStreams {

    private Faker faker = new Faker();

    // 10 - creating streams from collections
    public void fromCollectionsDemo(){
        // define list of employees
        List<Employee> employees = List.of(
                Employee.builder().name(faker.name().name()).location(faker.country().name()).build(),
                Employee.builder().name(faker.name().name()).location(faker.country().name()).build(),
                Employee.builder().name(faker.name().name()).location(faker.country().name()).build(),
                Employee.builder().name(faker.name().name()).location(faker.country().name()).build()
        );

        // create stream and print each employee details
        employees
                .stream()
                .forEach(System.out::println);
    }


    // 11 - creating an empty stream and printing its count
    public void emptyStreamDemo(){
        Stream<Employee> employees = Stream.empty();
        System.out.println(employees.count());
    }


    // 12 - creating streams from values
    public void fromValues(){
        Stream<Employee> employees = Stream.of(
                Employee.builder().name(faker.name().name()).location(faker.country().name()).build(),  // employee 1
                Employee.builder().name(faker.name().name()).location(faker.country().name()).build(),  // employee 2
                Employee.builder().name(faker.name().name()).location(faker.country().name()).build()  // employee 3
        );

        employees.forEach(System.out::println);
    }


    // 13 - creating streams from array
    public void fromArrays(){
        // define the employees array
        Employee[] employees = {
                Employee.builder().name(faker.name().name()).location(faker.country().name()).build(),  // employee 1
                Employee.builder().name(faker.name().name()).location(faker.country().name()).build(),  // employee 2
                Employee.builder().name(faker.name().name()).location(faker.country().name()).build()  // employee 3
        };

        // create stream of that array
        Stream<Employee> employeeStream = Stream.of(employees);

        // print details of each Employee from the stream
        employeeStream.forEach(System.out::println);

    }


    // 14 - creating a stream from reading a file
    public void readFileAsStream(){
        try {
            String home = System.getenv().get("HOME");
            Stream<String> fileLines = Files.lines(Paths.get(home.concat("/file1.txt")));
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 15 - generate a supply of random numbers that is indefinite
    public void generateRandomNumbers(){
        Stream<Double> randomNumbers = Stream.generate(Math::random);  // takes in a Supplier
        randomNumbers.forEach(System.out::println);
    }

    // 16 - generate a stream that starts from a User driven value that is indefinite
    public void generateWholeNumbers(){
        Stream<Integer> wholeNumbers = Stream.iterate(0, i -> i + 1);
        wholeNumbers.forEach(System.out::println);
    }

}
