package org.gaborbalazs.practice.coding.hackerrank.introduction.javaifelse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    private static final String WEIRD = "Weird";
    private static final String NOT_WEIRD = "Not Weird";

    static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine().trim());
        bufferedReader.close();
        if (N % 2 != 0) {
            System.out.println(WEIRD);
        } else if (N >= 2 && N <= 5) {
            System.out.println(NOT_WEIRD);
        } else if (N >= 6 && N <= 20) {
            System.out.println(WEIRD);
        } else if (N > 20) {
            System.out.println(NOT_WEIRD);
        }
    }
}
