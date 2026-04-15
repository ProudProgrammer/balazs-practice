package org.gaborbalazs.practice.coding.hackerrank.strings.javaregex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MyRegexTest {

    private MyRegex underTest;

    @BeforeEach
    void setUp() {
        underTest = new MyRegex();
    }

    @ParameterizedTest
    @ValueSource(strings = {"000.12.12.034", "121.234.12.12", "23.45.12.56",})
    void shouldReturnTrueWhenIpAddressIsValid(String ipAddress) {
        boolean result = underTest.isValidIpAddress(ipAddress);

        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"00.12.123.123123.123", "122.23", "Hello.IP",})
    void shouldReturnFalseWhenIpAddressIsNotValid(String ipAddress) {
        boolean result = underTest.isValidIpAddress(ipAddress);

        assertFalse(result);
    }
}