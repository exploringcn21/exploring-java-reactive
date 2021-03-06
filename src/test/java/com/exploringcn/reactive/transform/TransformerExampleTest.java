package com.exploringcn.reactive.transform;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

class TransformerExampleTest {

    TransformerExample example = new TransformerExample();

    @Test
    void mapToUpperCase() {

        // given
        List<String> names = List.of("alex", "ben", "cindy");

        // when
        Flux<String> namesFlux = example.mapToUpperCase(names);

        // then
        StepVerifier.create(namesFlux)
                .expectSubscription()
                .expectNext("ALEX", "BEN", "CINDY")
                .verifyComplete();

    }

    @Test
    void filterNamesOfLengthGreaterThanThree() {

        // given
        List<String> names = List.of("alex", "ben", "cindy");

        // when
        Flux<String> namesFlux = example.filterNamesOfLengthGreaterThanThree(names);

        // then
        StepVerifier.create(namesFlux)
                .expectSubscription()
                .expectNext("alex", "cindy")
                .verifyComplete();

    }

    @Test
    void namesMono_map_filter() {
        // given
        int stringLength = 3;

        // when
        Mono<String> nameMono = example.namesMono_map_filter(stringLength);

        // then
        StepVerifier.create(nameMono)
                .expectNextCount(1)     // since length of "alex" is > 3, it will return at least one item
                .verifyComplete();
    }

    @Test
    void flatMapDemoOne() {

        // given
        List<Integer> input = List.of(1,2,3,4,5);

        // when
        Flux<Integer> actual = example.flatMapDemoOne(input);

        // then
        StepVerifier.create(actual)
                .expectSubscription()
                .expectNextCount(10)
                .verifyComplete();
    }

    @Test
    void flatMapDemoTwo() {

        // given
        List<String> names = List.of("Ben", "David");

        // when
        Flux<String> actual = example.flatMapDemoTwo(names);

        // then
        StepVerifier.create(actual)
                .expectSubscription()
                .expectNext("B", "e", "n", "D", "a", "v", "i", "d")
                .verifyComplete();

    }

    @Test
    void flatMapUnOrderedBehaviour() {
        // given
        List<String> names = List.of("Ben", "David");

        // when
        Flux<String> actual = example.flatMapUnOrderedBehaviour(names);

        // then
        StepVerifier.create(actual)
                .expectSubscription()
//                .expectNext("B", "e", "n", "D", "a", "v", "i", "d") // this order may not be present, since events will be published out of ordered due to delay
                .expectNextCount(8) // this is deterministic and will always be true
                .verifyComplete();

        /*
        Sample order on a random run:-

        onNext(B)
        onNext(D)
        onNext(e)
        onNext(a)
        onNext(n)
        onNext(v)
        onNext(i)
        onNext(d)
        onComplete()
        */
    }

    @Test
    void concatMapOrderedBehaviour() {
        // given
        List<String> names = List.of("Ben", "David");

        // when
        Flux<String> actual = example.concatMapOrderedBehaviour(names);

        // then
        StepVerifier.create(actual)
                .expectSubscription()
                .expectNext("B", "e", "n", "D", "a", "v", "i", "d") // this order may not be present, since events will be published out of ordered due to delay
                .verifyComplete();
    }

    @Test
    void demoTransformOperation() {

        // given
        List<String> names = List.of("Ben", "David");
        int stringLength = 3;

        // when
        Flux<String> actual = example.demoTransformOperation(names, stringLength);

        // then
        StepVerifier.create(actual)
                .expectSubscription()
                .expectNext("D", "A", "V", "I", "D")
                .verifyComplete();

    }
}