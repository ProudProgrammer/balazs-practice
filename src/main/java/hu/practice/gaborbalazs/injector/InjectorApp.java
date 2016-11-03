package hu.practice.gaborbalazs.injector;

public class InjectorApp {

	public static void main(String[] args) {
		
		System.out.println("Injector Test App");
		Object instance = Injector.getInstance(String.class);
		System.out.println(instance instanceof String);
	}
}
