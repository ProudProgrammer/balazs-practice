package org.gaborbalazs.practice.coding.hackerrank.partitioningarray;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ResultTest {

    @Test
    public void partitionArray() {
        // GIVEN
        int k = 2;
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4));

        // WHEN
        String result = Result.partitionArray(k, numbers);

        // THEN
        assertEquals("Yes", result);
    }

    @Test
    public void partitionArray2() {
        // GIVEN
        int k = 3;
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 2, 3));

        // WHEN
        String result = Result.partitionArray(k, numbers);

        // THEN
        assertEquals("No", result);
    }

    @Test
    public void partitionArray3() {
        // GIVEN
        int k = 2;
        List<Integer> numbers = new ArrayList<>(List.of(3, 5, 3, 2));

        // WHEN
        String result = Result.partitionArray(k, numbers);

        // THEN
        assertEquals("Yes", result);
    }

    @Test
    public void partitionArray4() {
        // GIVEN
        int k = 3;
        List<Integer> numbers = new ArrayList<>(List.of(4, 8, 8, 8, 6, 4));

        // WHEN
        String result = Result.partitionArray(k, numbers);

        // THEN
        assertEquals("No", result);
    }
}