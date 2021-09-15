package com.exploringcn.reactive.exceptionhandling;

import reactor.core.publisher.Flux;

public class ExceptionHandlingExample {

    public Flux<Integer> exceptionFluxDemo(){
        return Flux.just(1,4,2,0,5,3)
                .map(integer -> 60/integer)
                .log();
    }

}
