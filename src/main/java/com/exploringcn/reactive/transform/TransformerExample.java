package com.exploringcn.reactive.transform;

import reactor.core.publisher.Flux;

public class TransformerExample {

    public Flux<String> mapToUpperCase(Iterable<String> names){
        return Flux.fromIterable(names)
                .map(String::toUpperCase)
                .log();
    }

}
