package hu.gaborbalazs.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.NamedParameters;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class AppTest {

	private App underTest;

	@Before
	public void setUp() {
		underTest = new App();
	}

	@Test
	@Parameters(method = "getPalindromes")
	public void testIsPalindromeWithPalindromes(String text) {
		assertTrue(underTest.isPalindrome(text));
	}

	@Test
	@Parameters(method = "getNotPalindromes")
	public void testIsPalindromeWithNotPalindromes(String text) {
		assertFalse(underTest.isPalindrome(text));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIsPalindromeWithNull() {
		underTest.isPalindrome(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIsPalindromeWithEmptyString() {
		underTest.isPalindrome("");
	}

	@Test
	@Parameters(method = "getPalindromes")
	public void testIsPalindrome2WithPalindromes(String text) {
		assertTrue(underTest.isPalindrome2(text));
	}

	@Test
	@Parameters(method = "getNotPalindromes")
	public void testIsPalindrome2WithNotPalindromes(String text) {
		assertFalse(underTest.isPalindrome2(text));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIsPalindrome2WithNull() {
		underTest.isPalindrome2(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIsPalindrome2WithEmptyString() {
		underTest.isPalindrome2("");
	}

	@Test
	@Parameters({ "-900040010, 6", "-10, 1", "-9, 0", "0, 1", "9, 0", "10, 1", "900040010, 6" })
	public void testCountZeros(int num, int expected) {
		int actual = underTest.countZeros(num);
		assertEquals(expected, actual);
	}

	@NamedParameters("palindromes")
	private Object[] getPalindromes() {
		return new Object[] { "bob", "nagan", "naggan", "a", "abcdefghijklmnopqrrqponmlkjihgfedcba" };
	}

	@NamedParameters("notPalindromes")
	private Object[] getNotPalindromes() {
		return new Object[] { "bobbobb", "susan", "ab", "abcdefghijklmnopqr" };
	}
}
