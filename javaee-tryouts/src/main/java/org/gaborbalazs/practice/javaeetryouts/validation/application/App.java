package org.gaborbalazs.practice.javaeetryouts.validation.application;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.gaborbalazs.practice.javaeetryouts.validation.domain.Person;

import java.util.Set;

public class App {

	static void main(String[] args) {

		System.out.println(">> main()");

		Person p = new Person();
        Set<ConstraintViolation<Person>> violations;
		try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = validatorFactory.getValidator();
            violations = validator.validate(p);
        }
		System.out.println(violations.size());

		System.out.println("<< main()");
	}
}