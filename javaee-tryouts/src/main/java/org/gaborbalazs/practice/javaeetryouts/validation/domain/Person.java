package org.gaborbalazs.practice.javaeetryouts.validation.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Person {

	@Min(2)
	private int id;

	@NotNull
	private String name;

	@Min(2)
	private int age;
}
