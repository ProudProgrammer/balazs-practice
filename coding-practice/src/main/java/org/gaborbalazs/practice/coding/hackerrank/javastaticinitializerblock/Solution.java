package org.gaborbalazs.practice.coding.hackerrank.javastaticinitializerblock;

import java.util.Scanner;

class Solution {

    static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int[] inputs = new int[2];
        int counter = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (counter < 2 && scanner.hasNext()) {
                inputs[counter++] = scanner.nextInt();
            }
        }
        boolean isWrongInput = false;
        for (int input: inputs) {
            if (input <= 0) {
                isWrongInput = true;
                break;
            }
        }
        if (isWrongInput) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        } else {
            System.out.println(inputs[0] * inputs[1]);
        }
    }
}
