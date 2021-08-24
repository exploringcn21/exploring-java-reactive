package com.exploringcn.streams;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

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


    // 11 - creating an empty stream


    // 12 - creating streams from values


    // 13 - creating streams from array


    // 14 - creating a stream from file

}
