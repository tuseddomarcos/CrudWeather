package com.practica.crud.weahter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.practica.crud.weahter.enums.RolName;
import com.sun.istack.NotNull;

@Entity
@Table (name = "Roll")
public class Rol {
	
	
	  @Id
	  @Column
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private int idRol;
	  
	  @Column
	  @NotNull
	  @Enumerated(EnumType.STRING)
	  private RolName rolName;
  
  
  	public Rol() {}



	public Rol(int id_Rol, RolName nameRol) {
		super();
		this.idRol = id_Rol;
		this.rolName = nameRol;
		}



	public int getId_Rol() {
		return idRol;
	}



	public void setId_Rol(int id_Rol) {
		this.idRol = id_Rol;
	}



	public RolName getNameRol() {
		return rolName;
	}



	public void setNameRol(RolName nameRol) {
		this.rolName = nameRol;
	}
	
  
}
