package hu.practice.gaborbalazs.functionpointer;

public class FunctionPointerApp {

	public static void main(String[] args) {

		System.out.println("With Java 1.8 Lambda Expression");
		System.out.println(FunctionPointerClass.doSomething("Hello", e -> e + " " + e));
		System.out.println(FunctionPointerClass.doSomething("Hello", e -> e));
		
		System.out.println();
		
		System.out.println("Without Java 1.8 Lambda Expression. With anonymous function");
		System.out.println(FunctionPointerClass.doSomething("Hello", new FunctionPointerInterface() {
			
			@Override
			public String function(String text) {
				return text + " " + text;
			}
		}));
		System.out.println(FunctionPointerClass.doSomething("Hello", new FunctionPointerInterface() {
			
			@Override
			public String function(String text) {
				return text;
			}
		}));
	}
}
