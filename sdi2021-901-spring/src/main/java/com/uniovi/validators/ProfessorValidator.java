package com.uniovi.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.uniovi.entities.Mark;
import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;

@Component
public class ProfessorValidator implements Validator {
    @Autowired
    private ProfessorService professorService;

    @Override
    public boolean supports(Class<?> aClass) {
	return Mark.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
	Professor profesor = (Professor) target;

	if (profesor.getDni().length() != 9) {
	    errors.rejectValue("dni", "Error.signup.dni.length");

	} else if (!Character.isLetter(profesor.getDni().charAt(8))) {
	    errors.rejectValue("dni", "Error.signup.dni.character");
	}

	if (professorService.getProfessorByDni(profesor.getDni()) != null) {
	    errors.rejectValue("dni", "Error.signup.dni.duplicate");
	}

	if (profesor.getNombre().length() < 5 || profesor.getNombre().length() > 24) {
	    errors.rejectValue("nombre", "Error.signup.name.length");
	}

	if (profesor.getApellido().length() < 5 || profesor.getApellido().length() > 24) {
	    errors.rejectValue("apellido", "Error.signup.lastName.length");

	}

	if (profesor.getCategoria().length() < 5 || profesor.getCategoria().length() > 24) {
	    errors.rejectValue("categoria", "Error.signup.categoria.length");

	}
    }
}