package com.practica.crud.weahter.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table (name = "USERS")
public class User {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_usuario;
	
	@Column
	@NotNull
	private String name;
	
	@Column(unique = true)
	private String userName;
	
	@NotNull
	@Column
	private String email;
	
	@NotNull
	@Column
	private String password;
	
	@NotNull
	@ManyToMany
	@JoinTable(name = "usuario_rol" , joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "idRol") )
	private Set<Rol> roles = new HashSet<>();

	public User() {}

	public User( String name, String name_user, String email, String password) {
		super();
		this.name = name;
		this.userName = name_user;
		this.email = email;
		this.password = password;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

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
