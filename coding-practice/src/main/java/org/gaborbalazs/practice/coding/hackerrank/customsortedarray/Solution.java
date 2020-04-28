package org.gaborbalazs.practice.coding.hackerrank.customsortedarray;

import java.util.List;


class Result {

    /*
     * Complete the 'moves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int moves(List<Integer> arr) {
        int numberOfSwap = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 2 != 0) {
                for (int j = arr.size() - 1; j > i; j--) {
                    if (arr.get(j) % 2 == 0) {
                        int firstOdd = arr.get(i);
                        arr.set(i, arr.get(j));
                        arr.set(j, firstOdd);
                        numberOfSwap++;
                        break;
                    }
                }
            }
        }
        return numberOfSwap;
    }

}

public class Solution {

}
