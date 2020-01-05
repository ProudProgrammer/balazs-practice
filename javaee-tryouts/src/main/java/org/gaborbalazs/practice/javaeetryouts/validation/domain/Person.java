package org.gaborbalazs.practice.javaeetryouts.validation.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Person {

	@Min(2)
	private int id;
	
	@NotNull 
	private String name;
	
	@Min(2)
	private int age;
	
	
}
