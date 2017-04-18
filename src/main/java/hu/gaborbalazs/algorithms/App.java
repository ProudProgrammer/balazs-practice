package hu.gaborbalazs.algorithms;

public class App {
	
	public static void main(String[] args) {

		String text1 = "bob";
		String text2 = "nagan";
		String text3 = "balazs";
		
		System.out.println("begin");
		
		System.out.println(text1 + " is a palindrome: "  + isPalindrome(text1));
		System.out.println(text2 + " is a palindrome: "  + isPalindrome(text2));
		System.out.println(text3 + " is a palindrome: "  + isPalindrome(text3));
		
		int num1 = 123456789;
		
		System.out.println(specialSum(num1));
		
		System.out.println("end");
	}
	
	public static boolean isPalindrome(CharSequence input) {
		if(input == null || "".equals(input)) {
			throw new IllegalArgumentException("Input is null or blank!");
		}
		if(new StringBuilder(input).reverse().toString().equals(input)) {
			return true;
		}
		return false;
	}
	
	public static int specialSum(int num) {
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
}