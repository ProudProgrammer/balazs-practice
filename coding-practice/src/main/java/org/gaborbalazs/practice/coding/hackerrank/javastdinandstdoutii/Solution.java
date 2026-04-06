package org.gaborbalazs.practice.coding.hackerrank.javastdinandstdoutii;

import java.util.Scanner;

class Solution {

    static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int integerNumber = 0;
        double doubleNumber = 0;
        String string = "";
        int counter = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (counter < 3 && scanner.hasNext()) {
                if (counter == 0) {
                    integerNumber = scanner.nextInt();
                    scanner.nextLine();
                } else if (counter == 1) {
                    doubleNumber = scanner.nextDouble();
                    scanner.nextLine();
                } else {
                    string = scanner.nextLine();
                }
                counter++;
            }
        }
        System.out.println("String: " + string);
        System.out.println("Double: " + doubleNumber);
        System.out.println("Int: " + integerNumber);
    }
}
