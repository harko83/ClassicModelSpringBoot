package org.vladirius.classicmodel.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vladirius.classicmodel.data.models.LoginsEntity;
import org.vladirius.classicmodel.service.LoginService;

//@RestController
@RequestMapping("/rest/logins")
public class LoginRestController {
	
	@Autowired
	LoginService service;
	
	@GetMapping("/listAll")
	public List<LoginsEntity> getAllLogin(){
		return service.getAllLogin();
	}
	
	@PostMapping("/upPwd")
	public void updatePWD() {
		service.updateLogin();
	}

}
