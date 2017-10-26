package it.unical.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.unical.blog.services.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/loginAttempt")
	public String loginAttempt(String username, String password, HttpSession session) {
		if(loginService.loginAttempt(username, password)) {
			session.setAttribute("user", username);
			return "redirect:/";
		}
		return "login";
	}
	

}
