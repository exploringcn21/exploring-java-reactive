package com.exploringcn.reactive.transform;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
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
}