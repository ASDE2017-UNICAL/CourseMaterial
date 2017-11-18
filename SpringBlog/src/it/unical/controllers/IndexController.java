package it.unical.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.blog.services.BlogService;

@Controller
public class IndexController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("posts", blogService.getAllPosts());
		return "index";
	}
	
	@RequestMapping("/comment")
	public String addComment(@RequestParam int post, @RequestParam String comment, HttpSession session) {
		blogService.postComment(comment, post, (String) session.getAttribute("user"));
		return "redirect:/";
	}
	
	@RequestMapping("/ajaxRequest")
	@ResponseBody
	public String ajax() {
		return "Message from server";
	}
	
	
}
