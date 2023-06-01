package com.Grupo3.Trabalho1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo3.Trabalho1.entities.Telefone;
import com.Grupo3.Trabalho1.repositories.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	TelefoneRepository telefoneRepository;

	public List<Telefone> getAllTelefones() {
		return telefoneRepository.findAll();

	}

	public Telefone getTelefoneById(Integer id) {
		return telefoneRepository.findById(id).orElse(null);
	}

	public Telefone saveTelefone(Telefone telefone) {
		return telefoneRepository.save(telefone);
	}

	public Telefone updateTelefone(Telefone telefone, Integer id) {
		return telefoneRepository.save(telefone);
	}
	
	public Boolean deleteTelefone(Integer id) {
		Telefone telefone = telefoneRepository.findById(id).orElse(null);
		if (telefone != null) {
			telefoneRepository.deleteById(id);
			return true;

		} else {

			return false;
		}
	}

}
