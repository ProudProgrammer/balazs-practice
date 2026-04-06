package org.gaborbalazs.practice.coding.hackerrank.javastdinandstdouti;

import java.util.Arrays;
import java.util.Scanner;

class Solution {

    static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int counter = 0;
        int[] inputs = new int[3];
        try (Scanner scanner = new Scanner(System.in)) {
            while (counter < 3 && scanner.hasNext()) {
                inputs[counter++] = scanner.nextInt();
            }
        }
        Arrays.stream(inputs).forEach(System.out::println);
    }
}
