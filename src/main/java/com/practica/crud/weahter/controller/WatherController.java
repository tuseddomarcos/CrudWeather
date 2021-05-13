package com.practica.crud.weahter.controller;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.practica.crud.weahter.model.Weather;
import com.practica.crud.weahter.service.WeatherService;



@RestController
public class WatherController {

	@Autowired
	WeatherService services;
	 
	 @PostMapping("/weather")
	 public ResponseEntity<Object> responseInsert(@RequestBody Weather weather) throws ServiceException {
	        try{
	        	services.saveWeather(weather);
	        	return new ResponseEntity<>( weather, HttpStatus.CREATED);
	        }catch(ServiceException ex){
	            return new ResponseEntity<>( ex.getMessage(), HttpStatus.NOT_FOUND);
	        }catch(Exception e){
	            throw new ServiceException(e.getMessage());
	        }
	    }
	 
	 @GetMapping(value="/weather")
	 private ResponseEntity<?> finAllWeather(){
		 try{
			 return new ResponseEntity<>( services.getAllWeather(), HttpStatus.OK);
	        }catch(ServiceException ex){
	        	 return new ResponseEntity<>( ex.getMessage(), HttpStatus.BAD_REQUEST);
	        }catch(Exception e){
	            throw new ServiceException(e.getMessage());
	        }
		 
	 }
	 @GetMapping(value="/weather")
	 private ResponseEntity<Object> finWeatherById(@RequestHeader("id") int id){ 
		 try{
			 return new ResponseEntity<>(services.getWeatherById(id), HttpStatus.OK);
	        }catch(ServiceException ex){
	            return null;
	        }catch(Exception e){
	            throw new ServiceException(e.getMessage());
	        }
		 
	 }
}
