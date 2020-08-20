package org.vladirius.classicmodel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.vladirius.classicmodel.data.models.LoginsEntity;
import org.vladirius.classicmodel.data.repositories.LoginRepository;

//@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;
	
	//retrieve all
	public List<LoginsEntity> getAllLogin(){
		List<LoginsEntity> loginList = new ArrayList<LoginsEntity>();
		for (LoginsEntity login : loginRepository.findAll()) {
			loginList.add(login);
		}
		return loginList;
	}
	
	public void updateLogin() {
		List<LoginsEntity> loginList = new ArrayList<LoginsEntity>();
		for (LoginsEntity login : loginRepository.findAll()) {
			loginList.add(login);
		}
		for (int i = 0; i < loginList.size(); i++) {
			loginList.get(i).setPwd(encrypt(loginList.get(i).getPassword()));
			loginRepository.save(loginList.get(i));
		}
	}
	
	public String encrypt(String rawPassword) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(rawPassword);
		return encodedPassword;
	}
}
