package org.gaborbalazs.practice.coding.hackerrank.introduction.javaoutputformatting;

import java.util.Scanner;

class Solution {

    static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int counter = 0;
        String[] inputs = new String[3];
        try (Scanner scanner = new Scanner(System.in)) {
            while (counter < 3 && scanner.hasNext()) {
                inputs[counter++] = scanner.nextLine();
            }
        }
        System.out.println("================================");
        for (String input : inputs) {
            String[] line = input.split(" ");
            System.out.printf("%-15s", line[0]);
            System.out.printf("%03d\n", Integer.valueOf(line[1]));
        }
        System.out.println("================================");
    }
}
