package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.repositories.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	EditoraRepository editoraRepository;

	public List<Editora> getAllEditoras() {
		return editoraRepository.findAll();

	}

	public Editora getEditoraById(Integer id) {
		return editoraRepository.findById(id).orElse(null);
	}

	public Editora saveEditora(Editora editora) {
		return editoraRepository.save(editora);
	}

	// Cuidado quando for updar.
	public Editora updateEditora(Editora editora, Integer id) {
		return editoraRepository.save(editora);
	}

	public Boolean deleteEditora(Integer id) {
		editoraRepository.deleteById(id);
		Editora editoraDeletado = editoraRepository.findById(id).orElse(null);
		if (null == editoraDeletado)
			return true;
		else
			return false;
	}

}
