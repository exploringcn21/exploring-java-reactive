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
}