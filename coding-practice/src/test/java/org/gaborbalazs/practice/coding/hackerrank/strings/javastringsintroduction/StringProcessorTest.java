package org.gaborbalazs.practice.coding.hackerrank.strings.javastringsintroduction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {

    private StringProcessor underTest;

    @BeforeEach
    void setUp() {
        underTest = new StringProcessor();
    }

    @Test
    void shouldReturnWhenTheFirstInputIsNotLarger() {
        List<String> inputs = List.of("hello", "java");
        List<String> expectedResult = List.of("9", "No", "Hello Java");

        List<String> result = underTest.getLines(inputs);

        assertEquals(expectedResult, result);
    }

    @Test
    void shouldReturnWhenTheFirstInputIsLarger() {
        List<String> inputs = List.of("java", "hello");
        List<String> expectedResult = List.of("9", "Yes", "Java Hello");

        List<String> result = underTest.getLines(inputs);

        assertEquals(expectedResult, result);
    }
}
