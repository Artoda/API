package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Usuario;
import com.residencia.biblioteca.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();

	}

	public Usuario getUsuarioById(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	// Cuidado quando for updar.
	public Usuario updateUsuario(Usuario usuario, Integer id) {
		return usuarioRepository.save(usuario);
	}

	public Boolean deleteUsuario(Integer id) {
		usuarioRepository.deleteById(id);
		Usuario usuarioDeletado = usuarioRepository.findById(id).orElse(null);
		if (null == usuarioDeletado)
			return true;
		else
			return false;
	}

}
