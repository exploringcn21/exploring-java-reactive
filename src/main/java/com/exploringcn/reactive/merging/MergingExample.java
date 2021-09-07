package com.exploringcn.reactive.merging;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    public Flux<String> demoConcatWithFluxAndMono(){
        Random rand = new Random();

        var publisher1 = Mono.just("A");
        var publisher2 = Flux.just("D", "E", "F").delayElements(Duration.ofMillis(rand.nextInt(1000)));

        return publisher1.concatWith(publisher2)  // will subscribe to publisher1 first and only after all it's events are consumed, will publisher2 be subscribed to
                .log();
    }

    public Flux<String> demoMerge(){

        var publisher1 = Flux.just("A", "B", "C").delayElements(Duration.ofMillis(100));
        var publisher2 = Flux.just("D", "E", "F").delayElements(Duration.ofMillis(125));

        return Flux.merge(publisher1, publisher2)  // subscribes to both publisher1 and publisher2 eagerly; as such no guarantee of order for created flux
                .log();
    }

    public Flux<String> demoMergeWith(){

        var publisher1 = Flux.just("A", "B", "C").delayElements(Duration.ofMillis(100));
        var publisher2 = Flux.just("D", "E", "F").delayElements(Duration.ofMillis(125));

        return publisher1.mergeWith(publisher2)  // subscribes to both publisher1 and publisher2 eagerly; as such no guarantee of order for created flux
                .log();
    }

    public Flux<String> demoMergeWithMono(){

        var publisher1 = Mono.just("A");
        var publisher2 = Mono.just("D");

        return publisher1.mergeWith(publisher2)  // subscribes to both publisher1 and publisher2 eagerly; as such no guarantee of order for created flux
                .log();
    }

}
