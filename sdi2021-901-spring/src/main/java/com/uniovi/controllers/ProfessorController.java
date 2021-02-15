package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;

@RestController
public class ProfessorController {

	@Autowired
	ProfessorService p;

	@RequestMapping("/professor/edit/{id}")
	public String editProfessor(@PathVariable Long id) {
		return p.getProfessor(id).toString();
	}

	@RequestMapping("/professor/add")
	public String setProfessor() {
		p.addProfessor(new Professor(1L, "a", "b", "c", "d"));
		return "OK";
	}

	@RequestMapping("/professor/details/{id}")
	public String getDetail(@PathVariable Long id) {
		return p.getProfessor(id).toString();
	}

	@RequestMapping("/professor/delete/{id}")
	public String deleteProfessor(@PathVariable Long id) {
		p.deleteProfessor(id);
		return "OK";
	}
}
