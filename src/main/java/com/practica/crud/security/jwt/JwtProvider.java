package com.practica.crud.security.jwt;

import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.practica.crud.weahter.model.UserPrincipal;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

//Crea un tocken si es necesario
@Component
public class JwtProvider {

	private final static org.slf4j.Logger logger =  LoggerFactory.getLogger(JwtProvider.class);
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private int expiration; 
	
	
	public String generateTocken (Authentication authentication) {
		
		UserPrincipal userPrinc = (UserPrincipal) authentication.getPrincipal();
		
		return Jwts.builder().setSubject(userPrinc.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + this.expiration * 1000))
				.signWith(SignatureAlgorithm.HS512, this.secret)
				.compact();
	}
	
	public String getUserNameFromTocken(String tocken) {
		return Jwts.parser().setSigningKey(this.secret).parseClaimsJws(tocken).getBody().getSubject();
	}
	
	public boolean validateTocken(String tocken) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJwt(tocken);
			return true;
			
		} catch (MalformedJwtException e) {
			logger.error("Tocken mal formado");
		} catch (UnsupportedJwtException e) {
			logger.error("Tocken no soportado");
		} catch (ExpiredJwtException e) {
			logger.error("Tocken ha expirado");
		} catch (IllegalArgumentException e) {
			logger.error("Tocken esta vacio");
		}catch (SignatureException e) {
			logger.error("Fallo en la firma");
		}
		return false;
	}
}
