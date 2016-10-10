package hu.gaborbalazs;

public class App {

	public static void main(String[] args) {

		String text = "dsfworld\ndsdsd\nfdsf\ndkld\ndkfj_dfdf";
		System.out.println(text.matches("(.|\\s)*?world(.|\\s)*?"));

	}
}