package com.exploringcn.reactive.exceptionhandling;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandlingExampleTest {

    ExceptionHandlingExample example = new ExceptionHandlingExample();

    @Test
    void exceptionFluxDemo() {
        Flux<Integer> numbersFlux = example.exceptionFluxDemo();

        StepVerifier.create(numbersFlux)
                .expectSubscription()
                .expectNext(60,15,30)
                .expectError(ArithmeticException.class)
                .verify();
    }
}