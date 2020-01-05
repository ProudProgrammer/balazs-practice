package org.gaborbalazs.practice.javaeetryouts.validation.application;

import org.gaborbalazs.practice.javaeetryouts.validation.domain.Person;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class App {

	public static void main(String[] args) {

		System.out.println(">> main()");

		Person p = new Person();
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Person>> violations = validator.validate(p);

		System.out.println(violations.size());

		System.out.println("<< main()");
	}
}