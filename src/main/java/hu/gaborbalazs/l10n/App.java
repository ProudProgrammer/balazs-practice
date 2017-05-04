package hu.gaborbalazs.l10n;

import java.util.Locale;
import java.util.ResourceBundle;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Start");
		
		System.out.println("Default Locale: " + Locale.getDefault());
		Locale hu = new Locale("hu", "HU");
		ResourceBundle rs = ResourceBundle.getBundle("hu.gaborbalazs.l10n.test", hu);
		System.out.println("1=" + rs.getObject("1"));
		System.out.println("2=" + rs.getString("2"));
		System.out.println("3=" + rs.getString("3"));
		System.out.println("4=" + rs.getString("4"));
		System.out.println("5=" + rs.getString("5"));
		System.out.println("End");
	}
}