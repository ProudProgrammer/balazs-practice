package hu.practice.gaborbalazs.injector;

public class Injector {
	
	public static <T> T getInstance(Class<T> type) {
		T instance = null;
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