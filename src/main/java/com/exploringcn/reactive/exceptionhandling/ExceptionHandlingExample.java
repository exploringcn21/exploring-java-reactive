package com.exploringcn.reactive.exceptionhandling;

import reactor.core.publisher.Flux;

public class ExceptionHandlingExample {

    public Flux<Integer> exceptionFluxDemo(){
        return Flux.just(1,4,2,0,5,3)
                .map(integer -> 60/integer)
                .log();
    }

    // useful in cases where a fallback value is needed while processing a flux of elements
    public Flux<Integer> demoOnErrorReturn(){
        return Flux.just(1,4,2,0,5,3)
                .map(integer -> 60/integer)
                .onErrorReturn(60)  // catch exception & provide a single fallback value
                .log();
    }


    public Flux<Integer> demoOnErrorResumeConditionalRecovery(){
        Flux<Integer> recoveryFluxOption1 = Flux.just(100,101,102);
        Flux<Integer> recoveryFluxOption2 = Flux.just(200,201,202);

        return Flux.just(1,4,2,0,5,3)
                .map(integer -> 60/integer)
                .onErrorResume(e -> {
                    if (e instanceof ArithmeticException)
                        return recoveryFluxOption1;
                    else
                        return recoveryFluxOption2;
                })
                .log();
    }


    public Flux<Integer> demoOnErrorContinue(){
        return Flux.just(1,4,2,0,5,3)
                .map(integer -> 60/integer)
                .onErrorContinue((ex, item) -> System.out.println("Element " + item + " caused the exception: " + ex.getMessage()))
                .log();
    }

}
