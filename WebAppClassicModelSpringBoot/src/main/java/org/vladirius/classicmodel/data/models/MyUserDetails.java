package org.vladirius.classicmodel.data.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LoginsEntity loginsEntity;
	
	public MyUserDetails(LoginsEntity loginsEntity) {
		this.loginsEntity = loginsEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = loginsEntity.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for(Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}
	
	public Long getId() {
		return loginsEntity.getLoginID();
	}
	
	public Long getCustomerNumber() {
		return loginsEntity.getCustomerNumber();
	}
	
	public Long getEmployeeNumber() {
		return loginsEntity.getEmployeeNumber();
	}

	@Override
	public String getPassword() {
		return loginsEntity.getPwd();
	}

	@Override
	public String getUsername() {
		return loginsEntity.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return loginsEntity.isEnabled();
	}
	
	public LoginsEntity getUserDetails() {
		return loginsEntity;
	}

}
