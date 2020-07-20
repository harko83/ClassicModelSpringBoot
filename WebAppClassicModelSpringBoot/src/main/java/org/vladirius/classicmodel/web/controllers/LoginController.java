package org.vladirius.classicmodel.web.controllers;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.vladirius.classicmodel.data.models.LoginsEntity;
import org.vladirius.classicmodel.data.models.MyUserDetails;

@SessionAttributes({"currentUser"})
@Controller
public class LoginController {
	private static final Logger log = LogManager.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public String loginError(Model model) {
		log.info("Login attempt failed");
		model.addAttribute("error", "true");
		return "login";
	}
		
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus session) {
		SecurityContextHolder.getContext().setAuthentication(null);
		session.setComplete();
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/postLogin", method = RequestMethod.POST)
	public String postLogin(Model model, HttpSession session) {
		log.info("postLogin()");
		
		// read principal out of security context and set it to session
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		validatePrinciple(authentication.getPrincipal());
		LoginsEntity loggedInUser =  ((MyUserDetails) authentication.getPrincipal()).getUserDetails();
		
		model.addAttribute("currentUser", loggedInUser.getLogin());
		session.setAttribute("userId", loggedInUser.getLoginID());
		return "redirect:/index";
	}

	private void validatePrinciple(Object principal) {
		if(!(principal instanceof MyUserDetails)) {
			throw new IllegalArgumentException("Principal can not be null!");
		}
	}
	
}
