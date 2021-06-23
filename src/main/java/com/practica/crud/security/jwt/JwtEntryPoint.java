package com.practica.crud.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

//Verifica que exista un tocken
@Component 
public class JwtEntryPoint implements AuthenticationEntryPoint {
	
	private final static org.slf4j.Logger logger =  LoggerFactory.getLogger(JwtEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		logger.error("Fallo en el metodo commence");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "usuario no autorizado");
		
		
	}

}
