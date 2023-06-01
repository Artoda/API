package br.com.residencia.seguranca.security.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.residencia.seguranca.entity.User;
import br.com.residencia.seguranca.repository.UserRepository;

public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public User findByUsername (String userName) {
		return userRepository.findByUsername(userName).orElse(null);
	}
	
}
