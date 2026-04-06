package org.gaborbalazs.practice.coding.hackerrank.javaendoffile;

import java.util.Scanner;

class Solution {

    static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int counter = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                counter++;
                System.out.println(counter + " " + scanner.nextLine());
            }
        }
    }
}
