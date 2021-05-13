package com.practica.crud.weahter.repository;


import org.springframework.data.repository.CrudRepository;

import com.practica.crud.weahter.model.Weather;

public interface WeatherRepository  extends CrudRepository<Weather, Integer>{

}
