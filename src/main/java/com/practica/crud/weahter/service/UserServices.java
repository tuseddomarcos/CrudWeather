package com.practica.crud.weahter.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.crud.weahter.model.User;
import com.practica.crud.weahter.repository.UserRepository;

@Service
@Transactional
public class UserServices {
	
	@Autowired
	UserRepository userRepository;
	
	
	public Optional<User> getByNameUser(String nombre){
		
		return this.userRepository.findByUserName(nombre);	
		
	}
	
	public boolean existsByUserName(String userName) {
		int cont = this.userRepository.existsByuserName(userName);
		
		if(cont != 0)
			return false;
		
	 return false;
	}
	
	public boolean existsByUserEmail(String email) {
		int cont = this.userRepository.existsByEmail(email);
		
		if(cont != 0)
			return false;
		
	 return false;
		
	}
	
	public void saveUser(User user) {
		this.userRepository.save(user);
	}
	
	
}
