package com.uniovi.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.uniovi.entities.Mark;

@Component
public class MarkValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return Mark.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Mark mark = (Mark) target;
		if (mark.getScore() < 0.0 || mark.getScore() > 10.0)
			errors.rejectValue("score", "Error.mark.score.outOfBounds");
		if (mark.getDescription() == null || mark.getDescription().length() < 20)
			errors.rejectValue("description", "Error.mark.description.length");
	}
}