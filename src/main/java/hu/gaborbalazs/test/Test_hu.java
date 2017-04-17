package hu.gaborbalazs.test;

import java.util.ListResourceBundle;

import hu.gaborbalazs.test.Person;

public class Test_hu extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{"director", new Person("Bob", 52)},
			{"assistant", new Person("Alice", 38)}
		};
	}

}