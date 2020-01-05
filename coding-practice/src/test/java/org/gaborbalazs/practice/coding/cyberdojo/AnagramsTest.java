package org.gaborbalazs.practice.coding.cyberdojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import junitparams.JUnitParamsRunner;
import junitparams.NamedParameters;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AnagramsTest {

    private Anagrams underTest;

    private int factorial(int num) {
        int fact = num == 0 ? 1 : (int) Math.signum(num);
        for (int i = 1; i <= Math.abs(num); i++) {
            fact = fact * i;
        }
        return fact;
    }

    @NamedParameters("returnCorrectTestDatas")
    private Object[] returnCorrectTestDatas() {
        return new Object[] { new Object[] { "ab", Arrays.asList("ab", "ba") },
                new Object[] { "123", Arrays.asList("123", "132", "213", "231", "312", "321") },
                new Object[] { "biro",
                        Arrays.asList("biro", "bior", "brio", "broi", "boir", "bori", "ibro", "ibor", "irbo", "irob",
                                "iobr", "iorb", "rbio", "rboi", "ribo", "riob", "roib", "robi", "obir", "obri", "oibr",
                                "oirb", "orbi", "orib") } };
    }

    @Before
    public void setUp() {
        underTest = new Anagrams();
    }

    @Test
    @Parameters({ "0, 1", "1, 1", "2, 2", "3, 6", "4, 24", "5, 120", "10, 3628800", "-1, -1", "-2, -2", "-3, -6",
            "-4, -24", "-5, -120", "-10, -3628800" })
    public void firstTestFactorial(int fact, int expected) {
        int actual = factorial(fact);
        assertEquals(expected, actual);
    }

    @Test
    public void testWithNull() {
        assertEquals(0, underTest.getAnagrams(null).size());
    }

    @Test
    public void testWithEmptyString() {
        assertEquals(0, underTest.getAnagrams("").size());
    }

    @Test
    @Parameters({ "1", "a", "X" })
    public void testWithOneLengthValue(String input) {
        List<String> retval = underTest.getAnagrams(input);
        assertEquals(1, retval.size());
        assertEquals(input, retval.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithLongValue() {
        underTest.getAnagrams("1234567890");
    }

    @Test
    @Parameters(method = "returnCorrectTestDatas")
    public void test(String input, List<String> output) {
        List<String> retval = underTest.getAnagrams(input);
        assertEquals(output.size(), retval.size());
        retval.forEach(e -> assertTrue(output.contains(e)));
    }
}
