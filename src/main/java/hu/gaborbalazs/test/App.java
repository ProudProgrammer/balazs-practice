package hu.gaborbalazs.test;

public class App {
	
	public static void main(String[] args) {

		String text1 = "bob";
		String text2 = "nagan";
		String text3 = "balazs";
		
		System.out.println("begin");
		
		System.out.println(text1 + " is a paliondrome: "  + isPalindrome(text1));
		System.out.println(text2 + " is a paliondrome: "  + isPalindrome(text2));
		System.out.println(text3 + " is a paliondrome: "  + isPalindrome(text3));
		
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
}
