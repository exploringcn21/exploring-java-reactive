package com.exploringcn.reactive.merging;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

public class MergingExample {

    public Flux<String> demoConcat(){
        Random rand = new Random();

        var publisher1 = Flux.just("A", "B", "C").delayElements(Duration.ofMillis(rand.nextInt(1000)));
        var publisher2 = Flux.just("D", "E", "F").delayElements(Duration.ofMillis(rand.nextInt(1000)));

        return Flux.concat(publisher1, publisher2)  // will subscribe to publisher1 first and only after all it's events are consumed, will publisher2 be subscribed to
                .log();
    }

    public Flux<String> demoConcatWithFlux(){
        Random rand = new Random();

        var publisher1 = Flux.just("A", "B", "C").delayElements(Duration.ofMillis(rand.nextInt(1000)));
        var publisher2 = Flux.just("D", "E", "F", "G").delayElements(Duration.ofMillis(rand.nextInt(1000)));

        return publisher1.concatWith(publisher2)  // will subscribe to publisher1 first and only after all it's events are consumed, will publisher2 be subscribed to
                .log();
    }

}
