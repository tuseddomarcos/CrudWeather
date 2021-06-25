package com.practica.crud.weahter.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.crud.security.jwt.JwtProvider;
import com.practica.crud.weahter.dto.JwtDTO;
import com.practica.crud.weahter.dto.LoginDTO;
import com.practica.crud.weahter.dto.newUserDTO;
import com.practica.crud.weahter.model.Rol;
import com.practica.crud.weahter.model.User;
import com.practica.crud.weahter.service.RolServices;
import com.practica.crud.weahter.service.UserServices;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	UserServices userServices;
	
	@Autowired
	RolServices rolServices;
	
	@Autowired
	JwtProvider jwtProvider;
	
	
	@PostMapping("/new")
	public ResponseEntity<?> newUser(@Validated @RequestBody newUserDTO usuario, BindingResult bindingresult){
		
		if(bindingresult.hasErrors()) 
			return new ResponseEntity<>("Error en el usuario", HttpStatus.BAD_REQUEST);
		if(this.userServices.existsByUserName(usuario.getName()))
			return new ResponseEntity<>("El nombre de usuario existente", HttpStatus.CONFLICT);
		if(this.userServices.existsByUserEmail(usuario.getEmail()))
			return new ResponseEntity<>("El email de usuario existente", HttpStatus.CONFLICT);
		
		User newUser = new User(usuario.getName(),usuario.getUserName(), usuario.getEmail(), 
						passwordEncoder.encode(usuario.getPassword())); 
		
		Set<Rol> roles = new HashSet<>();
		rolServices.getAllRol().forEach(rol -> roles.add(rol)); 
		newUser.setRoles(roles);
		
		this.userServices.saveUser(newUser);
		
		return new ResponseEntity<>("Usuario generado exitosamente", HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO userLogin, BindingResult bindingresult){
		
		if(bindingresult.hasErrors()) 
			return new ResponseEntity<>("Capos mal seteados", HttpStatus.BAD_REQUEST);
		
		Authentication auth = 
				this.authManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUserName(), userLogin.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		String jwt = this.jwtProvider.generateTocken(auth);
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		
		return new ResponseEntity<>(jwtDto, HttpStatus.OK);
	}
	
}
