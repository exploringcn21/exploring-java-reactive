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

    // 02 - subscribe to a publisher & specify what to do with onNext, onError and onComplete
    public void demoPublisherEventsBehaviour(){
        Random random = new Random();

        // create the publisher
        Mono<Integer> mono = Mono.just(random.nextInt());

        // onNext: print if it's even or odd
        // onError: print error message
        // onComplete: print completion message
        mono.subscribe(
                (e) -> {  // onNext behavior
                    if(e % 2 == 0)
                        System.out.printf("%s is even.%n", e);
                    else
                        System.out.printf("%s is odd.%n", e);
                },
                (err) -> System.err.println(err.getMessage()),  // onError behavior
                () -> System.out.println("Publisher completed sending all elements.")  // onComplete behavior
        );
    }

    // 03 - subscribe to a publisher & simulate onError behavior
    public void simulateOnErrorBehaviour(){
        // create publisher. Treat the mono as a pipeline with multiple stages
        Mono<Integer> mono = Mono.just("Tonmoy") // pipeline stage 1
                .map(String::length) // pipeline stage 2
                .map((e) -> e/0);  // pipeline stage 3 - fail deliberately


        // onNext: print if it's even or odd
        // onError: print error message - THIS SHOULD TRIGGER THIS TIME
        // onComplete: print completion message
        mono.subscribe(
                (e) -> System.out.printf("Received %s%n", e),
                (error) -> System.err.println(error.getMessage()),
                () -> System.out.println("Completed emitting events")
        );
    }

}
