package com.practica.crud.weahter.repository;

import org.springframework.data.repository.CrudRepository;

import com.practica.crud.weahter.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}