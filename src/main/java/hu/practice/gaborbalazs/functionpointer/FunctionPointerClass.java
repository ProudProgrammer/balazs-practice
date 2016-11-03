package hu.practice.gaborbalazs.functionpointer;

public class FunctionPointerClass {

	public static String doSomething(String text, FunctionPointerInterface functionPointerInterface) {
		return functionPointerInterface.function(text);
	}
}
