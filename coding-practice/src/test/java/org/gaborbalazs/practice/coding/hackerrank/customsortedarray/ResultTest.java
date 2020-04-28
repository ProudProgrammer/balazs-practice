package org.gaborbalazs.practice.coding.hackerrank.customsortedarray;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ResultTest {

    @Test
    public void moves() {
        // GIVEN
        List<Integer> arr = new ArrayList<>(Arrays.asList(6, 3, 4, 5));

        // WHEN
        int result = Result.moves(arr);

        // THEN
        assertEquals(1, result);
    }

    @Test
    public void moves2() {
        // GIVEN
        List<Integer> arr = new ArrayList<>(Arrays.asList(13, 10, 21, 20));

        // WHEN
        int result = Result.moves(arr);

        // THEN
        assertEquals(1, result);
    }

    @Test
    public void moves3() {
        // GIVEN
        List<Integer> arr = new ArrayList<>(Arrays.asList(8, 5, 11, 4, 6));

        // WHEN
        int result = Result.moves(arr);

        // THEN
        assertEquals(2, result);
    }
}