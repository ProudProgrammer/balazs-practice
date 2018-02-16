package hu.gaborbalazs.regexp;

public class App {

	public static void main(String[] args) {

		String text1 = "dsfworld\ndsdsd\nfdsf\ndkuPnPld\ndkfj_dfdf";
		String pattern1 = "(.|\\s)*?uPnP(.|\\s)*?";
		System.out.println(text1.matches(pattern1));
		
		//Empty String or 193.227.196.129-254
		String text2 = "193.227.196.129";
		String pattern2 = "^$|193\\.227\\.196\\.(129|1[3-9][0-9]|2[0-4][0-9]|25[0-4])";
		System.err.println(text2.matches(pattern2));
	}
}