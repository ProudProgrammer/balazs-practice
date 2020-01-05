package org.gaborbalazs.practice.javasetryouts.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NestedLoopWithLambda {

	public static void main(String[] args) {
		
		List<TestClass> testClassList = new ArrayList<>();
		testClassList.add(new TestClass(1, "text1"));
		testClassList.add(new TestClass(2, "text2"));
		testClassList.add(new TestClass(3, "text3"));
		testClassList.add(new TestClass(4, "text4"));
		testClassList.add(new TestClass(5, "text5"));
		
		List<Integer> idList = new ArrayList<>();
		idList.add(5);
		idList.add(1);
		idList.add(4);
		
		String texts = testClassList.stream().filter(e -> idList.contains(e.getId())).map(e -> e.getText()).collect(Collectors.joining(","));
		System.out.println(texts);
	}

}

class TestClass {
	private int id;
	private String text;
	public TestClass(int id, String text) {
		this.id = id;
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}