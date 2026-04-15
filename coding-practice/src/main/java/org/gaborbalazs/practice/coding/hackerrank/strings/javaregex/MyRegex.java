package org.gaborbalazs.practice.coding.hackerrank.strings.javaregex;

public class MyRegex {

    /*
     IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255.
     Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
     */
    private static final String REGEX = "((25[0-5])|(2[0-4]\\d)|(1\\d\\d)|(0?\\d?\\d))(\\.((25[0-5])|(2[0-4]\\d)|(1\\d\\d)|(0?\\d?\\d))){3}";

    public boolean isValidIpAddress(String ipAddress) {
        return ipAddress.matches(REGEX);
    }
}
