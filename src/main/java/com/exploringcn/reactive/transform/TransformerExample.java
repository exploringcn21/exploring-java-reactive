package com.exploringcn.reactive.transform;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    public Mono<String> namesMono_map_filter(int stringLength){
        return Mono.just("alex")
                .map(String::toUpperCase)
                .filter(name -> name.length() > stringLength)
                .log();
    }

}
