package com.exploringcn.reactive.mono;

import reactor.core.publisher.Mono;

import java.util.Random;

public class MonoExample {

    // 01 - create a publisher of just 1 random integer & subscribe to it to print its value
    public void demoSingleElementMono(){
        Random random = new Random();
        // create the Mono
        Mono<Integer> mono = Mono.just(random.nextInt());

        // subscribe to the mono
        mono.subscribe((e) -> System.out.printf("Received: %s%n", e));
    }

}
