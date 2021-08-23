package com.exploringcn.streams;

import org.junit.jupiter.api.Test;

class StreamsExampleTest {

    StreamsExample streamsExample = new StreamsExample();

    @Test
    void demoStreamOf() {
        streamsExample.demoStreamOf();
    }

    @Test
    void demoStreamIterator() {
        streamsExample.demoStreamIterator();
    }

    @Test
    void demoStreamGenerate() {
        streamsExample.demoStreamGenerate();
    }

    @Test
    void generateAndDisplayRandomNames() {
        streamsExample.generateAndDisplayRandomNames();
    }
}