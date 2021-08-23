package com.exploringcn.streams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumericStreamsExampleTest {

    NumericStreamsExample numericStreamsExample = new NumericStreamsExample();

    @Test
    void findSum() {
        // given
        List<Integer> testList = List.of(1, 2, 3, 4, 5);

        // when
        int actual = numericStreamsExample.findSum(testList);

        // then
        int expected = 15;
        assertEquals(expected, actual);
    }
}