package org.gaborbalazs.practice.coding.algorithms;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class App {

	public static void main(String[] args) {

		System.out.println("begin");

		App app = new App();

		// Exercise 1 - Palindrome

		String text1 = "bob";
		String text2 = "nagan";
		String text3 = "balazs";

		System.out.println(text1 + " is a palindrome: " + app.isPalindrome(text1) + ", " + app.isPalindrome2(text1));
		System.out.println(text2 + " is a palindrome: " + app.isPalindrome(text2) + ", " + app.isPalindrome2(text2));
		System.out.println(text3 + " is a palindrome: " + app.isPalindrome(text3) + ", " + app.isPalindrome2(text3));

		// Exercise 2 - Adding numbers while remain only one
		// Example: input: 555, output: 6 (5 + 5 + 5 = 15, 1 + 5 = 6)

		int num1 = 123456789;

		System.out.println(app.specialSum(num1));

		// Exercise 3 - Lottery number generator: given a Random interface which returns
		// a random integer

		System.out.println(app.generate(1, 91, 5));

		// Exercise 4 - Count zeros in a number

		System.out.println(app.countZeros(-1007));

		System.out.println("end");
	}

	public boolean isPalindrome(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("Incorrect input");
		}
		if (new StringBuilder(input).reverse().toString().equals(input)) {
			return true;
		}
		return false;
	}

	public boolean isPalindrome2(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("Incorrect input");
		}
		if (input.length() == 1) {
			return true;
		}
		String[] inputAsArray = input.split("");
		for (int i = 0; i < inputAsArray.length / 2; i++) {
			if (!inputAsArray[i].equals(inputAsArray[inputAsArray.length - 1 - i])) {
				return false;
			}
		}
		return true;
	}

	public int specialSum(int num) {
		if (num < 10 && num > -10) {
			return num;
		}
		int result = 0;
		char[] array = String.valueOf(num).toCharArray();
		while (array.length != 1) {
			result = 0;
			for (char c : array) {
				result += Character.digit(c, 10);
			}
			array = String.valueOf(result).toCharArray();
		}
		return result;
	}

	public Set<Integer> generate(int from, int to, int count) {
		if (from < 1 || from >= to || count < 1) {
			throw new IllegalArgumentException("Incorrect arguments");
		}
		int interval = to - from;
		Set<Integer> nums = new HashSet<>();
		RandomImpl randomImpl = new RandomImpl();
		while (nums.size() < count) {
			nums.add((Math.abs(randomImpl.nextInt()) % interval) + from);
		}
		return nums;
	}

	public int countZeros(int num) {
		return countZerosRecursively(num, 0);
	}

	private int countZerosRecursively(int num, int counter) {
		if (num == 0) {
			return ++counter;
		}
		if (!(num <= -10 || num >= 10)) {
			return counter;
		}
		if (num % 10 == 0) {
			counter++;
		}
		return countZerosRecursively(num / 10, counter);
	}
}

interface Random {

	int nextInt();
}

// A possible implementation of Random
class RandomImpl implements Random {

	ThreadLocalRandom random = ThreadLocalRandom.current();

	@Override
	public int nextInt() {
		return random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}
