package hu.gaborbalazs.generics;

import java.util.List;

public class App {

	static Object o;
	static A a;
	static B b;
	static C c;
	
	public static void main(String[] args) {

		List<B> list = null;
		list.add(b);
		list.add(c);
	}
	
	public static void m1(List<? super B> list) {
		list.add(b);
		list.add(c);
		list.add(null);
		
		o = list.get(0);
	}
	
	public static void m2(List<? extends B> list) {
		list.add(null);
		
		o = list.get(0);
		a = list.get(0);
		b = list.get(0);
	}
}

class A {}
class B extends A {}
class C extends B {}
