package com.practica.crud.weahter.dto;

import java.util.HashSet;
import java.util.Set;

import com.practica.crud.weahter.model.Rol;
import com.sun.istack.NotNull;

public class newUserDTO {
	
	private String name;
	
	@NotNull
	private String userName;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	private Set<Rol> roles = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	
	

}
