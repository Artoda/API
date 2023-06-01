package br.com.residencia.seguranca.dto;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {

	private Integer id;
	private String username;
	private String email;
	private Set<String> roles = new HashSet<>();

	public UserDTO() {
		super();

	}

	public UserDTO(Integer id, String username, String email, Set<String> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

}
