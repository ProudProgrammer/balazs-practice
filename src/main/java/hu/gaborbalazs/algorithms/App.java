package hu.gaborbalazs.algorithms;

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

		System.out.println(text1 + " is a palindrome: "  + app.isPalindrome(text1));
		System.out.println(text2 + " is a palindrome: "  + app.isPalindrome(text2));
		System.out.println(text3 + " is a palindrome: "  + app.isPalindrome(text3));
		
		// Exercise 2 - Adding numbers while remain only one
		// Example: input: 555, output: 6 (5 + 5 + 5 = 15, 1 + 5 = 6)
		
		int num1 = 123456789;
		
		System.out.println(app.specialSum(num1));
		
		// Exercise 3 - Lottery number generator: given a Random interface which returns a random integer
		
		System.out.println(app.generate(1, 91, 5));
		
		System.out.println("end");
	}
	
	public boolean isPalindrome(CharSequence input) {
		if(input == null || "".equals(input)) {
			throw new IllegalArgumentException("Input is null or blank!");
		}
		if(new StringBuilder(input).reverse().toString().equals(input)) {
			return true;
		}
		return false;
	}
	
	public int specialSum(int num) {
		if(num < 10 && num > -10) {
			return num;
		}
		int result = 0;
		char[] array = String.valueOf(num).toCharArray();
		while(array.length != 1) {
			result = 0;
			for(char c : array) {
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
		while(nums.size() < count) {
			nums.add((Math.abs(randomImpl.nextInt()) % interval) + from);
		}
		return nums;
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
