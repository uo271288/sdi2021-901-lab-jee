package com.uniovi.services;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.uniovi.entities.Professor;

@Service
public class ProfessorService {
	private List<Professor> professorList = new LinkedList<Professor>();

	@PostConstruct
	public void init() {
		professorList.add(new Professor(1L, "123F", "Manuel", "Alvarez", "Literatura"));
		professorList.add(new Professor(2L, "456D", "Marta", "Perez", "Matematicas"));
	}

	public List<Professor> getProfessors() {
		return professorList;
	}

	public Professor getProfessor(Long id) {
		return professorList.stream().filter(professor -> professor.getId().equals(id)).findFirst().get();
	}

	public void addProfessor(Professor professor) {
		// Si en Id es null le asignamos el ultimo + 1 de la lista
		if (professor.getId() == null) {
			professor.setId(professorList.get(professorList.size() - 1).getId() + 1);
		}
		professorList.add(professor);
	}

	public void deleteProfessor(Long id) {
		professorList.removeIf(professor -> professor.getId().equals(id));
	}
}
