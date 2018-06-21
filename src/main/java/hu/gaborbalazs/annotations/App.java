package hu.gaborbalazs.annotations;

import java.util.Arrays;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		
		MyClass1 myClass1 = new MyClass1();
		MyClass2 myClass2 = new MyClass2();
		MyClass3 myClass3 = new MyClass3();
		
		System.out.println("myClass1: " + Arrays.asList(myClass1.getClass().getAnnotations()).stream().map(annotation -> annotation.toString()).collect(Collectors.joining(", ")));
		System.out.println("myClass2: " + Arrays.asList(myClass2.getClass().getAnnotations()).stream().map(annotation -> annotation.toString()).collect(Collectors.joining(", ")));
		System.out.println("myClass3: " + Arrays.asList(myClass3.getClass().getAnnotations()).stream().map(annotation -> annotation.toString()).collect(Collectors.joining(", ")));

		
	}

}

@MyAnnotation
class MyClass1 {
	
}

class MyClass2 extends MyClass1 {
	
}

class MyClass3 implements MyInterface1 {
	
}

@MyAnnotation
interface MyInterface1 {
	
}