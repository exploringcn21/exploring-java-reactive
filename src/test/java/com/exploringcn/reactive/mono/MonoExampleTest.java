package com.exploringcn.reactive.mono;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonoExampleTest {

    MonoExample monoExample = new MonoExample();

    @Test
    void demoSingleElementMono() {
        monoExample.demoSingleElementMono();
    }

    @Test
    void demoPublisherEventsBehaviour() {
        monoExample.demoPublisherEventsBehaviour();
    }
}