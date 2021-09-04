package com.exploringcn.streams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransformStreamsExampleTest {

    TransformStreamsExample example = new TransformStreamsExample();

    @Test
    void flatMapDemoTwo() {

        // given
        List<Integer> input = List.of(1,2,3,4,5);

        // when
        List<Integer> actual = example.flatMapDemoOne(input);

        // then
        List<Integer> expected = List.of(1,1,4,8,9,27,16,64,25,125);
        assertEquals(expected, actual);
    }
}