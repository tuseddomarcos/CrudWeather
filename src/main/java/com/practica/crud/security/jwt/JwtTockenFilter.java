package com.practica.crud.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.practica.crud.weahter.service.UserDetailsServicesImp;

public class JwtTockenFilter extends OncePerRequestFilter {
	
	private final static org.slf4j.Logger logger =  LoggerFactory.getLogger(JwtTockenFilter.class);
	
	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	UserDetailsServicesImp userDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			String tocken = this.getTocken(request);
			if(tocken != null && jwtProvider.validateTocken(tocken) ) {
				String nombreUsuario = jwtProvider.getUserNameFromTocken(tocken);
				UserDetails userDetail = this.userDetailService.loadUserByUsername(nombreUsuario);
				UsernamePasswordAuthenticationToken auth = 
						new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
				
			}
			
		} catch (Exception e) {
			logger.error("Fallo en el metodo doFilter");
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	private String getTocken(HttpServletRequest request ) {
		String header = request.getHeader("Authorisation");
		
		if(header != null && header.startsWith("Bearer")) {
			return header.replace("Bearer","" );
		}
		
		return null;
	}

}
