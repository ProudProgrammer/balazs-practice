package org.gaborbalazs.practice.coding.hackerrank.javadatatypes;

import java.util.Arrays;
import java.util.Scanner;

class Solution {

    static void main(String[] arg) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        String[] lines = getLines();
        Arrays.stream(lines).map(Solution::getText).forEach(System.out::print);
    }

    private static String[] getLines() {
        int testCases = 0;
        String[] lines;
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNext()) {
                testCases = scanner.nextInt();
                scanner.nextLine();
            }
            lines = new String[testCases];
            int counter = 0;
            while (counter < testCases && scanner.hasNext()) {
                lines[counter++] = scanner.nextLine();
            }
        }
        return lines;
    }

    private static String getText(String line) {
        String result = line;
        long number = 0;
        boolean isTooBig = false;
        try {
            number = Long.parseLong(line);
        } catch (NumberFormatException e) {
            isTooBig = true;
        }
        if (isTooBig) {
            result += " can't be fitted anywhere.\n";
        } else {
            result += " can be fitted in:\n";
            if (number >= Byte.MIN_VALUE && number <= Byte.MAX_VALUE) {
                result += "* byte\n* short\n* int\n";
            } else if (number >= Short.MIN_VALUE && number <= Short.MAX_VALUE) {
                result += "* short\n* int\n";
            } else if (number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE) {
                result += "* int\n";
            }
            result += "* long\n";
        }
        return result;
    }
}
