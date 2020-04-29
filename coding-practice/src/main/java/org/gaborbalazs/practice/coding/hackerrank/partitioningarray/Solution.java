package org.gaborbalazs.practice.coding.hackerrank.partitioningarray;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Result {

    /*
     * Complete the 'partitionArray' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY numbers
     */

    public static String partitionArray(int k, List<Integer> numbers) {
        String result = "Yes";
        if (numbers.size() % k != 0) {
            result = "No";
        }
        int partitions = numbers.size() / k;
        Map<Integer, Long> counts = numbers.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        int maxRecurrence = Collections.max(counts.values()).intValue();
        if (maxRecurrence > partitions) {
            result = "No";
        }
        return result;
    }

}

public class Solution {

}
