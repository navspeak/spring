package com.nav.spring.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;

public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String>{
	
	private int min;
	private int max;

	@Override
	public void initialize(ValidEmail constraintAnnotation) {
		min = constraintAnnotation.min();
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (email.length() < min)
			return false;
		if (EmailValidator.getInstance(true).isValid(email))
			return false;
					
		return true;
	}

}
