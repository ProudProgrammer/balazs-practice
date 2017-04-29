package hu.gaborbalazs.weakreference;

import java.lang.ref.WeakReference;
import java.text.MessageFormat;

public class App {

	public static void main(String[] args) throws InterruptedException {
		
		WeakReference<Person2> wr = new WeakReference<>(new Person2("Bob", 56));
		System.out.println(wr.get());
		System.gc();
		System.out.println(wr.get());
		Thread.sleep(3000);
		System.out.println(wr.get());
		Thread.sleep(3000);
		System.out.println(wr.get());
		Thread.sleep(3000);
		System.out.println(wr.get());
		
	}
}

class Person2 {
	private String name;
	private int age;
	
	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return MessageFormat.format("Person name={0}, age={1}", name, age);
	}
}
