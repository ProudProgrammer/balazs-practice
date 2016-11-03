package hu.practice.gaborbalazs.injector;

public class Injector {
	
	public static Object getInstance(Class type) {
		Object instance = null;
		try {
			instance = type.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		};
		return instance;
	}
}