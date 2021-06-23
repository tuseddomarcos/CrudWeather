package com.practica.crud.weahter.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.crud.weahter.model.Weather;

public interface WeatherRepository  extends JpaRepository<Weather, Integer>{

}
