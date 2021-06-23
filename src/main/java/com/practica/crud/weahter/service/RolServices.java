package com.practica.crud.weahter.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.crud.weahter.model.Rol;
import com.practica.crud.weahter.repository.RolRepository;

@Service
@Transactional
public class RolServices {

	@Autowired
	RolRepository rolRepository;
	
	public List<Rol> getAllRol(){
		List<Rol> roles = new ArrayList<>();
		rolRepository.findAll().forEach(rol -> roles.add(rol)); 
		return roles;
	}
}
