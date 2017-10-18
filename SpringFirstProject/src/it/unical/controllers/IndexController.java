package it.unical.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String homePage(Model model) {
		//handle home page requests
		model.addAttribute("welcomeMessage", "Benvenuto!");
		return "index";
	}

}
