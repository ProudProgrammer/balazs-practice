package org.gaborbalazs.practice.coding.hackerrank.javaloopsii;

import java.util.Scanner;

class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();
        for (int queryNumber = 0; queryNumber < queries; queryNumber++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int series = in.nextInt();
            for (int seriesNumber = 0; seriesNumber < series; seriesNumber++) {
                int seriesResult = a;
                for (int subSeriesNumber = 0; subSeriesNumber <= seriesNumber; subSeriesNumber++) {
                    seriesResult += Math.pow(2, subSeriesNumber) * b;
                }
                System.out.print(seriesResult + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
