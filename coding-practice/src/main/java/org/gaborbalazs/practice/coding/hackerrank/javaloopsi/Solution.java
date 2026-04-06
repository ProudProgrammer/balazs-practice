package org.gaborbalazs.practice.coding.hackerrank.javaloopsi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine().trim());
        bufferedReader.close();
        for (int i = 1; i < 11; i++) {
            System.out.println(N + " x " + i + " = " + N * i);
        }
    }
}
