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

}
