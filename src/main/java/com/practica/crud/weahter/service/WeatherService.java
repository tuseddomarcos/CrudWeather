package com.practica.crud.weahter.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.crud.weahter.model.Weather;
import com.practica.crud.weahter.repository.WeatherRepository;



@Service
public class WeatherService {
	
	@Autowired
	WeatherRepository weatherRepository;
	
	
	public void saveWeather(Weather weather) {
		weatherRepository.save(weather);
	}
	
	public List<Weather> getAllWeather() {
		List<Weather> weathers = new ArrayList<Weather>();
		weatherRepository.findAll().forEach(weather -> weathers.add(weather));  
		return weathers;
	}

	public Weather getWeatherById(int id)   
	{  
		
		Date dare = new Date();
		return weatherRepository.findById(id).get();  
	} 
	
	public void delete(int id)   
	{  
	weatherRepository.deleteById(id);  
	}
}
