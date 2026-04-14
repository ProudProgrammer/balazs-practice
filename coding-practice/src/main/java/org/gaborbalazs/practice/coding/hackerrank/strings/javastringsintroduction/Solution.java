package org.gaborbalazs.practice.coding.hackerrank.strings.javastringsintroduction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static void main(String[] args) {

        List<String> inputs = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            int counter = 0;
            while (counter < 2 && scanner.hasNext()) {
                counter++;
                inputs.add(scanner.nextLine());
            }
        }
        StringProcessor stringProcessor = new StringProcessor();
        List<String> results = stringProcessor.getLines(inputs);
        results.forEach(System.out::println);
    }
}
