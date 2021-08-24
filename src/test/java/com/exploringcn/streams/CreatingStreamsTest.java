package com.exploringcn.streams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatingStreamsTest {

    CreatingStreams creatingStreams = new CreatingStreams();

    @Test
    void fromCollectionsDemo() {
        System.out.println("PRINTING EMPLOYEE DETAILS: ");
        creatingStreams.fromCollectionsDemo();

    }

    @Test
    void emptyStreamDemo() {
        System.out.println("PRINTING EMPTY STREAM COUNT: ");
        creatingStreams.emptyStreamDemo();
    }

    @Test
    void fromValues() {
        System.out.println("PRINTING EMPLOYEE DETAILS: ");
        creatingStreams.fromValues();
    }

    @Test
    void fromArrays() {
        System.out.println("PRINTING EMPLOYEE DETAILS: ");
        creatingStreams.fromArrays();
    }

    @Test
    void generateRandomNumbers() {
        creatingStreams.generateRandomNumbers();
    }

    @Test
    void generateWholeNumbers() {
        creatingStreams.generateWholeNumbers();
    }
}