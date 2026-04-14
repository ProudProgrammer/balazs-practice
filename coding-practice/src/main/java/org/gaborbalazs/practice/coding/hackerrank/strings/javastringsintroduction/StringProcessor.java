package org.gaborbalazs.practice.coding.hackerrank.strings.javastringsintroduction;

import java.util.ArrayList;
import java.util.List;

public class StringProcessor {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final String EMPTY = "";
    private static final String SPACE = " ";

    public List<String> getLines(List<String> inputs) {
        List<String> resultLines = new ArrayList<>();
        String firstInput = inputs.get(0);
        String secondInput = inputs.get(1);
        resultLines.add(EMPTY + (firstInput.length() + secondInput.length()));
        resultLines.add(firstInput.compareTo(secondInput) > 0 ? YES : NO);
        resultLines.add(getStringFirstLetterCapitalized(firstInput) + SPACE + getStringFirstLetterCapitalized(secondInput));
        return resultLines;
    }

    private String getStringFirstLetterCapitalized(String text) {
        char[] chars = text.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return String.copyValueOf(chars);
    }
}
