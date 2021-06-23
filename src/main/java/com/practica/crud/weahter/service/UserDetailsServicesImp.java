package com.practica.crud.weahter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practica.crud.weahter.model.User;
import com.practica.crud.weahter.model.UserPrincipal;

@Service 
public class UserDetailsServicesImp implements UserDetailsService {

	@Autowired
	UserServices userServices;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User usuario =  this.userServices.getByNameUser(username).get();
		return UserPrincipal.build(usuario);
		
	}



}
