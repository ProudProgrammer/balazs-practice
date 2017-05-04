package hu.gaborbalazs.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {

		try {
			m1();
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void m1() throws MyException {
		C c = new C();
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
		list.forEach(t -> {
			try {
				m2(t);
			} catch (MyException e) {
				c.ex = e;
			}
		});
		if(c.ex != null) {
			throw c.ex;
		}
	}
	
	public static void m2(Integer i) throws MyException {
		System.out.println(i);
		throw new MyException("hello");
	}
}

class MyException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public MyException() {
		super();
	}
	public MyException(String s) {
		super(s);
	}
}

class C {
	MyException ex = null;
}