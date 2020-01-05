package org.gaborbalazs.practice.javasetryouts.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaMain {

	public static void main(String[] args) {
		
		List<MyClass> list = new ArrayList<>();
		list.add(new MyClass());
		list.add(new MyClass());
		
		list.forEach(myConsumer);

	}

	
	private static Consumer<MyClass> myConsumer = e -> {
		try {
			e.mymethod();
		} catch (Exception ex) {
			System.out.println("exception cought");
		}
	};
	
	@FunctionalInterface
	private static interface MyCheckedConsumer<T> {
		
		void accept(T t) throws Exception;
		
	}


}

class MyClass {
	void mymethod()  throws Exception  {
		System.out.println("hello");
	}
}
