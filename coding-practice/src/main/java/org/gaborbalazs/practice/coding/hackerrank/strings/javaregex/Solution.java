package org.gaborbalazs.practice.coding.hackerrank.strings.javaregex;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        MyRegex myRegex = new MyRegex();
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                System.out.println(myRegex.isValidIpAddress(scanner.nextLine()));
            }
        }
    }
}
