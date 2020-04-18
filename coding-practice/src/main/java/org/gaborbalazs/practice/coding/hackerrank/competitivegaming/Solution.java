package org.gaborbalazs.practice.coding.hackerrank.competitivegaming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Result {

    /*
     * Complete the 'numPlayers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY scores
     */

    public static int numPlayers(int k, List<Integer> scores) {
        List<Integer> copyOfScores = new ArrayList<>(scores);
        copyOfScores.sort(Collections.reverseOrder());
        List<Integer> ranks = new ArrayList<>();
        int maxRank = copyOfScores.get(0);
        int actualRank = 1;
        for (int i = 0; i < copyOfScores.size(); i++) {
            if (copyOfScores.get(i) != maxRank) {
                actualRank = i + 1;
            }
            ranks.add(actualRank);
            maxRank = copyOfScores.get(i);
        }
        return (int) ranks.stream().filter(rank -> rank <= k).count();
    }

}

public class Solution {

}
