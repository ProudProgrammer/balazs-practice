package hu.gaborbalazs;

import java.util.HashSet;

public class App {
	
	public static void main(String[] args) {
		
		System.out.println("Hello World");
		
		Person p1 = new Person(123);
		Person p2 = new Person(123);
		
		HashSet<Person> set = new HashSet<Person>();
		
		set.add(p1);
		
		System.out.println(set.contains(p2));
	}
}