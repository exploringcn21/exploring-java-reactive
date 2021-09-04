package com.exploringcn.reactive.transform;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Flux<Integer> flatMapDemoOne(List<Integer> numbers){
        return Flux.fromIterable(numbers)
                .flatMap(TransformerExample::returnSquareAndCube)
                .log();
    }

    private static Flux<Integer> returnSquareAndCube(int number){
        return Flux.just(number * number, number * number * number);
    }

    public Flux<String> flatMapDemoTwo(List<String> names){
        return Flux.fromIterable(names)
                .flatMap(TransformerExample::splitString)
                .log();

    }

    private static Flux<String> splitString(String literal){
        return Flux.fromArray(literal.split(""));
    }

    public Flux<String> flatMapUnOrderedBehaviour(List<String> names){
        return Flux.fromIterable(names)
                .flatMap(TransformerExample::splitStringWithDelay)
                .log();
    }

    private static Flux<String> splitStringWithDelay(String literal){
        return Flux.fromArray(literal.split(""))
                .delayElements(Duration.ofMillis(new Random().nextInt(1000)));  // publish events with a deliberate delay of random seconds (1-10)
    }

    public Flux<String> concatMapOrderedBehaviour(List<String> names){
        return Flux.fromIterable(names)
                .concatMap(TransformerExample::splitStringWithDelay)
                .log();
    }

}
