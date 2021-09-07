package com.exploringcn.reactive.merging;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class MergingExampleTest {

    MergingExample example = new MergingExample();

    @Test
    void demoConcat() {
        Flux<String> resultFlux = example.demoConcat();

        StepVerifier.create(resultFlux)
                .expectNext("A", "B", "C", "D", "E", "F")   // result will be in this ordered sequence irrespective of delay
                .verifyComplete();
    }

    @Test
    void demoConcatWithFlux() {
        Flux<String> resultFlux = example.demoConcatWithFlux();

        StepVerifier.create(resultFlux)
                .expectNext("A", "B", "C", "D", "E", "F", "G")   // result will be in this ordered sequence irrespective of delay
                .verifyComplete();
    }

    @Test
    void demoConcatWithFluxAndMono() {
        Flux<String> resultFlux = example.demoConcatWithFluxAndMono();

        StepVerifier.create(resultFlux)
                .expectNext("A", "D", "E", "F")   // result will be in this ordered sequence irrespective of delay
                .verifyComplete();
    }
}