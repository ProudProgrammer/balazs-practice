package org.gaborbalazs.practice.coding.algorithms;

import java.util.Random;

public class LongDigitSum {

    public static void main(String[] args) {
        java.util.Random random = new Random();
        long num = random.nextLong();
        while (num > 9) {
            num = addNumbers(num);
        }
    }

    static int addNumbers(long num) {
        int result = 0;
        char[] chars = String.valueOf(num).toCharArray();
        for (char c : chars) {
            result += Character.digit(c, 10);
        }
        return result;
    }
}
