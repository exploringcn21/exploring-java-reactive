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

    @Test
    void demoOnErrorReturn() {
        Flux<Integer> numbersFlux = example.demoOnErrorReturn();

        StepVerifier.create(numbersFlux)
                .expectSubscription()
                .expectNext(60,15,30)
                .expectNext(60)
                .verifyComplete();
    }

    @Test
    void demoOnErrorResumeConditionalRecovery() {
        Flux<Integer> numbersFlux = example.demoOnErrorResumeConditionalRecovery();

        StepVerifier.create(numbersFlux)
                .expectSubscription()
                .expectNext(60,15,30)
                .expectNext(100,101,102)
                .verifyComplete();
    }

    @Test
    void demoOnErrorContinue() {
        Flux<Integer> numbersFlux = example.demoOnErrorContinue();

        StepVerifier.create(numbersFlux)
                .expectSubscription()
                .expectNext(60,15,30)
                .expectNext(12,20)
                .verifyComplete();
    }
}