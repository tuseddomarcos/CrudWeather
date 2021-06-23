package com.practica.crud.weahter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.practica.crud.weahter.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	Optional <User> findByUserName(String nombreUsuario);
	
    @Query(" SELECT COUNT(*) FROM User  WHERE userName = :name")
	int existsByuserName(@Param("name") String userName);
    
    @Query(" SELECT COUNT(*) FROM User WHERE email = :email")
	int existsByEmail( @Param("email") String email);
}