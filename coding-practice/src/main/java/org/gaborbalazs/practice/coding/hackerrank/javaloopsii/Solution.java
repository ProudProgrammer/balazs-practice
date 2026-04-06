package org.gaborbalazs.practice.coding.hackerrank.javaloopsii;

import java.util.Scanner;

class Solution {

    private static final String EMPTY = " ";

    static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        String[][] lines = getLines();
        for (String[] strings : lines) {
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[1]);
            int n = Integer.parseInt(strings[2]);
            double result = a;
            for (int i = 0; i < n; i++) {
                result += Math.pow(2, i) * b;
                System.out.print((int) result);
                if (i != n - 1) {
                    System.out.print(EMPTY);
                }
            }
            System.out.println();
        }
    }

    private static String[][] getLines() {
        String[][] lines;
        try (Scanner scanner = new Scanner(System.in)) {
            int q = 0;
            if (scanner.hasNext()) {
                q = scanner.nextInt();
                scanner.nextLine();
            }
            lines = new String[q][3];
            int currentLine = 0;
            while (currentLine < q && scanner.hasNext()) {
                lines[currentLine] = scanner.nextLine().split(EMPTY);
                currentLine++;
            }
        }
        return lines;
    }
}

