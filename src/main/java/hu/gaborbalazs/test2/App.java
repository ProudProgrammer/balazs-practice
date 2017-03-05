package hu.gaborbalazs.test2;

public class App extends AncestorApp {
	
	App() {
		s2 = m("constructor App - s2");
	}
	
	{
		s2 = m("init #1 - s2");
	}
	
	String s2 = m("s2");
	
	static {
		s1 = m("static init #1 - s1");
	}
	
	static String s1 = m("s1");
	
	static {
		s1 = m("static init #2 - s1");
	}
	
	public static void main(String[] args) {
		App app = new App();
		System.out.println("main - s1: " + s1);
		System.out.println("main - s2: " + app.s2);
		
	}
	
	public static String m(String s) {
		System.out.println(s);
		return s;
	}
}

class AncestorApp {
	
	AncestorApp() {
		App.m("constructor AncestorApp");
	}
}
