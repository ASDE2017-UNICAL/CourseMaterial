package it.unical.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="/loginAttempt",method=RequestMethod.POST)
	public String loginAttempt(@RequestParam String username, @RequestParam String password, Model model) {
		
		if(username.equals("ciccio") && password.equals("ciccio")) {
			model.addAttribute("welcomeMessage", "Benvenuto "+username);
			return "index";
		}
		return "login";
	}

}
