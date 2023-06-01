package com.Grupo3.Trabalho1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo3.Trabalho1.entities.Turma;
import com.Grupo3.Trabalho1.repositories.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	TurmaRepository turmaRepository;

	public List<Turma> getAllTurmas() {
		return turmaRepository.findAll();

	}

	public Turma getTurmaById(Integer id) {
		return turmaRepository.findById(id).orElse(null);
	}

	public Turma saveTurma(Turma turma) {
		return turmaRepository.save(turma);
	}

	public Turma updateTurma(Turma turma, Integer id) {
		return turmaRepository.save(turma);
	}

	public Boolean deleteTurma(Integer id) {
		Turma turma = turmaRepository.findById(id).orElse(null);
		if (turma != null) {
			turmaRepository.deleteById(id);
			return true;

		} else {

			return false;
		}
	}

}