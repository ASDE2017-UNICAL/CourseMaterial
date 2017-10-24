package it.unical.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.services.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@RequestMapping("/")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="/loginAttempt",method=RequestMethod.POST)
	public String loginAttempt(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
		
		if(loginService.loginAttempt(username, password)) {
			session.setAttribute("user", username);
			return "index";
		}
		
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}

}
