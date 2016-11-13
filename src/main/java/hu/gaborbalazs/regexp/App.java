package hu.gaborbalazs.regexp;

public class App {

	public static void main(String[] args) {

		String text = "dsfworld\ndsdsd\nfdsf\ndkuPnPld\ndkfj_dfdf";
		System.out.println(text.matches("(.|\\s)*?uPnP(.|\\s)*?"));
	}
}