package org.gaborbalazs.practice.coding.leetcode.validparentheses;

class Solution {

    static void main(String[] arg) {

        System.out.println("'()' should be 'true' and it is: " + isValid("()"));
        System.out.println("'()[]{}' should be 'true' and it is: " + isValid("()[]{}"));
        System.out.println("'(]' should be 'false' and it is: " + isValid("(]"));
        System.out.println("'([])' should be 'true' and it is: " + isValid("([])"));
        System.out.println("'([)]' should be 'false' and it is: " + isValid("([)]"));
        System.out.println("'[({(())}[()])]' should be 'true' and it is: " + isValid("[({(())}[()])]"));
    }

    private static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        char[] chars = s.toCharArray();
        char lastChar = ' ';
        boolean isInvalid = false;
        boolean isValidClosingHappened = false;
        int openedBracket = 0;
        int openedCurlyBracket = 0;
        int openedSquareBracket = 0;
        for (char c : chars) {
            if (c == '(') {
                openedBracket++;
                lastChar = '(';
            } else if (c == ')') {
                openedBracket--;
                if (lastChar != '(' && !isValidClosingHappened) {
                    isInvalid = true;
                }
                isValidClosingHappened = openedBracket == 0;
                lastChar = ')';
            } else if (c == '{') {
                openedCurlyBracket++;
                lastChar = '{';
            } else if (c == '}') {
                openedCurlyBracket--;
                if (lastChar != '{' && !isValidClosingHappened) {
                    isInvalid = true;
                }
                isValidClosingHappened = openedCurlyBracket == 0;
                lastChar = '}';
            } else if (c == '[') {
                openedSquareBracket++;
                lastChar = '[';
            } else if (c == ']') {
                openedSquareBracket--;
                if (lastChar != '[' && !isValidClosingHappened) {
                    isInvalid = true;
                }
                isValidClosingHappened = openedSquareBracket == 0;
                lastChar = ']';
            }
            if (openedBracket < 0 || openedCurlyBracket < 0 || openedSquareBracket < 0 || isInvalid) {
                return false;
            }
        }
        return openedBracket == 0 && openedCurlyBracket == 0 && openedSquareBracket == 0;
    }
}
