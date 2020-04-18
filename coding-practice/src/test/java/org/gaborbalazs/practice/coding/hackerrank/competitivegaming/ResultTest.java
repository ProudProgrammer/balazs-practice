package org.gaborbalazs.practice.coding.hackerrank.competitivegaming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ResultTest {

    @Test
    public void numPlayers() {
        // GIVEN
        int k = 4;
        List<Integer> scores = new ArrayList<>(Arrays.asList(20, 40, 60, 80, 100));

        // WHEN
        int result = Result.numPlayers(k, scores);

        // THEN
        assertEquals(4 ,result);
    }

    @Test
    public void numPlayers2() {
        // GIVEN
        int k = 4;
        List<Integer> scores = new ArrayList<>(Arrays.asList(2, 2, 3, 4, 5));

        // WHEN
        int result = Result.numPlayers(k, scores);

        // THEN
        assertEquals(5 ,result);
    }

    @Test
    public void numPlayers3() {
        // GIVEN
        int k = 3;
        List<Integer> scores = new ArrayList<>(Arrays.asList(100, 50, 50, 25));

        // WHEN
        int result = Result.numPlayers(k, scores);

        // THEN
        assertEquals(3 ,result);
    }
}