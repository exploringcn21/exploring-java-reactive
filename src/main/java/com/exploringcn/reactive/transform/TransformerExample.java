package com.exploringcn.reactive.transform;

import reactor.core.publisher.Flux;

public class TransformerExample {

    public Flux<String> mapToUpperCase(Iterable<String> names){
        return Flux.fromIterable(names)
                .map(String::toUpperCase)
                .log();
    }

    public Flux<String> filterNamesOfLengthGreaterThanThree (Iterable<String> names){
        return Flux.fromIterable(names)
                .filter(name -> name.length() > 3)
                .log();
    }

}
