package it.unical.asde.login.controllers;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.asde.login.services.LoginService;

@Controller
public class IndexController {

	@Autowired
	private LoginService loginService;

	@PostConstruct
	public void init() {
		System.out.println("controller init");
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/loginAttempt")
	public String loginAttempt(@RequestParam String username, @RequestParam String password, HttpSession session) {

		if (loginService.loginAttempt(username, password)) {

			session.setAttribute("user", username);
			return "index";
		}
		return "login";

	}
}
