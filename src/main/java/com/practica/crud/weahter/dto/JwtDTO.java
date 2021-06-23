package com.practica.crud.weahter.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtDTO {
	
	private String tocken;
	private String bearer = "bearer";
	private String userName;
	private Collection<? extends GrantedAuthority> authorities;
	public JwtDTO(String tocken, String userName, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.tocken = tocken;
		this.userName = userName;
		this.authorities = authorities;
	}
	public String getTocken() {
		return tocken;
	}
	public void setTocken(String tocken) {
		this.tocken = tocken;
	}
	public String getBearer() {
		return bearer;
	}
	public void setBearer(String bearer) {
		this.bearer = bearer;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
}
