package org.vladirius.classicmodel.data.repositories;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.vladirius.classicmodel.data.models.LoginsEntity;

public class MyUserDetails implements UserDetails{

	private LoginsEntity loginsEntity;
	
	
	
	public MyUserDetails(LoginsEntity loginsEntity) {
		this.loginsEntity = loginsEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<E>
		return null;
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

}
